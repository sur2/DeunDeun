package com.ssafy.api.repository;

import java.util.List;

import com.ssafy.api.dto.Restaurant;

public interface R2CRepository {
	public List<Restaurant> selectRestaurantByCategoryId(int category_id);
}
