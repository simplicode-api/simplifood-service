package com.hsbc.simplicode.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hsbc.simplicode.application.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,String>{
	
	
	public Customer findByCustomerId(int customerId);
	
	@SuppressWarnings("unchecked")
	public Customer save(Customer customer);

}
