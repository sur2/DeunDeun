package com.ssafy.api.dto;

public class lowestPrice {
	private int restaurant_id;
	private String name;
	private String company_name;
	private String operation_hour;
	private String tel;
	private double location_x;
	private double location_y;
	private int price;
	
	
	public lowestPrice(int restaurant_id, String name, String company_name, String operation_hour,String tel,double location_x, double location_y) {
		this.restaurant_id = restaurant_id;
		this.name = name;
		this.company_name = company_name;
		this.operation_hour = operation_hour;
		this.tel = tel;
		this.location_x = location_x;
		this.location_y = location_y;
	}

	public lowestPrice() {}
	
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
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getOperation_hour() {
		return operation_hour;
	}
	public void setOperation_hour(String operation_hour) {
		this.operation_hour = operation_hour;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public double getLocation_x() {
		return location_x;
	}
	public void setLocation_x(double location_x) {
		this.location_x = location_x;
	}
	public double getLocation_y() {
		return location_y;
	}
	public void setLocation_y(double location_y) {
		this.location_y = location_y;
	}
	@Override
	public String toString() {
		return "RestaurantDTO [restaurant_id=" + restaurant_id + ", name=" + name + ", company_name=" + company_name
				+ ", operation_hour=" + operation_hour + ", tel=" + tel + ", location_x=" + location_x + ", location_y="
				+ location_y + "]";
	}
	
}
