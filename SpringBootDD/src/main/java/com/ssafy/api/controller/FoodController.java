package com.ssafy.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.dto.Food;
import com.ssafy.api.service.FoodService;



@CrossOrigin("*")
@RestController
@RequestMapping(value = "/food", method = RequestMethod.POST)
public class FoodController {
	@Autowired
	public FoodService service;
	
	@RequestMapping(value = "/{restaurant_id}", method = RequestMethod.GET)
	public List<Food> selectFoodByRestaurantId(@PathVariable int restaurant_id) {
		return service.selectFoodByRestaurantId(restaurant_id);
	}
}
