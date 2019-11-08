package com.ssafy.api.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.api.dto.Reply;
import com.ssafy.api.mapper.ReplyMapper;
@Repository
public class ReplyRepositoryImpl implements ReplyRepository {
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public Reply selectReplyById(int reply_id) {
		ReplyMapper mapper=template.getMapper(ReplyMapper.class);
		return mapper.selectReplyById(reply_id);
	}

	@Override
	public List<Reply> selectReplyByMemberId(int member_id) {
		ReplyMapper mapper=template.getMapper(ReplyMapper.class);
		return mapper.selectReplyByMemberId(member_id);
	}

	@Override
	public List<Reply> selectAllReply() {
		ReplyMapper mapper=template.getMapper(ReplyMapper.class);
		return mapper.selectAllReply();
	}

	@Override
	public int insertReply(Reply reply) {
		ReplyMapper mapper=template.getMapper(ReplyMapper.class);
		return mapper.insertReply(reply);
	}

	@Override
	public int updateReply(Reply reply) {
		ReplyMapper mapper=template.getMapper(ReplyMapper.class);
		return mapper.updateReply(reply);
	}

	@Override
	public int deleteReply(int reply_id) {
		ReplyMapper mapper=template.getMapper(ReplyMapper.class);
		return mapper.deleteReply(reply_id);
	}

}
