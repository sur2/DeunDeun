package com.ssafy.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.dto.Members;
import com.ssafy.api.repository.MembersRepository;

@Service
public class MembersServiceImpl implements MembersService{
	@Autowired
	private MembersRepository repo;

	@Override
	public List<Members> selectAllMembers() {
		return repo.selectAllMembers();
	}

	@Override
	public List<Members> membersByType(String grade) {
		return repo.membersByType(grade);
	}

	@Override
	public Members selectMemberById(int member_id) {
		return repo.selectMemberById(member_id);
	}

	@Override
	public Members selectMemberByEmail(String email) {
		return repo.selectMemberByEmail(email);
	}

	@Override
	public int insertMember(Members member) {
		return repo.insertMember(member);
	}

	@Override
	public int updateMember(Members member) {
		return repo.updateMember(member);
	}

	@Override
	public int deleteMember(int members_id) {
		return repo.deleteMember(members_id);
	}

	@Override
	public int countAllMembers() {
		return repo.countAllMembers();
	}
}
