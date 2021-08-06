package com.wishlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wishlist.entity.ProductEntity1;
import com.wishlist.entity.WishlistItemEntity;
import com.wishlist.repository.ProductDAOInterface;
	@Service
	public class ProductService implements ProductServiceInterface {
	  @Autowired
	  private ProductDAOInterface pd;
		@Override
		public ProductEntity1 addProduct(ProductEntity1 productEntity) {
		
			
		return pd.save(productEntity); 	
		}
	/*	public static ProductEntity1 getFromProduct(ProductEntity1 productEntity) {
			ProductEntity1 products= new ProductEntity1(productEntity);
	        return products;
	    }*/
		@Override
		public WishlistItemEntity getFromProduct(ProductEntity1 product) {
			// TODO Auto-generated method stub
			return null;
		}
	}
		