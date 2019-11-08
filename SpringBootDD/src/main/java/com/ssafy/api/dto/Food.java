package com.ssafy.api.dto;

public class Food {
	private int food_id;
	private int restaurant_id;
	private String name;
	private int price;
	private String img_url;
	private boolean popular_menu;

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public boolean isPopular_menu() {
		return popular_menu;
	}

	public void setPopular_menu(boolean popular_menu) {
		this.popular_menu = popular_menu;
	}

	@Override
	public String toString() {
		return "Food [food_id=" + food_id + ", restaurant_id=" + restaurant_id + ", name=" + name + ", price=" + price
				+ ", img_url=" + img_url + ", popular_menu=" + popular_menu + "]";
	}

}
