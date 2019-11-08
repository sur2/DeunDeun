package com.ssafy.api.dto;

public class Notice {
	private int notice_id;
	private String title;
	private int member_id;
	private String contents;

	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Notice(String title, int member_id, String contents) {
		super();
		this.title = title;
		this.member_id = member_id;
		this.contents = contents;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(int notice) {
		this.notice_id = notice;
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
		return "Notice [notice_id=" + notice_id + ", title=" + title + ", member_id=" + member_id + ", contents="
				+ contents + "]";
	}
	
}
