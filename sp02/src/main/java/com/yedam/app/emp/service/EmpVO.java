package com.yedam.app.emp.service;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // (@Data => getter, setter) 데이터를 변경하는일이 많아 사용함
@Builder // 만들려고하는 클래스를 생성할때 셋팅해야 하는 초깃값들을 반환
@AllArgsConstructor
@NoArgsConstructor // @빌더 시 생략되므로 명시적으로 추가
public class EmpVO {
	// employee_id이 => employeeId 으로 변환 => setEmployeeId 라는 setter를 실행 (mybatis가 _를 카멜케이스로 변환해서 이걸 기반으로 setter 를 실행함.)
	// 설정이 없다면 이렇게됌 employee_id => setEmployee_id
	private Integer employeeId;
	private String lastName;
	private String email;
	private Date hireDate;
	private String jobId;
	private double salary;
	
}
