package com.wishlist.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.wishlist.entity.ProductEntity1;
import com.wishlist.entity.WishlistItemEntity;
import com.wishlist.exception.WishlistException;
import com.wishlist.repository.WishListDaoInterface;
import com.wishlist.service.WishListService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
// @SpringBootTest Spring Boot provides a convenient way to start up an application to be used in a test and how to reduce test runtime
@SpringBootTest
class WishlistTestCases {

	@Autowired
	private WishListService wd;
	//@MockBean when you write a test that is backed by a Spring Test and you want to add or replace a bean
	@MockBean
	private WishListDaoInterface wi;

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/*
	 * @Test void test() { fail("Not yet implemented"); }
	 */

	@Test
	void testaddWishlistItem() {
		ProductEntity1 productObj1=new ProductEntity1("123","santoor",24.0,"image","red","essentials",2,"venu","childcare");
		 List<ProductEntity1> productObj2=new ArrayList<>();
		 productObj2.add(productObj1);
		WishlistItemEntity wishlistObj=new WishlistItemEntity(789654,"123",productObj2);
		
		when(wi.save(wishlistObj)).thenReturn(wishlistObj);
		assertEquals(wishlistObj, wd.addWishlistItem(wishlistObj));
       
      
	}
	
	@Test
	void testfindAllItems(){
		ProductEntity1 productObj1=new ProductEntity1("123","santoor",245.00,"imagee","red","essentials",2,"venu","childcare");
		List<ProductEntity1> productObj2=new ArrayList<>();
		productObj2.add(productObj1);
		WishlistItemEntity cr=new WishlistItemEntity(123l,"venu",productObj2);
		assertEquals(0, wd.findAllItems().size());
		
	}
	
	
	/*
	 * @Test void testdeleteWishlistByUserId() throws WishlistException {
	 * WishlistItemEntity c=new WishlistItemEntity(); c.setUserId("123");
	 * wd.deleteWishlistByUserId(c.getUserId()); //Iterable<WishlistItemEntity>
	 * k=wd.deleteWishlistByUserId(); List<ProductEntity1> p=new ArrayList<>();
	 * WishlistItemEntity cr=new WishlistItemEntity(123,"venu",p);
	 * when(wi.save(cr)).thenReturn(cr); assertEquals(cr,
	 * wd.deleteWishlistByUserId("123"));
	 * 
	 * //assert(k).hasSize(2).contains(c);
	 * 
	 * }
	 */
	
	
	
	
}
