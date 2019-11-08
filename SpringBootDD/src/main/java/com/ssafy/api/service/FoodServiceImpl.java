package com.ssafy.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.dto.Food;
import com.ssafy.api.repository.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	private FoodRepository repo;
	
	@Override
	public List<Food> selectFoodByRestaurantId(int restaurant_id) {
		return repo.selectFoodByRestaurantId(restaurant_id);
	}

}
