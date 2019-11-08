package com.ssafy.api.service;

import java.util.List;

import com.ssafy.api.dto.Restaurant;

public interface RestaurantService {
	public int insertOne(Restaurant restaurant);
	public Restaurant selectOneById(int restaurant_id);
	public Restaurant selectOneByName(String name);
	public List<Restaurant> selectAll();
	public int update(String tel);
	public int delete(int restaurant_id);
	public List<Restaurant> selectLowestPrice();
	public List<Restaurant> searchRestaurant(double x, double y, int range);
	public int countAllRestaurants();
}
