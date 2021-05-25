package com.kh.first.info.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.first.info.model.dto.EmpInfo;

@Repository("empInfoDao")
public class EmpInfoDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<EmpInfo> selectListEmpInfo() {
		return sqlSession.selectList("EmpInfo.selectEmpInfo");
	}
}
