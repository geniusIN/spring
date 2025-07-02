package com.yedam.app.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DeptVO {

	private Integer departmentId;
	private String departmentName;
	private Integer managerId;
	private Integer locationId;
}
