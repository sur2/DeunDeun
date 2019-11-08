package com.ssafy.api.service;

import java.util.List;

import com.ssafy.api.dto.Notice;

public interface NoticeService {
	public List<Notice> selectAllNotice();
	public Notice selectNoticeById(int notice_id);
	public Notice selectNoticeByMember_id(int member_id);
	public int insertNotice(Notice notice);
	public int updateNotice(Notice notice);
	public int deleteNotice(int notice_id);
}
