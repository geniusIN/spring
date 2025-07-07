package com.yedam.app.common.config;

import org.springframework.web.bind.annotation.ControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class WebControllerAdvice {
	// 예외처리
	// 공통 변수 선언
	public String contextPath(final HttpServletRequest request) {
		return request.getContextPath();
	}
	
}
