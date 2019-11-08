package com.ssafy.api.dto;

public class QnA {
	private int qna_id;
	private int member_id;
	private String contents;

	public QnA() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getQna_id() {
		return qna_id;
	}

	public void setQna_id(int qna_id) {
		this.qna_id = qna_id;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "QnA [qna_id=" + qna_id + ", member_id=" + member_id + ", contents=" + contents + "]";
	}

}
