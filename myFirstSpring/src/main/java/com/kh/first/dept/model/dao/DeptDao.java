package com.kh.first.dept.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.first.dept.model.dto.DeptDto;


@Repository("deptDao")
public class DeptDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int deptCount() {
		return 0;
	}
	public DeptDto selectOneDept(int deptno) {
		return null;
	}
	public List<DeptDto> selectListDept(int currentPage, int limit) {
		int startRow = (currentPage-1) * limit;
		RowBounds row = new RowBounds(startRow, limit);
		return sqlSession.selectList("Dept.selectDept",null,row);
	}
	public int insertDept(DeptDto dto) {
		return sqlSession.insert("Dept.insertDept", dto);
	}
	public int updateDept(DeptDto dto) {
		return 0;
	}
	public int deleteDept(DeptDto dto) {
		return 0;
	}
	
}
