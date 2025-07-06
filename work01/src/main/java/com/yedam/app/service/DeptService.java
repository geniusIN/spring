package com.yedam.app.service;

import java.util.List;

// 실제로 사용자에게 제공하는 기능 : Business Layer 영역
public interface DeptService {
	// 전체 사원정보 조회
	public List<DeptVO> findAllList();
	// 사원정보 단건 조회
	public DeptVO findInfoById(DeptVO DeptVO);
	// 사원정보 단건 등록
	public int createInfo(DeptVO DeptVO);
}
