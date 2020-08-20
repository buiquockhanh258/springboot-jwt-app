/**
 * 
 */
package com.fa.spring.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.spring.entity.Posts;
import com.fa.spring.entity.DTO.PostsDTO;
import com.fa.spring.repository.CommentsRepository;
import com.fa.spring.repository.PostsRepository;
import com.fa.spring.service.PostsServices;

/**
 * @author KhanhBQ3
 *
 */
@Service
public class PostsServicesImpl implements PostsServices {
	@Autowired
	private PostsRepository postRepository;

	@Autowired
	private CommentsRepository commentsRepository;

	@Override
	public List<Posts> getAllPost() {
		return postRepository.findAll();
	}

	@Override
	public List<PostsDTO> getPostByUserId(String userId) {
		List<PostsDTO> listPostsDTO = new ArrayList<PostsDTO>();
		List<Posts> listPosts = postRepository.findByUserId(userId);
		listPosts.forEach(post -> {
			int comments = commentsRepository.findByPostId(post.getId()).size();
			PostsDTO postsDTO = new PostsDTO(post.getId(), post.getUserId(), post.getTitle(), post.getBody(), comments);
			listPostsDTO.add(postsDTO);
		});
		return listPostsDTO;
	}

	@Override
	public void deletePostById(String id) {
		postRepository.deleteById(id);
	}

	@Override
	public boolean updatePostById(Posts post) {
		return (postRepository.findById(post.getId()) != null) ? postRepository.save(post) != null : false;
	}

	@Override
	public boolean addPost(Posts post) {
		return postRepository.findById(post.getId()) != null ? postRepository.save(post) != null : false;
	}

	@Override
	public Optional<Posts> getPostById(String id) {
		return postRepository.findById(id);
	}

}
