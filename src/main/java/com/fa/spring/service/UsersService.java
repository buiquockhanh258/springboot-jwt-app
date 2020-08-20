/**
 * 
 */
package com.fa.spring.service;

import java.util.List;

import com.fa.spring.entity.Users;

/**
 * @author KhanhBQ3
 *
 */
public interface UsersService {
	List<Users> getAllUsers();

	Users getUserById(String id);

	void deleteUserById(String id);

	boolean updateUserById(String id, Users user);

	boolean addUser(Users user);
	
	Users getUserByUsername(String username);
}
