package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.service.DeptVO;

@SpringBootTest
class Work01ApplicationTests {

	@Autowired
	private DeptMapper deptMapper;
	
	@Test
	public void selectAll() {
		List<DeptVO> list = deptMapper.selectAll();
		for(DeptVO dept : list) {
			System.out.println(dept.getDepartmentName());
		}
		assertTrue(!list.isEmpty());
	}
	
//	@Test
	public void selectOne() {
		DeptVO dept = DeptVO.builder()
							.departmentId(100)
							.build();
		DeptVO findVO = deptMapper.selectInfo(dept);
		System.out.println(findVO);
		assertEquals("King", findVO.getDepartmentName());
	}
	
//  @Test
	public void insertValue() {
    	DeptVO dept = DeptVO.builder()
    					 .departmentId(1000)
    					 .departmentName("IT")
    					 .managerId(200)
    					 .locationId(20)
    					 .build();
    	int result = deptMapper.insertInfo(dept);
    	
    	assertEquals(1, result);
    }
  
	

}
