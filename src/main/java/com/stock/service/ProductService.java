package com.stock.service;

import java.util.List;

import com.stock.model.Product;

public interface ProductService {

	List<Product> getProductRecord();

	void addproduct(Product pb);

	String deleteproduct(String productname);

	List<Product> getproductbycategoryname(String categoryname);

	Product editproduct(Product pb);

	Product productbuy(Product pb);

}
