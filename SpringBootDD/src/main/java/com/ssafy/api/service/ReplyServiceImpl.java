package com.ssafy.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.dto.Reply;
import com.ssafy.api.repository.ReplyRepository;
@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyRepository repo;
	
	@Override
	public Reply selectReplyById(int reply_id) {
		return repo.selectReplyById(reply_id);
	}

	@Override
	public List<Reply> selectReplyByMemberId(int member_id) {
		return repo.selectReplyByMemberId(member_id);
	}

	@Override
	public List<Reply> selectAllReply() {
		return repo.selectAllReply();
	}

	@Override
	public int insertReply(Reply reply) {
		return repo.insertReply(reply);
	}

	@Override
	public int updateReply(Reply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReply(int reply_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
