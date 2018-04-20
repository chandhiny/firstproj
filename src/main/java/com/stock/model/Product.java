package com.stock.model;


import javax.inject.Named;

import org.springframework.context.annotation.Scope;

//@Service
@Named
@Scope("request")
public class Product {

	 private String productname;
	 private int price;
	 private int quantity;
	private String categoryname;
	

	 public Product(String productname, int price, int quantity, String categoryname) {
	 this.productname = productname;
	 this.price = price;
	 this.quantity = quantity;
	 this.categoryname=categoryname;
	 }

	 public Product() {
	}

	public Product(int quantity, String productname) {
		 this.productname = productname;
		 this.quantity = quantity;
	}

	public String getproductname() {
	 return productname;
	 }

	 public void setproductname(String productname) {
	 this.productname = productname;
	 }

	 public int getprice() {
	 return price;
	 }

	 public void setprice(int price) {
	 this.price = price;
	 }

	 public int getquantity() {
	 return quantity;
	 }

	 public void setquantity(int quantity) {
	 this.quantity = quantity;
	 }

	 @Override
	 public String toString() {
	 return "ProductBean [productname=" + productname + ", price=" + price + ", quantity=" + quantity + "]";
	 }

	 public String getcategoryname() {
	 return categoryname;
	 }

	 public void setcategoryname(String categoryname) {
	 this.categoryname = categoryname;
	 }


}
