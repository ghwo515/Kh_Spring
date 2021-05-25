package com.kh.first.info.model.service;

import java.util.List;

import com.kh.first.info.model.dto.EmpInfoDto;


public interface EmpInfoService {
	public int empInfoCount();
	public EmpInfoDto selectOneEmpInfo(int empno);
	public List<EmpInfoDto> selectListEmpInfo(int startPage, int limit);
	public int insertEmpInfo(EmpInfoDto dto);
	public int updateEmpInfo(EmpInfoDto dto);
	public int deleteEmpInfo(EmpInfoDto dto);
}
