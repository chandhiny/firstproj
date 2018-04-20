package com.stock.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dao.CategoryDao;
import com.stock.model.Category;
import com.stock.service.CategoryService;

//@Service("categoryfunc")
@Named("categfunc")
public class CategoryServiceImpl implements CategoryService{

	
	//@Autowired
	@Inject
	private CategoryDao categoryDao;
	
	
	@Override
	public void addcategory(Category cb) {
		categoryDao.addcategory(cb);
	}


	@Override
	public List<Category> showcategory() {
		return categoryDao.showcategory();
	}

}
