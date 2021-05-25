package com.kh.first.info.model.dto;

import org.springframework.stereotype.Component;

@Component
public class EmpInfo {
	private int empno;
	private String ename;
	private String dname;
	private String loc;
	
	@Override
	public String toString() {
		return "EmpInfo [empno=" + empno + ", ename=" + ename + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
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
