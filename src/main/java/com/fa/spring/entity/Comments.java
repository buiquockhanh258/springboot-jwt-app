/**
 * 
 */
package com.fa.spring.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

/**
 * @author KhanhBQ3
 *
 */
public @Data class Comments {
	@Id
	private String id;
	private String postId;
	private String name;
	private String email;
	private String body;
}
