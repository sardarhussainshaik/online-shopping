package com.wishlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wishlist.entity.ProductEntity1;
import com.wishlist.service.ProductServiceInterface;


	@RestController
	public class ProductController {
		@Autowired
		private ProductServiceInterface ps;
		@PostMapping("addproduct")
		public ProductEntity1 addProduct(@RequestBody ProductEntity1 pe) 
		{  
			return ps.addProduct(pe);
		}

}