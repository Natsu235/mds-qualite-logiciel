package com.tactfactory.monprojetsb.monprojetsb.entities;

import java.util.List;

public class Product {

	private Long id;
	private String firstname;
	private String lastname;
	private Float price;

	public Product() {
		super();
	}

	public Product(Long id, String firstname, String lastname, Float price) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.price = price;
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
