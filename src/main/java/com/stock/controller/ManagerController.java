package com.stock.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.stock.model.Category;
import com.stock.model.Product;
import com.stock.service.CategoryService;
import com.stock.service.ProductService;

@RestController
public class ManagerController{
	private final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	//@Autowired
	@Inject
	private ProductService productService;
	
	//@Autowired
	@Inject
	private CategoryService categoryService;
	
	
	  @PostMapping("/addproduct")
	  public ResponseEntity<Product> addProduct(@RequestBody Product pb) {
			logger.info("adding product "+pb.getproductname());
			productService.addproduct(pb);
				ResponseEntity<Product> addprod = new ResponseEntity<Product>(pb,HttpStatus.OK);
				return addprod;

	  }
	  
	
		
		 @GetMapping("/viewproductlist")
		 public ResponseEntity<List<Product>> showProducts() {
			 List<Product> prod = new ArrayList<>();
			 prod= productService.getProductRecord();
				return new ResponseEntity<List<Product>>(prod, HttpStatus.OK);
			 }
		 
	  
	  
		 

	  @PostMapping("/deleteproduct")
	  public  ResponseEntity<String>
	   delproduct(@RequestParam String productname) {
		String op= productService.deleteproduct(productname);
		 
	  ResponseEntity<String> out = new ResponseEntity<String>(op,HttpStatus.OK);
	  return out;
	  }
	  
	  @GetMapping("/getproductbycategoryname")  
	 public @ResponseBody ResponseEntity<List<Product>> getproductbycategory(@RequestParam String categoryname){ 
			 List<Product> list = new ArrayList<>();
		 list= productService.getproductbycategoryname(categoryname); 
		
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	    }  
	  
	  
		 @PostMapping("/editproductsave")
		 public ResponseEntity<Product> editsave(@RequestBody Product pb){ 
			Product op = productService.editproduct(pb);
			if( op == null) {
				logger.error("no such product available to edit");
			}
			 return new ResponseEntity<Product>(op , HttpStatus.OK); 
		    
				}
		  
		 @PostMapping("/addcategory")
		  public ResponseEntity<Category> addCategory(@RequestBody Category cb) {
				logger.info("adding category "+cb.getcategoryname());
					categoryService.addcategory(cb);
					return new ResponseEntity<Category>(cb,HttpStatus.OK);
					
				
		  }
		  
			 @GetMapping("/viewcategorylist")
			 public ResponseEntity<List<Category>> viewCategoryList() {
				List<Category> list = new ArrayList<>();
				 list =	categoryService.showcategory();
				 return new ResponseEntity<List<Category>>(list,HttpStatus.OK);

			 }
		  
}
