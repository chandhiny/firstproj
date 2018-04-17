package com.stock.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("request")
public class CategoryBean {

	 private String categoryname;
	 private String categorydescription;

	 public CategoryBean(String categoryname, String categorydescription) {
	 this.categoryname = categoryname;
	 this.categorydescription = categorydescription;
	 }

	 public CategoryBean() {
	}

	public CategoryBean(String categoryname) {
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
