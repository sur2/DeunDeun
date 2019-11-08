package com.ssafy.api.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.dto.Auth;
import com.ssafy.api.dto.Members;
import com.ssafy.api.service.MembersService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/members", method = RequestMethod.POST)
public class MembersController {
	
	@Autowired
	public MembersService membersService;
	
	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public List<Members> tete() {
		return membersService.selectAllMembers();
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Members insertMember(@RequestBody Members member) {
		System.out.println("컨트롤러단 "+member.getName());
		membersService.insertMember(member);
		return membersService.selectMemberById(member.getMember_id());
	}	
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public int countAllMembers() {
		return membersService.countAllMembers();
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Auth Login(@RequestBody Members member) {
		System.out.println(member);	
		Members existMember= membersService.selectMemberByEmail(member.getEmail());
		Auth auth=new Auth();
		if(existMember!=null) {
			if(existMember.getPassword().equals(member.getPassword())){
				String s=existMember.getMember_id()+","+existMember.getName()+","+existMember.getNickname()+","+existMember.getEmail()+","
						+existMember.getTel()+","+existMember.getGrade()+","+existMember.getCreate_at();
				auth.setDDToken(s);
			}else {
				auth.setDDToken(",,,,,,,passwordError");
				System.out.println(",,,,,,,PWError");
			}
		}else {
			auth.setDDToken("userError");
		}
		return auth;
	}
	
	
	@RequestMapping(value="/check",method=RequestMethod.POST)
	public String Check(@RequestBody Members member) {
		System.out.println(member);	
		Members existMember= membersService.selectMemberByEmail(member.getEmail());
		if(existMember!=null) {
			if(existMember.getPassword().equals(member.getPassword())){
				return "Success";
			}else {
				return "passwordError";
			}
		}else {
			return "userError";
		}
	}	

	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public String Update(@RequestBody Members member) {
		System.out.println(member);	
		Members existMember= membersService.selectMemberByEmail(member.getEmail());
		System.out.println(existMember);
		if(existMember!=null) {
			existMember.setNickname(member.getNickname());
			existMember.setPassword(member.getPassword());
			membersService.updateMember(existMember);
			return "UpdateSuccess";
		}else {
			return "notExistMemberError";
		}
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public String Delete(@RequestParam("member_id")int member_id) {
		Members existMember= membersService.selectMemberById(member_id);
		if(existMember!=null) {
			membersService.deleteMember(member_id);
			return "true";
		}else {
			return "false";
		}
	}	
}
