package com.ssafy.api.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class Members {
	private int member_id;
	private String name;
	private String nickname;
	private String email;
	private String password;
	private String tel;
	private String grade;
	private LocalDateTime create_at;

	public Members() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public LocalDateTime getCreate_at() {
		return create_at;
	}

	public void setCreate_at(LocalDateTime create_at) {
		this.create_at = create_at;
	}

	@Override
	public String toString() {
		return "Members [member_id=" + member_id + ", name=" + name + ", nickname=" + nickname + ", email=" + email
				+ ", password=" + password + ", tel=" + tel + ", grade=" + grade + ", create_at=" + create_at + "]";
	}

}
