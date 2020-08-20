/**
 * 
 */
package com.fa.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fa.spring.entity.Comments;
import com.fa.spring.service.impl.CommentsServicesImpl;

/**
 * @author KhanhBQ3
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/comments")
public class CommentsAPI {
	@Autowired(required = true)
	private CommentsServicesImpl serviceImpl;

	@PreAuthorize("hasAuthority('USER')")
	@GetMapping("/all")
	public List<Comments> getAllCommentsByPostId(String postId) {
		return serviceImpl.getAllCommentsByPostId(postId);
	}

	@GetMapping(path = "/delete/{id}")
	public void deleteCommentById(@PathVariable("id") String id) {
		serviceImpl.deleteCommentById(id);
	}

	@PostMapping(path = "/update/{id}")
	public Optional<Comments> updatePostById(@PathVariable("id") String id, Comments comment) {
		return serviceImpl.updateCommentById(comment) ? serviceImpl.getCommentById(id) : null;
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/new")
	public Optional<Comments> addComments(@RequestBody(required = true) Comments comment) {
		return serviceImpl.addComment(comment) ? serviceImpl.getCommentById(comment.getId()) : null;
	}
}
