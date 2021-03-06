package com.ssafy.api.service;

import java.util.List;

import com.ssafy.api.dto.Favorite;
import com.ssafy.api.dto.Restaurant;

public interface FavoriteService {
	public Favorite checkFavorite(Favorite favorite);
	public List<Restaurant> selectFavoritesByMemberId(int member_id);
	public int insertFavorite(Favorite favorite);
	public int deleteFavorite(int favorite_id);
}
