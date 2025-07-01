package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.service.EmpVO;

@SpringBootTest
class Sp02ApplicationTests {

    @Autowired // 필드주입 : 테스트용
    private EmpMapper empMapper;
    
//    @Test // 해당 메서드를 테스트하겠다고 선언!
    public void selectAll() {
        List<EmpVO> list = empMapper.selectAll();
        for(EmpVO emp : list) {
            System.out.println(emp.getLastName());
        }
        assertTrue(!list.isEmpty());
    }
    
//    @Test
    public void selectOne() {
        EmpVO emp = EmpVO.builder() //빌더가 하는 역할 1) instance create 2) field init 
                            .employeeId(100)
                            .build();
        
        EmpVO findVO = empMapper.selectInfo(emp);
        System.out.println(findVO);
        assertEquals("King", findVO.getLastName());
    }
    
//    @Test
    public void insertValue() {
    	EmpVO emp = EmpVO.builder()
    					 .employeeId(1000)
    					 .lastName("Kang")
    					 .email("kg@google.com")
    					 .jobId("SA_REP")
    					 .build();
    	int result = empMapper.insertInfo(emp);
    	
    	assertEquals(1, result);
    }
    
    @Test
    public void insertSelectKey() {
    	EmpVO emp = EmpVO.builder()
    					 .lastName("Hong")
    					 .email("hong@naver.com")
    					 .jobId("IT_PROG")
    					 .salary(1200)
    					 .build();
    	
    	int result = empMapper.insertInfo(emp);
    	System.out.println("사원번호 : " + emp.getEmployeeId());
    	
    	assertEquals(1, result);
    }
}