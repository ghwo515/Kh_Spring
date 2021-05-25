package com.kh.first.dept.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.first.emp.model.dao.EmpDao;
import com.kh.first.emp.model.dto.EmpDto;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
	@Autowired
	private EmpDao empDao;
	
	@Override
	public int empCount() {
		return empDao.empCount();
	}

	@Override
	public EmpDto selectOneEmp(int empno) {
		return empDao.selectOneEmp(empno);
	}

	@Override
	public List<EmpDto> selectListEmp(int startPage, int limit) {
		return empDao.selectListEmp(startPage, limit);
	}

	@Override
	public int insertEmp(EmpDto dto) {
		return empDao.insertEmp(dto);
	}

	@Override
	public int updateEmp(EmpDto dto) {
		return empDao.updateEmp(dto);
	}

	@Override
	public int deleteEmp(EmpDto dto) {
		return empDao.deleteEmp(dto);
	}

}
