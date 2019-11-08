package com.ssafy.api.repository;

import java.util.List;

import com.ssafy.api.dto.QnA;

public interface QnARepository {
	public QnA selectQnAById(int qna_id);
	public List<QnA> selectQnAByMemberId(int member_id);
	public List<QnA> selectAllQnA();
	public int insertQnA(QnA qna); 
	public int updateQnA(QnA qna);
	public int deleteQnA(int qna_id);
}
