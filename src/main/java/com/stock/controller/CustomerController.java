package com.stock.controller;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stock.model.Product;
import com.stock.service.ProductService;

@RestController
public class CustomerController {
	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	//@Autowired
	@Inject
	private ProductService productService;
	

	
		
	 @PostMapping("/buyproduct")
	  public ResponseEntity<Product> buyProduct(@RequestBody Product pb) throws NoProductException  {
	
			 Product op = productService.productbuy(pb);
		 if(op!= null) {
				return  new ResponseEntity<Product>(op,HttpStatus.OK);
		 }else {
			 logger.error("no product bought");
			
				throw new NoProductException(op);
			}
		 
		
	 
}
}
