/**
 * 
 */
package com.fa.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fa.spring.entity.Users;

/**
 * @author KhanhBQ3
 *
 */
public interface UsersRepository extends MongoRepository<Users, String> {
	Users findUsersById(String id);

	Users findUsersByUsername(String name);
}
