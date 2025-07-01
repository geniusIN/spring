package com.yedam.app.service;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class EmpVO {
	// employee_id => employeeId => setEmployeeId
	private Integer employeeId; 
	private String lastName; 
	private String email; 
	private Date hireDate; 
	private String jobId; 
	private Integer salary;
}
