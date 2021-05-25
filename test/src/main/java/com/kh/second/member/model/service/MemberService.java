package com.kh.second.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.kh.second.member.model.dao.MemberDao;
import com.kh.second.member.model.vo.Member;

public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public Member selectMember(Member m) {
		return memberDao.selectMember(m);
	}

	public int insertMember(Member m) {
		return memberDao.insertMember(m);
	}

	public int updateMember(Member m) {
		return memberDao.updateMember(m);
	}

	public int deleteMember(String userid) {
		return memberDao.deleteMember(userid);
	}

	public Member checkIdDup(String userid) {
		return memberDao.checkIdDup(userid);
	}
}
