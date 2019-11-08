package com.ssafy.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.dto.Notice;
import com.ssafy.api.service.NoticeService;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/notice")
public class NoticeController {
	@Autowired
	public NoticeService service;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Notice> selectAllNotice() {
		return service.selectAllNotice();
	}
	
//	@RequestMapping(value = "/{restaurant_id}", method = RequestMethod.GET)
//	public List<Notice> selectFoodByRestaurantId(@PathVariable int restaurant_id) {
//		return service.(restaurant_id);
//	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public int insertNotice(@RequestBody Notice notice) {
		return service.insertNotice(notice);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public int deleteNotice(@RequestParam("notice_id") int notice_id){
		return service.deleteNotice(notice_id);
	}
	
}