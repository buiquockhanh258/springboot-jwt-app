/**
 * 
 */
package com.fa.spring.entity.DTO;

import lombok.Data;

/**
 * @author KhanhBQ3
 *
 */
public @Data class PostsDTO {
	private String id;
	private String userId;
	private String title;
	private String body;
	private int comments;

	public PostsDTO(String id, String userId, String title, String body, int comments) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.body = body;
		this.comments = comments;
	}
}
