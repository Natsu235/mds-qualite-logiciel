package com.tactfactory.monprojetsb.monprojetsb.entities;

import java.util.List;

public class User {

	private Long id;
	private String firstname;
	private String lastname;
	private List<Product> products;

	public User() {
		super();
	}

	public User(Long id, String firstname, String lastname, List<Product> products) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
