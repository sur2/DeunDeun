package com.ssafy.api.mapper;

import java.util.List;

import com.ssafy.api.dto.Restaurant;

public interface R2CMapper {
	public List<Restaurant> selectRestaurantByCategoryId(int category_id);
}
