package com.wishlist.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.authenticator.SavedRequest;
import org.postgresql.jdbc.AutoSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wishlist.entity.ProductEntity1;
import com.wishlist.entity.WishlistItemEntity;
import com.wishlist.exception.WishlistException;
import com.wishlist.service.ProductServiceInterface;
import com.wishlist.service.WishListServiceInterface;
@CrossOrigin(origins = "http://localhost:10001")
@RestController
@RequestMapping("/api/v1/")
public class WishListController {
	//Autowiring feature of spring framework enables you to inject the object dependency implicitly
	//creating object to layers
	@Autowired
	private WishListServiceInterface ws;
	@Autowired
	private ProductServiceInterface ps;
	//In this method we will get all items in a wishlist
	@GetMapping("findAllItems")
	public List<WishlistItemEntity> findAllItems() {
		List<WishlistItemEntity> wishlistItemEntityObj = new ArrayList<WishlistItemEntity>();
		wishlistItemEntityObj = ws.findAllItems();
		return wishlistItemEntityObj;
	}
	//This method will add products to wishlist 
	@PostMapping("addproductstowishlist")
	public WishlistItemEntity addWishlistItem(@RequestBody WishlistItemEntity obj) {
		WishlistItemEntity wishlistItemEntityObj = ws.addWishlistItem(obj);
		return wishlistItemEntityObj;
	}
	//Finding wishlist by using user id
	@GetMapping("findwishlist/{userId}")
	public List<WishlistItemEntity> findWishlist(@PathVariable String userId) {
		 List<WishlistItemEntity> products=ws.findWishlist(userId);
		return products;

	}
	

	//Finding wishlist by using product id and user id
	  @GetMapping("findWishlistItem/{productId}/{userId}")
	  public List<WishlistItemEntity> findWishlistItem(@PathVariable String productId,@PathVariable String userId) throws WishlistException {
	  
	  List<WishlistItemEntity> wishlistItemEntityObj = new ArrayList<WishlistItemEntity>(); 
	  return wishlistItemEntityObj=ws.findWishlistItem(productId,userId);
	  
	  
	  
	  }
	 
	
	
	//Here we are deleting wishlist by using user id

	@DeleteMapping("deletewishlist/{userId}")
	public void deleteWishlistByUserId(@PathVariable String userId) throws WishlistException {
		ws.deleteWishlistByUserId(userId);
	}
	
	//Deleting wishlist by using product id and user id
	  @DeleteMapping("deleteWishlistItem/{productId}/{userId}")
	  public void deleteBywishlistitem(@PathVariable String productId, @PathVariable String userId) throws WishlistException {
	  
	  ws.deleteBywishlistitem(productId, userId);
	  
	  }
	 
	
	

}
