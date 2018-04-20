package com.stock.dao;

import java.util.List;

import com.stock.model.Category;

public interface CategoryDao {

	List<Category> showcategory();
	
	void addcategory( Category cb);
	
	void editcategory(Category cb);
	int deletecategory(Category cb);
	
}
