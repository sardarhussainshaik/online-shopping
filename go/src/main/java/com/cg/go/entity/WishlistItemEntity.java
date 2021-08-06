package com.cg.go.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class WishlistItemEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="wish_seq")
	@SequenceGenerator(name="wish_seq",sequenceName="wish_seq", allocationSize=1)
	private long wishlistId;
	
	 @OneToOne
	 @JoinColumn(name="customer_Id") 
	 private CustomerEntity customerWish;
	 
	@ManyToOne
	@JoinColumn(name="product_Id")
	private ProductEntity product;
	
     WishlistItemEntity(){
    	 
     }

	public WishlistItemEntity(Long wishlistId,CustomerEntity customerWish, ProductEntity product) {
		super();
		this.wishlistId = wishlistId;
		this.customerWish = customerWish;
		this.product = product;
	}

	public long getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(long wishlistId) {
		this.wishlistId = wishlistId;
	}

	public CustomerEntity getCustomerWish() {
		return customerWish;
	}

	public void setCustomerWish(CustomerEntity customerWish) {
		this.customerWish = customerWish;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	/*
	 * public UserEntity getUserId() { return userId; } public void
	 * setUserId(UserEntity userId) { this.userId = userId; }
	 */

	/*
	 * public void addProduct(ProductEntity1 productEntity) {
	 * productEntity.setW1(this); //this will avoid nested cascade
	 * this.getProductId().add(productEntity.getProductId1()); }
	 */
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
