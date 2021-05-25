package com.kh.second.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.second.member.model.vo.Member;

@Repository("memberDao")
public class MemberDao {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private Member member;
	
	public Member checkIdDup(String userid) {
		member = sqlSession.selectOne("Member.memberInfo", userid);
		return member;
	}
	
	public Member selectMember(Member m) {
		member = sqlSession.selectOne("Member.loginCheck", m);
		return member;
	}
	
	public int insertMember(Member m) {
		int result = 0;
		result = sqlSession.insert("Member.insertMember", m);
		
		if(result>0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		return result;
	}
	
	public int updateMember(Member m) {
		int result = 0;
		result = sqlSession.update("Member.updateMember", m);
		
		if(result>0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		return result;
	}
	
	public int deleteMember(String userid) {
		int result = 0;
		result = sqlSession.delete("Member.deleteMember", userid);
		
		if(result>0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		return result;
	}
}
