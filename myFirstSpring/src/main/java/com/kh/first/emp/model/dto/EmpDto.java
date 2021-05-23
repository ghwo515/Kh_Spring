package com.kh.first.emp.model.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class EmpDto {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;

}
