package com.ssafy.api.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.api.dto.QnA;
import com.ssafy.api.mapper.QnAMapper;

@Repository
public class QnARepositoryImpl implements QnARepository {
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public QnA selectQnAById(int qna_id) {
		QnAMapper mapper=template.getMapper(QnAMapper.class);
		return mapper.selectQnAById(qna_id);
	}

	@Override
	public List<QnA> selectQnAByMemberId(int member_id) {
		QnAMapper mapper=template.getMapper(QnAMapper.class);
		return mapper.selectQnAByMemberId(member_id);
	}

	@Override
	public List<QnA> selectAllQnA() {
		QnAMapper mapper=template.getMapper(QnAMapper.class);
		return mapper.selectAllQnA();
	}

	@Override
	public int insertQnA(QnA qna) {
		QnAMapper mapper=template.getMapper(QnAMapper.class);
		return mapper.insertQnA(qna);
	}

	@Override
	public int updateQnA(QnA qna) {
		QnAMapper mapper=template.getMapper(QnAMapper.class);
		return mapper.updateQnA(qna);
	}

	@Override
	public int deleteQnA(int qna_id) {
		QnAMapper mapper=template.getMapper(QnAMapper.class);
		return mapper.deleteQnA(qna_id);
	}

}
