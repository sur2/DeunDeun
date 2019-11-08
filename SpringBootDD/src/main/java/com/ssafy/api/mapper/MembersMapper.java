package com.ssafy.api.mapper;

import java.util.List;

import com.ssafy.api.dto.Members;

public interface MembersMapper {
	public List<Members> selectAllMembers();
	public List<Members> MembersByType(String grade);
	public Members selectMemberById(int member_id);
	public Members selectMemberByEmail(String email);
	public int insertMember(Members member);
	public int updateMember(Members member);
	public int deleteMember(int members_id);
	public int countAllMembers();
}
