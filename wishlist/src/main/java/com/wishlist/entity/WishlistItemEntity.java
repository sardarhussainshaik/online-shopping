package com.wishlist.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "wishlist_Table1")
public class WishlistItemEntity {
	
	@Id
	private long wishlistId;
	private String userId;
	
	//Mapping to Product entity class
	@OneToMany(targetEntity = ProductEntity1.class)
	    private List<ProductEntity1> product;
	
	//Generating getters and setters 
	public WishlistItemEntity() {
			super();
		}

	
	public List<ProductEntity1> getProduct() {
		return product;
	}

	public void setProduct(List<ProductEntity1> product) {
		this.product = product;
	}

	public long getWishlistId() {
		return wishlistId;
	}
	//constructor with fields
	public WishlistItemEntity(long wishlistId, String userId,  List<ProductEntity1> product) {
		super();
		this.wishlistId = wishlistId;
		this.userId = userId;
	
		this.product = product;
	}


	public void setWishlistId(long wishlistId) {
		this.wishlistId = wishlistId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	//Generating hash code for primary key in table which should be unique
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (wishlistId ^ (wishlistId >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WishlistItemEntity other = (WishlistItemEntity) obj;
		if (wishlistId != other.wishlistId)
			return false;
		return true;
	}
	

}
