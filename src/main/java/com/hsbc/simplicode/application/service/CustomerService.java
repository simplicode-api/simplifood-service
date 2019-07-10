package com.hsbc.simplicode.application.service;

import java.io.IOException;

import com.hsbc.simplicode.application.entity.Customer;

public interface CustomerService {

	public int createCustomer(String createCustomerRequest) throws IOException;
	public Customer reterieveCustomer(int customerId);
	public void verifyCustomer(int customerId, String verifyCustomerRequest);
}
