package com.wishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wishlist.entity.ProductEntity1;


@Repository
public interface ProductDAOInterface extends JpaRepository<ProductEntity1,String>{

}