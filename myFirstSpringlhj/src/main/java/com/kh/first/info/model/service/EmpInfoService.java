package com.kh.first.info.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.first.info.model.dao.EmpInfoDao;
import com.kh.first.info.model.dto.EmpInfo;

@Service("empInfoService")
public class EmpInfoService {
	@Autowired
	private EmpInfoDao empInfoDao;
	
	@Transactional
	public List<EmpInfo> selectListEmpInfo() {
		return empInfoDao.selectListEmpInfo();
	}
}
