package com.stock.model;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//@Service
@Named
@Scope("request")
public class Category {

	 private String categoryname;
	 private String categorydescription;

	 public Category(String categoryname, String categorydescription) {
	 this.categoryname = categoryname;
	 this.categorydescription = categorydescription;
	 }

	 public Category() {
	}

	public Category(String categoryname) {
		 this.categoryname = categoryname;
	}

	public String getcategoryname() {
	 return categoryname;
	 }

	 public void setcategoryname(String categoryname) {
	 this.categoryname = categoryname;
	 }

	 public String getcategorydescription() {
	 return categorydescription;
	 }

	 public void setcategorydescription(String categorydescription) {
	 this.categorydescription = categorydescription;
	 }



	 @Override
	 public String toString() {
	 return "CategoryBean [categoryname=" + categoryname + ", categorydescription=" + categorydescription + "]";
	 }

}
