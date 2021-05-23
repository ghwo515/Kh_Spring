package com.kh.first.dept.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.first.dept.model.dao.DeptDao;
import com.kh.first.dept.model.dto.DeptDto;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao deptDao;
	
	@Override
	public List<DeptDto> selectListDept() {
		return deptDao.selectListDept();
	}

}
