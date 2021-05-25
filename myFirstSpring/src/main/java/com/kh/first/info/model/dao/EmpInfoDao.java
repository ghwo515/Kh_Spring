package com.kh.first.info.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.first.emp.model.dto.EmpDto;
import com.kh.first.info.model.dto.EmpInfoDto;

@Repository("empInfoDao")
public class EmpInfoDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int empInfoCount() {
		return 0;
	}
	public EmpInfoDto selectOneEmpInfo(int empno) {
		return null;
	}
	public List<EmpInfoDto> selectListEmpInfo(int currentPage, int limit) {
		int startRow = (currentPage-1) * limit;
		RowBounds row = new RowBounds(startRow, limit);
		return sqlSession.selectList("EmpInfo.selectEmpInfo",null,row);
	}
	public int insertEmpInfo(EmpInfoDto dto) {
		return 0;
	}
	public int updateEmpInfo(EmpInfoDto dto) {
		return 0;
	}
	public int deleteEmpInfo(EmpInfoDto dto) {
		return 0;
	}
	
}
