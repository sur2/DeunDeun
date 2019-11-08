package com.ssafy.api.mapper;

import java.util.List;

import com.ssafy.api.dto.Category;

public interface CategoryMapper {
	public Category selectCategoryById(int category_id);
	public List<Category> selectAllCategory();
	public int insertCategory(Category category);
	public int updateCategory(Category category);
}
