/**
 * 
 */
package com.fa.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fa.spring.entity.Users;
import com.fa.spring.service.impl.UsersServiceImpl;

/**
 * @author KhanhBQ3
 *
 */
@RestController
@RequestMapping("/users")
public class UsersAPI {
	@Autowired(required = true)
	private UsersServiceImpl serviceImpl;

	@CrossOrigin("*")
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/all")
	public List<Users> getAllUsers() {
		return serviceImpl.getAllUsers();
	}

	@GetMapping(path = "{id}")
	public Users getUserById(@PathVariable("id") String id) {
		return serviceImpl.getUserById(id);
	}

	@GetMapping(path = "/delete/{id}")
	public void deleteUserById(@PathVariable("id") String id) {
		serviceImpl.deleteUserById(id);
	}

	@PostMapping(path = "/update/{id}")
	public Users updateUserById(@PathVariable("id") String id, Users user) {
		return serviceImpl.updateUserById(id, user) ? serviceImpl.getUserById(id) : null;
	}

	@PostMapping("/new")
	public Users addUsers(@RequestBody(required = true) Users user) {
		return serviceImpl.addUser(user) ? serviceImpl.getUserById(user.getId()) : null;
	}
}
