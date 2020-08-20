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
public @Data class Posts {
	@Id
	private String id;
	private String userId;
	private String title;
	private String body;
}
