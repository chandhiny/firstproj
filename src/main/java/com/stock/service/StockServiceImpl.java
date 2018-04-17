package com.stock.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{

	@Override
	public String getList() {
		return "hi";
	}

	@Override
	  public Map<String, String> getCategoryList() {
	      Map<String, String> categoryList = new HashMap<String, String>();
	      categoryList.put("SP", "Soap");
	      categoryList.put("SH", "Shampoo");
	      categoryList.put("ST", "Stationery");
	      categoryList.put("BS", "Biscuits");
	      return categoryList;
	   }
	}


