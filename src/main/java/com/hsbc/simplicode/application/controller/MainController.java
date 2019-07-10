package com.hsbc.simplicode.application.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hsbc.simplicode.application.service.CustomerService;

@RestController
public class MainController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value ="/customers",method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createCustomer(@RequestBody final String createCustomerRequest, @RequestHeader final HttpHeaders httpHeader) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode js = mapper.createObjectNode();
		js.put("customerId",customerService.createCustomer(createCustomerRequest));
		return new ResponseEntity<>(mapper.writeValueAsString(js),HttpStatus.CREATED);
	}
 
	
	@RequestMapping(value ="/customers/{customerId}",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> fetchCustomer(@PathVariable final int customerId, @RequestHeader final HttpHeaders httpHeader) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		return new ResponseEntity<>(mapper.writeValueAsString(customerService.reterieveCustomer(customerId)),HttpStatus.OK);
	}
	
	
}
