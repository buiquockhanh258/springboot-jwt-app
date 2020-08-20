/**
 * 
 */
package com.fa.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.spring.entity.Comments;
import com.fa.spring.repository.CommentsRepository;
import com.fa.spring.service.CommentsServices;

/**
 * @author KhanhBQ3
 *
 */
@Service
public class CommentsServicesImpl implements CommentsServices {
	@Autowired
	private CommentsRepository commentsRepository;

	@Override
	public List<Comments> getAllCommentsByPostId(String postId) {
		return commentsRepository.findByPostId(postId);
	}

	@Override
	public void deleteCommentById(String commentId) {
		commentsRepository.deleteById(commentId);
	}

	@Override
	public boolean updateCommentById(Comments comment) {
		return commentsRepository.findById(comment.getId()) != null ? commentsRepository.save(comment) != null : false;
	}

	@Override
	public boolean addComment(Comments comment) {
		return commentsRepository.findById(comment.getId()) != null ? commentsRepository.save(comment) != null : false;
	}

	@Override
	public Optional<Comments> getCommentById(String id) {
		return commentsRepository.findById(id);
	}
}
