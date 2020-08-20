/**
 * 
 */
package com.fa.spring.entity;

import lombok.Data;

/**
 * @author KhanhBQ3
 *
 */
public @Data class Address {
	private String city;
	private Geo geo;
	private String street;
	private String suite;
	private String zipcode;
}
