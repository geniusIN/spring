package com.yedam.app.common.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@CrossOrigin(origins = "*") // (ajax 방식으로 처리) cors 걸리면 문제생기기 때문에 미리 설정
@Controller
public class ParameterController {
	// QueryString(질의문자열) : key=value&key=value&... *반복*
	// Content-type : application/x-www-form-urlencoded
	// Method : 상관없음
	
	// (QueryString, 1) 커맨드 객체 (어노테이션 사용X, 객체)
	@RequestMapping("comobj")
	@ResponseBody // AJAX : 필요한 데이터만 가지고와서 부분수정 페이지 전체를 새로고침 하지않기위해 사용함 location.hrf 사용x
	public String commandObject(EmpVO empVO) {
		String result = "";
		result += "Path : /comobj \n";
		result += "\t employee_id : " + empVO.getEmployeeId();
		result += "\t last_name : " + empVO.getLastName();
		return result;
	}
	
	// @PathVariable : 경로에 값을 포함하는 방식, 단일 값
	// Method는 상관없음
	// Content-type도 상관없음
	
    // @RequestBody : JSON 포맷, 배열 or 객체
	// Method : POST, PUT
	// Content-type : application/json
	
	// QueryString, 2) @RequestParam (기본타입, 단일값)
	@RequestMapping("reqparm")
	@ResponseBody
	public String requestParam
	(@RequestParam Integer employeeId, // 필수
			String lastName) {		// 생략 가능
		String result = "";
		result += "path : /reqparm \n";
		result += "\t employee_id : " + employeeId;
		result += "\t last_name : " + lastName;
		return result;
	}
	
	@RequestMapping("path/{id}")
	@ResponseBody
	public String pathVariable(@PathVariable String id) {
		String result = "";
		result += "path : /path/{id} \n";
		result += "\t id : " + id;
		return result;
	}
	// @RequestBody : JSON 포맷, 배열 or 객체
	// Method : POST, PUT
	// Content-type : application/json
	@PostMapping("resbody")
    @ResponseBody
    public EmpVO resquestBody(@RequestBody EmpVO empVO)    {
        return empVO;
    }
	
	@PostMapping("resbodyList")
	@ResponseBody
	public List<EmpVO> resbodyList
				(@RequestBody List<EmpVO> list) {
		return list;
	}
	
	
}
