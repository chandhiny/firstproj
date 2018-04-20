package com.stock.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dao.ProductDao;
import com.stock.model.Product;
import com.stock.service.ProductService;

//@Service("functionsusedonprod")
@Named
public class ProductServiceImpl implements ProductService {

	
	//@Autowired
	@Inject
	private ProductDao productDao;
	
	@Override
	public List<Product> getProductRecord() {
			return productDao.getProductRecord();
}

	@Override
	public void addproduct(Product pb) {
		 productDao.addproduct(pb);		
	}

	@Override
	public String deleteproduct(String productname) {
		return productDao.deleteproduct(productname);
	}

	@Override
	public List<Product> getproductbycategoryname(String categoryname) {
		return productDao.getproductbycategoryname(categoryname);
	}

	@Override
	public Product editproduct(Product pb) {
		return productDao.editproduct(pb);
	}

	@Override
	public Product productbuy(Product pb) {
		return productDao.productbuy(pb);
	}

}
