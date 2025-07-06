package com.yedam.app.dept.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.service.DeptVO;
import com.yedam.app.service.DeptService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DeptController {

	private final DeptService deptService;
	
	// 전체조회: GET
	@GetMapping("deptList")
	public String deptList(Model model) {
		List<DeptVO> list = deptService.findAllList();
		model.addAttribute("depts", list);
		return "emp/list";
	}
	
	// 단건조회: Get
	@GetMapping("deptInfo")
	public String deptInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.findInfoById(deptVO);
		model.addAttribute("dept", findVO);		
		return "dept/info";
	}
	
	// 등록 - 페이지: GET
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
	}
	
	// 등록 - 처리: Post
	@PostMapping("deptInsert")
	public String deptInserProcess(DeptVO deptVO) {
		int deptId = deptService.createInfo(deptVO);
		String url = null;
		if(deptId > -1) {
			// 정상등록
			url = "redirect:deptInfo?departmentId = " + deptId;
		} else {
			// 등록 실패
			url = "redirect:deptList";
		}
		return "";
	}
	
	
}
