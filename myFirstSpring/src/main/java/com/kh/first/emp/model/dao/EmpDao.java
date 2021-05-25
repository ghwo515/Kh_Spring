package com.kh.first.emp.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.first.emp.model.dto.EmpDto;

@Repository("empDao")
public class EmpDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int empCount() {
		return 0;
	}
	public EmpDto selectOneEmp(int empno) {
		return null;
	}
	public List<EmpDto> selectListEmp(int currentPage, int limit) {
		int startRow = (currentPage-1) * limit;
		RowBounds row = new RowBounds(startRow, limit);
		return sqlSession.selectList("Emp.selectEmp",null,row);
	}
	public int insertEmp(EmpDto dto) {
		return sqlSession.insert("Emp.insertEmp", dto);
	}
	public int updateEmp(EmpDto dto) {
		return 0;
	}
	public int deleteEmp(EmpDto dto) {
		return 0;
	}
	
}
