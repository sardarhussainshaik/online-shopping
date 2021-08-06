package com.cg.go.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.dao.CustomerDAOInterface;
import com.cg.go.entity.CustomerEntity;
import com.cg.go.exception.CustomerNotFoundException;



@Service

public class CustomerService implements CustomerServiceInterface {

	@Autowired
	CustomerDAOInterface custrepository;


	
	@Override
	public CustomerEntity insertCustomer(CustomerEntity customer) throws CustomerNotFoundException {
		if(custrepository.existsById(customer.getCustomerId())) {
			throw new CustomerNotFoundException("Customer Id already exists");
		}
		CustomerEntity custData = custrepository.save(customer);
		
		return custData;
	}

	
	@Override
	public CustomerEntity updateCustomer(CustomerEntity customer) throws CustomerNotFoundException {
		if(custrepository.existsById(customer.getCustomerId()))
		{
			custrepository.save(customer);
			return customer;
		}
		else
			throw new CustomerNotFoundException("Customer id is not found");
	}

	@Override
	public CustomerEntity deleteCustomer(int customerId) {
		custrepository.deleteById(customerId);
		return viewCustomer(customerId);

	}

	@Override
	public List<CustomerEntity> viewCustomers() {
		List<CustomerEntity> customer = custrepository.findAll();
		System.out.println("Get data from DB: " + customer);
		return customer;
	}

	@Override
	public CustomerEntity viewCustomer(int customerId) {
		return custrepository.findById(customerId).orElse(null);

	}

	@Override
	public CustomerEntity validateCustomer(int id , String password) throws CustomerNotFoundException {
		//username=username.toLowerCase();
		Optional<CustomerEntity> custData=custrepository.findById(id);
				CustomerEntity k=custData.get();
				if((k.getCustomerId()!=id)|| !k.getPassword().equals(password)) {
					throw new CustomerNotFoundException("Invalid Login credentials");
				}
		/*CustomerEntity custData = custrepository.validateCustomer(username, password);
		if (custData == null) {
			throw new CustomerNotFoundException("Wrong Username or password");
		}*/
		return k;

	}

}