/**
 * 
 */
package com.fa.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fa.spring.configuration.CustomUserDetails;
import com.fa.spring.entity.Users;
import com.fa.spring.repository.UsersRepository;

/**
 * @author KhanhBQ3
 *
 */
@Service
public class UsersService implements UserDetailsService {

	@Autowired
	private UsersRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = userRepository.findUsersByUsername(username);
		if (users == null) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetails(users);
	}

}
