package com.ssafy.api.service;

import java.util.List;

import com.ssafy.api.dto.Members;

public interface MembersService {
	public List<Members> selectAllMembers();
	public List<Members> membersByType(String grade);
	public Members selectMemberById(int member_id);
	public Members selectMemberByEmail(String email);
	public int insertMember(Members member);
	public int updateMember(Members member);
	public int deleteMember(int members_id);
	public int countAllMembers();
}
