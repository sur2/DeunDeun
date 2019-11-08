package com.ssafy.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.dto.Restaurant;
import com.ssafy.api.repository.R2CRepository;
@Service
public class R2CServiceImpl implements R2CService {
	@Autowired
	private R2CRepository repo;
	
	@Override
	public List<Restaurant> selectRestaurantByCategoryId(int category_id) {
		return repo.selectRestaurantByCategoryId(category_id);
	}

	@Override
	public List<Restaurant> searchRestaurantByCategoryId(int category_id, double x, double y, int range) {
		List<Restaurant> searchList = new ArrayList<Restaurant>();
		List<Restaurant> temp = repo.selectRestaurantByCategoryId(category_id);
		for (Restaurant restaurant : temp) {
			if (rangeCalculate(restaurant, x, y, range)) {
				searchList.add(restaurant);
			}
		}
		return searchList;
	}
	
	private boolean rangeCalculate(Restaurant restaurant, double lon, double lat, int range) {
		double x1 = lon - differenceByLongitude(range, lat);
		double x2 = lon + differenceByLongitude(range, lat);
		double y1 = lat - differenceByLatitude(range);
		double y2 = lat + differenceByLatitude(range);
		System.out.println("x : " + x1 + " ~ " + x2);
		System.out.println("y : " + y1 + " ~ " + y2);
		if (x1 < restaurant.getLocation_x() && x2 > restaurant.getLocation_x()) {
			if (y1 < restaurant.getLocation_y() && y2 > restaurant.getLocation_y()) {
				return true;
			}
		}
		return false;
	}

	private double differenceByLatitude(int range) {
		final int r = 6371009;
		return range * 360 / (2 * Math.PI * r);
	}

	private double differenceByLongitude(int range, double lat) {
		final int r = 6371009;
		return range * 360 / (2 * Math.PI * r * Math.cos(Math.toRadians(lat)));
	}
	
	

}
