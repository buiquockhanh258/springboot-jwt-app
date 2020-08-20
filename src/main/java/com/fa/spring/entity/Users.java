/**
 * 
 */
package com.fa.spring.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * @author KhanhBQ3
 *
 */
@Document(collection = "users")
public @Data class Users {
	@Id
	private String id;

	@Field(value = "name")
	private String name;
	
	@Field(value = "username")
	private String username;

	@Field(value = "email")
	private String email;

	@Field(value = "address")
	private Address address;
	
	@Field(value = "phone")
	private String phone;
	
	@Field(value = "website")
	private String website;
	
	@Field(value = "company")
	private Company company;
	
}
