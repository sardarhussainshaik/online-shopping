package com.cg.go.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.go.entity.CustomerEntity;


@Repository
public interface CustomerDAOInterface extends JpaRepository<CustomerEntity, Integer> {
	/*
	 * @Query(value =
	 * "Select customer from CustomerEntity customer where customer.username=:name and customer.password=:pwd"
	 * ) public CustomerEntity validateCustomer(@Param("name") String
	 * username, @Param("pwd") String password);
	 */
			
}
