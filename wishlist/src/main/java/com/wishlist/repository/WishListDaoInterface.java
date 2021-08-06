package com.wishlist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wishlist.entity.WishlistItemEntity;
import com.wishlist.exception.WishlistException;

@Repository

public interface WishListDaoInterface extends JpaRepository<WishlistItemEntity, Long>{
	
	@Query("Select s from WishlistItemEntity s where s.userId =?1")
	List<WishlistItemEntity> findAllById(String userId);

	
	
	
	
	//@Query("Select s from WishlistItemEntity s where s.productId =?1 and s.userId=?1")
	  //List<WishlistItemEntity> findWishlistItem(String productId, String userId);
	 
	  //@Query("ALTER TABLE wishlist DROP COLUMN productId where userId:'userId'")
	  //void deleteWishlist(String userId) ;
	  
	  
	  
	 
	
	
}
