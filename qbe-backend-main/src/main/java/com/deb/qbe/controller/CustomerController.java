package com.deb.qbe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deb.qbe.model.Customers;
import com.deb.qbe.service.CustomerService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/customer")
@Log4j2
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public ResponseEntity<List<Customers>> getAllStates() {
		log.info("Request received to get all availavble customers");
		return ResponseEntity.ok(customerService.getAll());
	}

	@GetMapping("/limited")
	public ResponseEntity<List<Customers>> getAllLimit() {
		log.info("Request received to get all availavble customers");
		return ResponseEntity.ok(customerService.getAll().subList(2,4));
	}


	@GetMapping("/firstname")
	public ResponseEntity<List<Customers>> getAllCustomersFirstNameEndsWith(@RequestParam(name = "endsWith") String endsWith) {
		log.info("Request received to get all customers first name ends with {}", endsWith);
		return ResponseEntity.ok(customerService.findByFirstNameEnding(endsWith));
	}
	
	
	@GetMapping("/lastname")
	public ResponseEntity<List<Customers>> getAllCustomersLastNameEndsWith(@RequestParam(name = "endsWith") String endsWith) {
		log.info("Request received to get all  customers last name endswith {}", endsWith);
		return ResponseEntity.ok(customerService.findByLastNameEnding(endsWith));
	}
	
	
	
	@GetMapping("/balance")
	public ResponseEntity<List<Customers>> getAllCustomersLastNameEndsWith(@RequestParam(name = "min") Long min,
																		   @RequestParam(name = "max") Long max) {
		log.info("Request received to get all  customers whose wallet balance is {}", min);
		return ResponseEntity.ok(customerService.findByWalletBalanceBetween(min, max));
	}
	
	@GetMapping("/{firstName}")
	public ResponseEntity<List<Customers>> getCustomerByName(@PathVariable String firstName) {
		log.info("Request received to get all  customer by name {}", firstName);
		return ResponseEntity.ok(customerService.findByFirstName(firstName));
	}
}
