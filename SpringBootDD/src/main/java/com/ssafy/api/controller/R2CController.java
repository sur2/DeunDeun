package com.ssafy.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.dto.Restaurant;
import com.ssafy.api.service.R2CService;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class R2CController {
	@Autowired
	private R2CService service;
	
//	@RequestMapping(value = "/{category_id}", method = RequestMethod.GET)
//	public List<Restaurant> selectRestaurantByCategoryId(@PathVariable int category_id) {
//		return service.selectRestaurantByCategoryId(category_id);
//	}
//	
	@RequestMapping(value = "/{category_id}/", method = RequestMethod.GET)
	public List<Restaurant> searchRestaurant(@PathVariable int category_id,@RequestParam("lon") double x, @RequestParam("lat") double y,
			@RequestParam("range") int range) {
		return service.searchRestaurantByCategoryId(category_id, x, y, range);
	}
}

