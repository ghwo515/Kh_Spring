package com.kh.first.dept.model.dto;
//
//EMPNO    NOT NULL NUMBER       
//ENAME             VARCHAR2(10) 
//JOB               VARCHAR2(9)  
//MGR               NUMBER       
//HIREDATE          DATE         
//SAL               NUMBER       
//COMM              NUMBER       
//DEPTNO   NOT NULL NUMBER

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class DeptDto {
	private int deptno;
	private String dname;
	private String loc;
	
	@Override
	public String toString() {
		return "DeptDto [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
