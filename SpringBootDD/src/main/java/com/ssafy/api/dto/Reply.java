package com.ssafy.api.dto;

public class Reply {
	private int reply_id;
	private int qna_id;
	private int member_id;
	private String contents;

	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReply_id() {
		return reply_id;
	}

	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
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
		return "Reply [reply_id=" + reply_id + ", qna_id=" + qna_id + ", member_id=" + member_id + ", contents="
				+ contents + "]";
	}

}
