package com.cg.go.controller;

import java.util.List;

//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.entity.CustomerEntity;
import com.cg.go.exception.CustomerNotFoundException;
import com.cg.go.service.CustomerServiceInterface;


//import com.cg.mts.exception.CustomerExistsException;


@CrossOrigin(origins="http://localhost:3000")
@RestController
public class CustomerController {
	@Autowired
	private CustomerServiceInterface custservice;


	@PostMapping("/insertCustomer")
	public CustomerEntity insertCustomer( @RequestBody CustomerEntity customer) throws CustomerNotFoundException {
		
		CustomerEntity custData = custservice.insertCustomer(customer);
		return custData;
	}

	
	@PutMapping("/updateCustomer")
	public CustomerEntity updateCustomer(@RequestBody CustomerEntity customer) throws CustomerNotFoundException {
		CustomerEntity custData = custservice.updateCustomer(customer);
		return custData;
	}
	

	@DeleteMapping("/deleteCustomer/{customerId}")
	//public ResponseEntity<Customer> deleteCustomer(@RequestParam("customerId") int customerId)
	public CustomerEntity deleteCustomer(@PathVariable("customerId") int customerId)
			throws CustomerNotFoundException {
		CustomerEntity custData = custservice.deleteCustomer(customerId);
		if (custData == null) {
			throw new CustomerNotFoundException("Customer is deleted with id: " + customerId);
		}
		return custData;
	}

	@GetMapping("/selectAll")
	public List<CustomerEntity> viewCustomers() {
		List<CustomerEntity> custList = custservice.viewCustomers();
		return custList;
	}

	@GetMapping("/viewCustomer/{customerId}")
	public CustomerEntity viewCustomer(@PathVariable("customerId") int customerId)
			throws CustomerNotFoundException {
		CustomerEntity custData = custservice.viewCustomer(customerId);
		if (custData.getCustomerId() != customerId) {
			throw new CustomerNotFoundException("Customer not found: " + customerId);
		}
		return custData;
	}

	@GetMapping("/validateCustomer/{cid}/{pass}")
	public CustomerEntity validateCustomer(@PathVariable("cid") int id, @PathVariable("pass") String password) 
			throws CustomerNotFoundException {
		CustomerEntity custData = custservice.validateCustomer(id, password);
		return custData;
	}

}
