package com.cg.go.service;



import java.util.List;

import com.cg.go.entity.CustomerEntity;
import com.cg.go.exception.CustomerNotFoundException;

//import com.cg.mts.exception.CustomerExistsException;


public interface CustomerServiceInterface 
{
	public CustomerEntity insertCustomer(CustomerEntity customer) throws CustomerNotFoundException;
	public CustomerEntity updateCustomer(CustomerEntity customer) throws CustomerNotFoundException;
	public CustomerEntity deleteCustomer(int customerId);
	public List<CustomerEntity>viewCustomers();
	public CustomerEntity viewCustomer(int customerId);
	public CustomerEntity validateCustomer(int id, String password) throws CustomerNotFoundException;
}