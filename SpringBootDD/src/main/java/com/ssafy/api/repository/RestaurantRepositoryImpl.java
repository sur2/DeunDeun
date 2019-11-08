package com.ssafy.api.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.api.dto.Restaurant;
import com.ssafy.api.mapper.RestaurantMapper;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository{
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public int insertOne(Restaurant restaurant) {
		RestaurantMapper mapper=template.getMapper(RestaurantMapper.class);
		return mapper.insertOne(restaurant);
	}

	@Override
	public Restaurant selectOneById(int restaurant_id) {
		RestaurantMapper mapper=template.getMapper(RestaurantMapper.class);
		return mapper.selectOneById(restaurant_id);
	}

	@Override
	public Restaurant selectOneByName(String name) {
		RestaurantMapper mapper=template.getMapper(RestaurantMapper.class);
		return mapper.selectOneByName(name);
	}

	@Override
	public List<Restaurant> selectAll() {
		RestaurantMapper mapper=template.getMapper(RestaurantMapper.class);
		return mapper.selectAll();
	}

	@Override
	public int update(String tel) {
		RestaurantMapper mapper=template.getMapper(RestaurantMapper.class);
		return mapper.update(tel);
	}

	@Override
	public int delete(int restaurant_id) {
		RestaurantMapper mapper=template.getMapper(RestaurantMapper.class);
		return mapper.delete(restaurant_id);
	}

	@Override
	public List<Restaurant> selectLowestPrice() {
		RestaurantMapper mapper=template.getMapper(RestaurantMapper.class);
		return mapper.selectLowestPrice();
	}

	@Override
	public int countAllRestaurants() {		
		RestaurantMapper mapper=template.getMapper(RestaurantMapper.class);
		return mapper.countAllRestaurants();
	}


	
}
