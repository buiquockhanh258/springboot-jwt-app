/**
 * 
 */
package com.fa.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.spring.entity.Users;
import com.fa.spring.repository.UsersRepository;
import com.fa.spring.service.UsersService;

/**
 * @author KhanhBQ3
 *
 */
@Service
public class UsersServiceImpl implements UsersService {
	@Autowired(required = true)
	private UsersRepository usersRepository;

	@Override
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public Users getUserById(String id) {
		return usersRepository.findUsersById(id);
	}

	@Override
	public void deleteUserById(String id) {
		usersRepository.delete(usersRepository.findUsersById(id));
	}

	@Override
	public boolean updateUserById(String id, Users user) {
		return usersRepository.findUsersById(id) != null ? usersRepository.save(user) != null : false;
	}

	@Override
	public boolean addUser(Users user) {
		return usersRepository.findUsersById(user.getId()) == null ? usersRepository.save(user) != null : false;
	}

	@Override
	public Users getUserByUsername(String username) {
		return usersRepository.findUsersByUsername(username);
	}

}
