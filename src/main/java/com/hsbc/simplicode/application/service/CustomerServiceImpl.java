package com.hsbc.simplicode.application.service;

import java.io.IOException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsbc.simplicode.application.entity.Customer;
import com.hsbc.simplicode.application.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	public int createCustomer(String createCustomerRequest) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		Customer customer = mapper.readValue(createCustomerRequest, Customer.class);
		Timestamp timeValue = new Timestamp(System.currentTimeMillis());
		customer.setCreateTime(timeValue);
		customer.setLastUpdatedTime(timeValue);
		customerRepository.save(customer);
		return customer.getCustomerId();
		
	}
	
	public Customer reterieveCustomer(int customerId) {
		return customerRepository.findByCustomerId(customerId);
	}
	
	
	public void verifyCustomer(int customerId, String verifyCustomerRequest) {
		
	}
	
	
}
