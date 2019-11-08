package com.ssafy.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.dto.Favorite;
import com.ssafy.api.dto.Restaurant;
import com.ssafy.api.repository.FavoriteRepository;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	@Autowired
	private FavoriteRepository repo;
	
	@Override
	public Favorite checkFavorite(Favorite favorite) {
		return repo.checkFavorite(favorite);
	}

	@Override
	public List<Restaurant> selectFavoritesByMemberId(int member_id) {
		return repo.selectFavoritesByMemberId(member_id);
	}

	@Override
	public int insertFavorite(Favorite favorite) {
		return repo.insertFavorite(favorite);
	}

	@Override
	public int deleteFavorite(int favorite_id) {
		return repo.deleteFavorite(favorite_id);
	}

}
