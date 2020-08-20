/**
 * 
 */
package com.fa.spring.service;

import java.util.List;
import java.util.Optional;

import com.fa.spring.entity.Posts;
import com.fa.spring.entity.DTO.PostsDTO;

/**
 * @author KhanhBQ3
 *
 */
public interface PostsServices {
	List<Posts> getAllPost();

	List<PostsDTO> getPostByUserId(String userId);

	void deletePostById(String id);

	boolean updatePostById(Posts post);

	boolean addPost(Posts post);
	
	Optional<Posts> getPostById(String id);
}
