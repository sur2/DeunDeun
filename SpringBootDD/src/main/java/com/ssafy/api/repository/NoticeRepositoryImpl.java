package com.ssafy.api.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.api.dto.Notice;
import com.ssafy.api.mapper.NoticeMapper;

@Repository
public class NoticeRepositoryImpl implements NoticeRepository {
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<Notice> selectAllNotice() {
		NoticeMapper mapper = template.getMapper(NoticeMapper.class);
		return mapper.selectAllNotice();
	}

	@Override
	public Notice selectNoticeById(int notice_id) {
		NoticeMapper mapper = template.getMapper(NoticeMapper.class);
		return mapper.selectNoticeById(notice_id);
	}

	@Override
	public Notice selectNoticeByMember_id(int member_id) {
		NoticeMapper mapper = template.getMapper(NoticeMapper.class);
		return mapper.selectNoticeByMember_id(member_id);
	}

	@Override
	public int insertNotice(Notice notice) {
		NoticeMapper mapper = template.getMapper(NoticeMapper.class);
		return mapper.insertNotice(notice);
	}

	@Override
	public int updateNotice(Notice notice) {
		NoticeMapper mapper = template.getMapper(NoticeMapper.class);
		return mapper.updateNotice(notice);
	}

	@Override
	public int deleteNotice(int notice_id) {
		NoticeMapper mapper = template.getMapper(NoticeMapper.class);
		return mapper.deleteNotice(notice_id);
	}

}
