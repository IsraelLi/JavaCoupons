package com.israbase.coupons.entities;

import com.israbase.coupons.helpers.ClientType;

public class User {
	
	private final Long id;
	private String name;
	private String email;
	private ClientType type;
	
	public User(Long id, String name, String email, ClientType type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public ClientType getType() {
		return type;
	}
	
}
