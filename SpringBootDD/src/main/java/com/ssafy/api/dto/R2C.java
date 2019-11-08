package com.ssafy.api.dto;

public class R2C {
	private int r2c_id;
	private int restaurant_id;
	private int category_id;
	
	public R2C(int r2c_id, int restaurant_id, int category_id) {
		super();
		this.r2c_id = r2c_id;
		this.restaurant_id = restaurant_id;
		this.category_id = category_id;
	}
	
	public R2C() {
		super();
	}

	public int getR2c_id() {
		return r2c_id;
	}
	public void setR2c_id(int r2c_id) {
		this.r2c_id = r2c_id;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	@Override
	public String toString() {
		return "R2C [r2c_id=" + r2c_id + ", restaurant_id=" + restaurant_id + ", category_id=" + category_id + "]";
	}
}
