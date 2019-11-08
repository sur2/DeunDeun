package com.ssafy.api.mapper;

import java.util.List;

import com.ssafy.api.dto.Food;

public interface FoodMapper {
	public List<Food> selectFoodByRestaurantId(int restaurant_id);
}
