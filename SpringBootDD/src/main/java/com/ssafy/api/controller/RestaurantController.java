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

import com.ssafy.api.dto.Restaurant;
import com.ssafy.api.service.RestaurantService;

@CrossOrigin("*")
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	@Autowired
	private RestaurantService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Restaurant> selectAll() {
		return service.selectAll();
	}

	@RequestMapping(value = "/{restaurant_id}", method = RequestMethod.GET)
	public Restaurant selectOneById(@PathVariable int restaurant_id) {
		return service.selectOneById(restaurant_id);
	}

	@RequestMapping(value = "/lowest", method = RequestMethod.GET)
	public List<Restaurant> selectLowestPrice() {
		return service.selectLowestPrice();
	}

	@RequestMapping(value = "/here", method = RequestMethod.GET)
	public List<Restaurant> searchRestaurant(@RequestParam("lon") double x, @RequestParam("lat") double y,
			@RequestParam("range") int range) {
		return service.searchRestaurant(x, y, range);
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public Restaurant insertRestaurant(@RequestBody Restaurant restaurant) {
		service.insertOne(restaurant);
		return service.selectOneById(restaurant.getRestaurant_id());
	}
	
	@RequestMapping(value="/count",method=RequestMethod.GET)
	public int countAllRestaurants() {		
		return service.countAllRestaurants();
	}

}
