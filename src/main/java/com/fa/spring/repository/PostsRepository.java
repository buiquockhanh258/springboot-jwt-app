/**
 * 
 */
package com.fa.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.fa.spring.entity.Posts;

/**
 * @author KhanhBQ3
 *
 */
@Service
public interface PostsRepository extends MongoRepository<Posts, String> {
	List<Posts> findByUserId(String userId);
}
