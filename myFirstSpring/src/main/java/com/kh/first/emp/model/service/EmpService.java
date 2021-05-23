package com.kh.first.emp.model.service;

import java.util.List; 

import com.kh.first.emp.model.dto.EmpDto;

public interface EmpService {
	public int empCount();
	public EmpDto selectOneEmp(int empno);
	public List<EmpDto> selectListEmp(int startPage, int limit);
	public int insertEmp(EmpDto dto);
	public int updateEmp(EmpDto dto);
	public int deleteEmp(EmpDto dto);
}
