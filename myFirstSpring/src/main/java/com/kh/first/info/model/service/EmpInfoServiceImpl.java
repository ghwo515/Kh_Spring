package com.kh.first.info.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kh.first.info.model.dao.EmpInfoDao;
import com.kh.first.info.model.dto.EmpInfoDto;

@Service("empInfoService")
public class EmpInfoServiceImpl implements EmpInfoService {
	@Autowired
	private EmpInfoDao empInfoDao;
	
	@Override
	@Transactional
	public int empInfoCount() {
		return empInfoDao.empInfoCount();
	}

	@Override
	public EmpInfoDto selectOneEmpInfo(int empno) {
		return empInfoDao.selectOneEmpInfo(empno);
	}

	@Override
	@Transactional
	public List<EmpInfoDto> selectListEmpInfo(int startPage, int limit) {
		return empInfoDao.selectListEmpInfo(startPage, limit);
	}

	@Override
	public int insertEmpInfo(EmpInfoDto dto) {
		return empInfoDao.insertEmpInfo(dto);
	}

	@Override
	public int updateEmpInfo(EmpInfoDto dto) {
		return empInfoDao.updateEmpInfo(dto);
	}

	@Override
	public int deleteEmpInfo(EmpInfoDto dto) {
		return empInfoDao.deleteEmpInfo(dto);
	}

}
