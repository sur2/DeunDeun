package com.ssafy.api.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.api.dto.Members;
import com.ssafy.api.mapper.MembersMapper;

@Repository
public class MembersRepositoryImpl implements MembersRepository {
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<Members> selectAllMembers() {
		MembersMapper mapper = template.getMapper(MembersMapper.class);
		return mapper.selectAllMembers();
	}

	@Override
	public List<Members> membersByType(String grade) {
		MembersMapper mapper = template.getMapper(MembersMapper.class);
		return mapper.MembersByType(grade);
	}

	@Override
	public Members selectMemberById(int member_id) {
		MembersMapper mapper = template.getMapper(MembersMapper.class);
		return mapper.selectMemberById(member_id);
	}

	@Override
	public Members selectMemberByEmail(String email) {
		MembersMapper mapper = template.getMapper(MembersMapper.class);
		return mapper.selectMemberByEmail(email);
	}

	@Override
	public int insertMember(Members member) {
		MembersMapper mapper = template.getMapper(MembersMapper.class);
		return mapper.insertMember(member);
	}

	@Override
	public int updateMember(Members member) {
		MembersMapper mapper = template.getMapper(MembersMapper.class);
		return mapper.updateMember(member);
	}

	@Override
	public int deleteMember(int members_id) {
		MembersMapper mapper = template.getMapper(MembersMapper.class);
		return mapper.deleteMember(members_id);
	}

	@Override
	public int countAllMembers() {
		MembersMapper mapper = template.getMapper(MembersMapper.class);
		return mapper.countAllMembers();
	}

}
