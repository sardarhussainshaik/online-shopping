package com.wishlist.service;

import com.wishlist.entity.ProductEntity1;
import com.wishlist.entity.WishlistItemEntity;

public interface ProductServiceInterface {

	public ProductEntity1 addProduct(ProductEntity1 pe);

	public WishlistItemEntity getFromProduct(ProductEntity1 product);

}
