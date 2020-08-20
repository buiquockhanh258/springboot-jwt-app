/**
 * 
 */
package com.fa.spring.service;

import java.util.List;
import java.util.Optional;

import com.fa.spring.entity.Comments;

/**
 * @author KhanhBQ3
 *
 */
public interface CommentsServices {
	List<Comments> getAllCommentsByPostId(String postId);
	
	Optional<Comments> getCommentById(String id);

	void deleteCommentById(String commentId);

	boolean updateCommentById(Comments comment);

	boolean addComment(Comments comment);
}
