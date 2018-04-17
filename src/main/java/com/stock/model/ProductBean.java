package com.stock.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("request")
public class ProductBean {

	 private String productname;
	 private int price;
	 private int quantity;
	private String categoryname;
	private int quantitypurchased;
	private Set<ProductBean> productlist = new HashSet<ProductBean>();

	 public ProductBean(String productname, int price, int quantity, String categoryname) {
	 this.productname = productname;
	 this.price = price;
	 this.quantity = quantity;
	 this.categoryname=categoryname;
	 }

	 public ProductBean() {
	}

	public ProductBean(int quantity, String productname) {
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

	public Set<ProductBean> getProductlist() {
		return productlist;
	}

	public void setProductlist(Set<ProductBean> productlist) {
		this.productlist = productlist;
	}

	public int getQuantitypurchased() {
		return quantitypurchased;
	}

	public void setQuantitypurchased(int quantitypurchased) {
		this.quantitypurchased = quantitypurchased;
	}


}
