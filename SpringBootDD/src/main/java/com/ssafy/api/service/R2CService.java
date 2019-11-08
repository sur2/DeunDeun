package com.ssafy.api.service;

import java.util.List;

import com.ssafy.api.dto.Restaurant;

public interface R2CService {
	public List<Restaurant> selectRestaurantByCategoryId(int category_id);
	public List<Restaurant> searchRestaurantByCategoryId(int category_id,double x,double y,int range);
}
