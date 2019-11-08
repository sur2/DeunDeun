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

import com.ssafy.api.dto.Favorite;
import com.ssafy.api.dto.Restaurant;
import com.ssafy.api.service.FavoriteService;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/favorite")
public class FavoriteController {
	@Autowired
	public FavoriteService service;
	
	@RequestMapping(value = "/member/{member_id}", method = RequestMethod.GET)
	public List<Restaurant> selectFavoritesByMemberId(@PathVariable int member_id) {
		return service.selectFavoritesByMemberId(member_id);
	}
	
	@RequestMapping(value = "/member/{member_id}/restaurant/{restaurant_id}", method = RequestMethod.GET)
	public Favorite checkFavorite(@PathVariable int member_id,@PathVariable int restaurant_id) {
		Favorite favorite=new Favorite();
		favorite.setMember_id(member_id);
		favorite.setRestaurant_id(restaurant_id);
		return service.checkFavorite(favorite);
	}
	
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public int insertFavorite(@RequestBody Favorite favorite) {
		return service.insertFavorite(favorite);
	}
	
	@RequestMapping(value="/delete",method = RequestMethod.DELETE)
	public int deleteFavorite(@RequestParam("favorite_id") int favorite_id) {
		System.out.println(favorite_id);
		return service.deleteFavorite(favorite_id);
	}
	
}
