package com.ssafy.api.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.api.dto.Restaurant;
import com.ssafy.api.mapper.R2CMapper;
@Repository
public class R2CRepositoryImpl implements R2CRepository {
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public List<Restaurant> selectRestaurantByCategoryId(int category_id) {
		R2CMapper mapper=template.getMapper(R2CMapper.class);
		return mapper.selectRestaurantByCategoryId(category_id);
	}

}
