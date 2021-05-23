package com.kh.first.dept.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.first.dept.model.dto.DeptDto;

@Repository("deptDao")
public class DeptDao {
		@Autowired
		private SqlSession sqlSession;
		
		public List<DeptDto> selectListDept(){
			return sqlSession.selectList("Dept.selectDept");
		}
}
