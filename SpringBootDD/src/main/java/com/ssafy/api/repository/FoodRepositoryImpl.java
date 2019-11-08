package com.ssafy.api.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.api.dto.Food;
import com.ssafy.api.mapper.FoodMapper;
@Repository
public class FoodRepositoryImpl implements FoodRepository {
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public List<Food> selectFoodByRestaurantId(int restaurant_id) {
		FoodMapper mapper=template.getMapper(FoodMapper.class);
		return mapper.selectFoodByRestaurantId(restaurant_id);
	}

}
