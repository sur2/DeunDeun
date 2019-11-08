package com.ssafy.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.dto.QnA;
import com.ssafy.api.repository.QnARepository;

@Service
public class QnAServiceImpl implements QnAService {
	@Autowired
	private QnARepository repo;
	
	@Override
	public QnA selectQnAById(int qna_id) {
		return repo.selectQnAById(qna_id);
	}

	@Override
	public List<QnA> selectQnAByMemberId(int member_id) {
		return repo.selectQnAByMemberId(member_id);
	}

	@Override
	public List<QnA> selectAllQnA() {
		return repo.selectAllQnA();
	}

	@Override
	public int insertQnA(QnA qna) {
		return repo.insertQnA(qna);
	}

	@Override
	public int updateQnA(QnA qna) {
		return repo.updateQnA(qna);
	}

	@Override
	public int deleteQnA(int qna_id) {
		return repo.deleteQnA(qna_id);
	}
}
