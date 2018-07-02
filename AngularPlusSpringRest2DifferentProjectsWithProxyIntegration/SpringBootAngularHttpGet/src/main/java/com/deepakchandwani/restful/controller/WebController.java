package com.deepakchandwani.restful.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepakchandwani.restful.model.Customer;

@RestController
@RequestMapping(value="/api")
public class WebController {

	private Map<Integer, Customer> customers = new HashMap<Integer, Customer>(){

		{
	        put(1, new Customer(1, "Deepak N", "Chandwani", 45));
	        put(2, new Customer(2, "Mahesh KN", "Chandwani", 40));
	        put(3, new Customer(3, "NanikRam H", "Chandwani", 75));
	        put(4, new Customer(3, "Sunita N", "Chandwani", 70));
	        put(5, new Customer(3, "Aryan M", "Chandwani", 1));
	        put(6, new Customer(3, "Parul  M", "Chandwani", 35));
	    }
	};
	
	@CrossOrigin(origins = "*")
	@GetMapping(value="/family",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAll(){
		List<Customer> results = customers.entrySet().stream()
									.map(entry ->entry.getValue())
									.collect(Collectors.toList());
		return results;
	}
}