package com.ssafy.api.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.api.dto.Favorite;
import com.ssafy.api.dto.Restaurant;
import com.ssafy.api.mapper.FavoriteMapper;

@Repository
public class FavoriteRepositoryImpl implements FavoriteRepository {
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public Favorite checkFavorite(Favorite favorite) {
		FavoriteMapper mapper=template.getMapper(FavoriteMapper.class);
		return mapper.checkFavorite(favorite);
	}

	@Override
	public List<Restaurant> selectFavoritesByMemberId(int member_id) {
		FavoriteMapper mapper=template.getMapper(FavoriteMapper.class);
		return mapper.selectFavoritesByMemberId(member_id);
	}

	@Override
	public int insertFavorite(Favorite favorite) {
		FavoriteMapper mapper=template.getMapper(FavoriteMapper.class);
		return mapper.insertFavorite(favorite);
	}

	@Override
	public int deleteFavorite(int favorite_id) {
		FavoriteMapper mapper=template.getMapper(FavoriteMapper.class);
		return mapper.deleteFavorite(favorite_id);
	}

}