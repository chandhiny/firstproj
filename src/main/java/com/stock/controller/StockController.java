package com.stock.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stock.dao.ProductDao;
import com.stock.dao.CategoryDao;
import com.stock.model.CategoryBean;
import com.stock.model.ProductBean;
import com.stock.service.StockService;

@Controller
public class StockController {

	@Autowired
	private StockService stockService;
	
	@Autowired
	 ProductDao productDao;
	
	@Autowired
	 CategoryDao categoryDao;
	 
	@GetMapping("/index")
	public ResponseEntity<String> getMsg() {
		return new ResponseEntity<String>(stockService.getList(), HttpStatus.OK);
	}
	
	@GetMapping("/home")
	public String getView() {
		return "home";
	}
		
	 @GetMapping("/customerproductbuy")
	 public ModelAndView getProduct() {
	 List<ProductBean> list = new ArrayList<>();
	 list = productDao.getProductRecord();
	 return new ModelAndView("success", "product", list);
	 }
	 
		@GetMapping("/productbuy")
		public ModelAndView buyprod() {
			 ModelAndView mv = new ModelAndView("productbuy");

			    mv.addObject("product", new ProductBean());
			return mv;
		}
	  @PostMapping("/buyproduct")
	  public ModelAndView buyProduct(@ModelAttribute("product") ProductBean pb) {
				productDao.productbuy(pb);
				
			 return getProduct();

	  }
	  @PostMapping("/buyproductcheck")
	// public ModelAndView buyProductcheck(@ModelAttribute("product") ProductBean pb) {
	 public @ResponseBody ModelAndView buyProductcheck(@RequestParam String productname,@RequestParam int quantity) {
		  productDao.insertorder(productname,quantity);
				 List<ProductBean> list = new ArrayList<>();
				 	list =productDao.productbuy1(productname,quantity);
return new ModelAndView("productlistcheck","product",list);
			//return getProduct();

	  }
	  
	  @GetMapping("/productbuycheck")
		public ModelAndView buyprodcheck() {
			 ModelAndView mv = new ModelAndView("productbuycheck");
			 List<ProductBean> list = new ArrayList<>();
			 list = productDao.getProductRecord();
				 	mv.addObject("productlist", list);
			    mv.addObject("product", new ProductBean());
			return mv;
		}
	 
	 @GetMapping("/viewcategorylist")
	 public ModelAndView viewCategoryList() {
		List<CategoryBean> list = new ArrayList<>();
		 //List<String> list = new ArrayList<String>();
		 list =	categoryDao.showcategory();
		 return new ModelAndView("categorylist","category",list);

	 }
	 
	 @GetMapping("/categorydropdown")  
	   public ModelAndView categorygropdown() {
		//	 List<String> list = new ArrayList<String>();
		 List<CategoryBean> list = new ArrayList<>();
		 list =	categoryDao.showcategory();
			//   Set<String> cn = Arrays.stream(list).map(CategoryBean::getcategoryname).collect(Collectors.toSet());

			 
			ModelAndView model = new ModelAndView("categorydropdown");
			 	model.addObject("categorylist", list);
				   model.addObject("category", new CategoryBean());
				    return model;	
			//	return new ResponseEntity<String>("GET Response : "  + s, HttpStatus.OK);

				    }
	 
	 @GetMapping("/productcheckbox")  
	   public ModelAndView productcheckbox() {
		 List<ProductBean> list = new ArrayList<>();
		 list = productDao.getProductRecord();
		ModelAndView model = new ModelAndView("productcheckbox");
			 	model.addObject("productlist", list);
				   model.addObject("product", new ProductBean());
				    return model;	
				    } 
	 
	 @GetMapping("/getproductbycategoryname")  
		//  public @ResponseBody ResponseEntity<String> getproductbycategory(@PathVariable String categoryname){ 
		  public @ResponseBody ModelAndView getproductbycategory1(@RequestParam String categoryname){ 
				 List<ProductBean> list = new ArrayList<>();
			 list= productDao.getproductbycategoryname(categoryname); 
			 return new ModelAndView("productlist","product",list); 
		      //return new ModelAndView("redirect:/viewproductlist");
			//return new ResponseEntity<String>("GET Response : "  + list, HttpStatus.OK);
		    } 
	
	 @GetMapping("/viewproductlist")
	 public ModelAndView showProducts() {
		 List<ProductBean> list = new ArrayList<>();
		 list = productDao.getProductRecord();
		 return new ModelAndView("productlist", "product", list);
		 }
	 
	 
	@GetMapping("/managerview")
	public ModelAndView showCategList() {
		 ModelAndView mv = new ModelAndView("managerview");

		    mv.addObject("category", new CategoryBean());

		//ModelAndView mv = new ModelAndView();
		//mv.addObject("categoryList", stockService.getCategoryList());
		return mv;
	}
	
	  @PostMapping("/addcategory")
	  public ModelAndView addCategory(@ModelAttribute("category") CategoryBean cb) {
				categoryDao.addcategory(cb);
				
			 return viewCategoryList();

	  }
	  
	  @GetMapping("/prodview")
		public ModelAndView showprodList() {
			 ModelAndView mv = new ModelAndView("prodview");

			    mv.addObject("product", new ProductBean());

			//ModelAndView mv = new ModelAndView();
			//mv.addObject("categoryList", stockService.getCategoryList());
			return mv;
		}
	  @PostMapping("/addproduct")
	  public ModelAndView addProduct(@ModelAttribute("product") ProductBean pb) {
				productDao.addproduct(pb);
				
			 return showProducts();

	  }
	  
	

	 @PostMapping("/editproductsave")
	 public ModelAndView editsave(@ModelAttribute("product")  ProductBean pb){  
		 
	       productDao.editproduct(pb);
	       return showProducts();  
	    
			}
	  
	  @GetMapping("/producteditform")  
	   public ModelAndView editprodList() {
			 ModelAndView mv = new ModelAndView("producteditform");

			   mv.addObject("product", new ProductBean());

			//ModelAndView mv = new ModelAndView();
			//mv.addObject("categoryList", stockService.getCategoryList());
			return mv;  
	    }  

	 

	  @GetMapping("/deleteproduct/{productname}")
	  public @ResponseBody ResponseEntity<String>
	   delproduct(@PathVariable String productname) {
		  int pd =  productDao.deleteproduct(productname);
	    return new ResponseEntity<String>("GET Response : "  + pd, HttpStatus.OK);
	  }
	  
	  @GetMapping("/getproductbycategoryname/{categoryname}")  
	//  public @ResponseBody ResponseEntity<String> getproductbycategory(@PathVariable String categoryname){ 
	  public @ResponseBody ModelAndView getproductbycategory(@PathVariable String categoryname){ 
			 List<ProductBean> list = new ArrayList<>();
		 list= productDao.getproductbycategoryname(categoryname); 
		 return new ModelAndView("productlist","product",list); 
	      //return new ModelAndView("redirect:/viewproductlist");
		//return new ResponseEntity<String>("GET Response : "  + list, HttpStatus.OK);
	    }  
	
	  
}
