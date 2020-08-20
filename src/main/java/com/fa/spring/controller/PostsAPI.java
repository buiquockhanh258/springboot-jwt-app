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

import com.fa.spring.entity.Posts;
import com.fa.spring.entity.DTO.PostsDTO;
import com.fa.spring.service.impl.PostsServicesImpl;
import com.fa.spring.service.impl.UsersServiceImpl;

/**
 * @author KhanhBQ3
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/posts")
public class PostsAPI {
	@Autowired(required = true)
	private PostsServicesImpl serviceImpl;

	@Autowired(required = true)
	private UsersServiceImpl userServiceImpl;

	@PreAuthorize("hasAuthority('USER')")
	@GetMapping("/all")
	public List<Posts> getAllPosts() {
		return serviceImpl.getAllPost();
	}

	@GetMapping(path = "/user/{username}")
	public List<PostsDTO> getPostsByUserId(@PathVariable("username") String username) {
		return serviceImpl.getPostByUserId(userServiceImpl.getUserByUsername(username).getId());
	}

	@GetMapping(path = "/delete/{id}")
	public void deletePostById(@PathVariable("id") String id) {
		serviceImpl.deletePostById(id);
	}

	@PostMapping(path = "/update/{id}")
	public Optional<Posts> updatePostById(@PathVariable("id") String id, Posts post) {
		return serviceImpl.updatePostById(post) ? serviceImpl.getPostById(id) : null;
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/new")
	public Optional<Posts> addPosts(@RequestBody(required = true) Posts post) {
		return serviceImpl.addPost(post) ? serviceImpl.getPostById(post.getId()) : null;
	}
}
