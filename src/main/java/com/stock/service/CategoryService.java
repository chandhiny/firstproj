package com.stock.service;

import java.util.List;

import com.stock.model.Category;

public interface CategoryService {

	void addcategory(Category cb);

	List<Category> showcategory();

}
