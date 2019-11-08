package com.ssafy.api.service;

import java.util.List;

import com.ssafy.api.dto.Reply;

public interface ReplyService {
	public Reply selectReplyById(int reply_id);
	public List<Reply> selectReplyByMemberId(int member_id);
	public List<Reply> selectAllReply();
	public int insertReply(Reply reply);
	public int updateReply(Reply reply);
	public int deleteReply(int reply_id);
}
