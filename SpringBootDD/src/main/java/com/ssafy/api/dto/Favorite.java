package com.ssafy.api.dto;

public class Favorite {
	private int favorite_id;
	private int member_id;
	private int restaurant_id;
	
	public Favorite(int favorite_id, int member_id, int restaurant_id) {
		super();
		this.favorite_id = favorite_id;
		this.member_id = member_id;
		this.restaurant_id = restaurant_id;
	}

	public Favorite() {
		super();
	}

	public int getFavorite_id() {
		return favorite_id;
	}

	public void setFavorite_id(int favorite_id) {
		this.favorite_id = favorite_id;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	@Override
	public String toString() {
		return "Favorite [favorite_id=" + favorite_id + ", member_id=" + member_id + ", restaurant_id=" + restaurant_id
				+ "]";
	}
}
