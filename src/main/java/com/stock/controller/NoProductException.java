package com.stock.controller;

import com.stock.model.Product;

public class NoProductException extends Exception {

	public NoProductException(Product op) {
	}


	private static final long serialVersionUID = 1L;

}
