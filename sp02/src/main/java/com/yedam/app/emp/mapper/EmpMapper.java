package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	// Mapper 의 골격 실제 실행하는건 => sql (sql은 자바에서 인식할수 없는 대상)
	
	// CRUD
	// 전체조회 : 다건이면 LIST타입 단건이면 객체타입
	public List<EmpVO> selectAll();
	
	// 단건조회
	public EmpVO selectInfo(EmpVO empVO);
	
	// 등록수정삭제는 리턴타입은 int타입(그 쿼리문으로 실행된 행 갯수) or void타입 으로 정해져있음 다른건 에러뜸
	// 등록
	public int insertInfo(EmpVO empVO);
	
	// 수정
	public int updateInfo(@Param("id")int eid, @Param("info")EmpVO empVO);
	
	// 삭제
	public int deleteInfo(int employeeid);
	
}
