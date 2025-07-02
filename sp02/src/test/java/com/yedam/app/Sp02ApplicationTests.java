package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Sp02ApplicationTests {
	@Autowired // 필드주입 : 테스트용 (DI) 
	private EmpMapper empMapper; // 자기 자신을 강제로 참조하는 형태로 돌아버림 spring은 외부껀데 private 라서 안될것같았음.
	
    @Test // 해당 메서드를 테스트하겠다고 선언! Test 이노테이션이 붙은 메서드만 실행하겠다는 의미.
	public void selectAll() {// 빌더패턴을 사용하면 @data는 기본생성자 안만들어줌
		List<EmpVO> list = empMapper.selectAll();
		// 향상된 for문 : 배열이 가지고있는 모든것을 ??
		for (EmpVO emp : list){
			System.out.println(emp.getLastName());
		}
		// 단정메서드 : 아래코드는 사실임을 단정한다는뜻
		assertTrue(!list.isEmpty()); // !list.isEmpty() list타입은 생성 select 하고나면 결과없음 list타입은 값이없음 isEmpty => 내부에 값이 있는지 없는지 check
	}
	
	@Test
	public void selectOne() {
		EmpVO emp = EmpVO.builder().employeeId(100).build();
		
		EmpVO findVO = empMapper.selectInfo(emp);
		System.out.println(findVO);
		
		assertEquals("King", findVO.getLastName()); // 내가 넘긴 매개값과 결과값이 같은지 확인
	}
	
//	@Test
//	public void insertValue() {
//		EmpVO emp = EmpVO.builder().employeeId(1002).lastName("Kang").email("kg@goog23le.com").jobId("SA_REP").build();
//		
//		int result = empMapper.insertInfo(emp);
//		
//		assertEquals(1, result);
//	}
	
	@Test
	public void insertSelectKey() {
		EmpVO emp = EmpVO.builder().lastName("Hong").email("hong@naver.com").jobId("IT_PROG").salary(1200).build();
		
		int result = empMapper.insertInfo(emp);
		System.out.println("사원번호 : " + emp.getEmployeeId());
		
		assertEquals(1, result);
	}
	
	@Test
	public void updateInfo() {
		// 1) 단건조회
		EmpVO emp = EmpVO.builder().employeeId(4322).build(); // build패턴(디자인패턴) : 생성하는패턴
		EmpVO findVO = empMapper.selectInfo(emp);
		
		// 2) 값 변경
		findVO.setSalary(2550);
		
		// 3) 테이블에 업데이트
		int result = empMapper.updateInfo(4322, findVO);
		
		assertEquals(1, result);
		
	}
}

// error : 컨테이너에 해당 빈이 존재하지않음.
