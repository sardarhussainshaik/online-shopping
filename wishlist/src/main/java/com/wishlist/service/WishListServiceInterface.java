package com.wishlist.service;

import java.util.List;
import java.util.Optional;


import com.wishlist.entity.ProductEntity1;
import com.wishlist.entity.WishlistItemEntity;
import com.wishlist.exception.WishlistException;

public interface WishListServiceInterface {

	
	List<WishlistItemEntity> findAllItems();



	void deleteWishlistByUserId(String userId) throws WishlistException;




//	List<WishlistItemEntity> readWishList(String userId);


	List<WishlistItemEntity> findWishlist(String userId);


	List<WishlistItemEntity> findWishlistItem(String productId, String userId) throws WishlistException;

	void deleteBywishlistitem(String productId,String userId) throws WishlistException;

	WishlistItemEntity addWishlistItem(WishlistItemEntity w);



	


	


	
	  
	 
	

	

	

	
	

}
