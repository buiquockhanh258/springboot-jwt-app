/**
 * 
 */
package com.fa.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fa.spring.entity.Comments;

/**
 * @author KhanhBQ3
 *
 */
public interface CommentsRepository extends MongoRepository<Comments, String> {
	List<Comments> findByPostId(String postId);
}
