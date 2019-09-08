package com.example.demo;

import org.springframework.data.annotation.Id;

public class Customer {

	public Customer(String firstName) {
		this.firstName = firstName;
	}

	@Id
	Long id;
	String firstName;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
