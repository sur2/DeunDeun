package com.ssafy.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.dto.Notice;
import com.ssafy.api.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeRepository repo;

	@Override
	public List<Notice> selectAllNotice() {
		return repo.selectAllNotice();
	}

	@Override
	public Notice selectNoticeById(int notice_id) {
		return repo.selectNoticeById(notice_id);
	}

	@Override
	public Notice selectNoticeByMember_id(int member_id) {
		return repo.selectNoticeByMember_id(member_id);
	}

	@Override
	public int insertNotice(Notice notice) {
		return repo.insertNotice(notice);
	}

	@Override
	public int updateNotice(Notice notice) {
		return repo.updateNotice(notice);
	}

	@Override
	public int deleteNotice(int notice_id) {
		return repo.deleteNotice(notice_id);
	}
}
