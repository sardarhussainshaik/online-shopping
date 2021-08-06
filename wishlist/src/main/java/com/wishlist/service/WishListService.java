package com.wishlist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wishlist.entity.*;
import com.wishlist.entity.ProductEntity1;
//import com.wishlist.entity.ProductEntity1;
import com.wishlist.entity.WishlistItemEntity;
import com.wishlist.exception.WishlistException;
import com.wishlist.repository.WishListDaoInterface;
@Service
public class WishListService implements WishListServiceInterface{
	
	@Autowired
	private WishListDaoInterface wd;

	@Override
	public List<WishlistItemEntity> findAllItems() {
		List<WishlistItemEntity> list=new ArrayList<>();
		wd.findAll().forEach(list1->list.add(list1));
		return list;
		
	}
	
	
	
	

	
	@Override
	public List<WishlistItemEntity> findWishlist(String userId) {
		//WishlistItemEntity wishlistItemEntityObj = new WishlistItemEntity();

		List<WishlistItemEntity> list = new ArrayList<>();
		//if (w1.getUserId().equalsIgnoreCase(userId))
		list=wd.findAllById(userId);
		System.out.println(list);
		return list;
	}
	 

	
	@Override
	public void deleteWishlistByUserId(String userId) throws WishlistException {
			List<WishlistItemEntity> wishlistItemEntityObj= wd.findAllById(userId);
			if(wishlistItemEntityObj.isEmpty()) {
				throw new WishlistException("Unable to delete without userId");
			}
			wd.deleteAll(wishlistItemEntityObj);
			
		
		
	}
	
	
	  @Override
	  public List<WishlistItemEntity> findWishlistItem(String productId, String userId) throws WishlistException {
	  List<WishlistItemEntity> wishlistItemEntityObj=new ArrayList<WishlistItemEntity>();
	  
	  List<WishlistItemEntity> obj1= wd.findAll();
	  for(WishlistItemEntity w1:obj1) {
		  if(!w1.getUserId().equalsIgnoreCase(userId)) {
			  throw new WishlistException("Unable to find without productId and userId");
		  }
		  wishlistItemEntityObj=wd.findAllById(w1.getUserId());
	  }
		  
	  
	  
	  
	  return wishlistItemEntityObj;
	  }
	 

	
	

	@Override
	public WishlistItemEntity addWishlistItem(WishlistItemEntity w) {
		// TODO Auto-generated method stub
		
		WishlistItemEntity wishlistItemEntityObj=wd.save(w);
		return wishlistItemEntityObj;
	}

	



	
	  @Override public void deleteBywishlistitem(String productId,String userId) throws WishlistException {
	  
		  List<WishlistItemEntity> obj1= wd.findAll();
		  for(WishlistItemEntity w1:obj1) {
			  if(!w1.getUserId().equalsIgnoreCase(userId)) {
				  throw new WishlistException("Unable to delete without productId and userId");
			  }
			  wd.deleteById(w1.getWishlistId());
		  }
	  
	  }
	 
	 



	
	  
	 
	
	 
	 
	
	
	
	


}
