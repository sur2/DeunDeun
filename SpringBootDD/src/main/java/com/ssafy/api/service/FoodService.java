package com.ssafy.api.service;

import java.util.List;

import com.ssafy.api.dto.Food;

public interface FoodService {
	public List<Food> selectFoodByRestaurantId(int restaurant_id);
}
