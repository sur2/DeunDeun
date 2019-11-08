package com.ssafy.api.repository;

import java.util.List;

import com.ssafy.api.dto.Food;

public interface FoodRepository {
	public List<Food> selectFoodByRestaurantId(int restaurant_id);
}
