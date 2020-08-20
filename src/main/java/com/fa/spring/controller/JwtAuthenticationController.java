/**
 * 
 */
package com.fa.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fa.spring.configuration.CustomUserDetails;
import com.fa.spring.configuration.JwtResponse;
import com.fa.spring.configuration.JwtTokenProvider;
import com.fa.spring.entity.JwtRequest;
import com.fa.spring.service.impl.UsersService;

/**
 * @author KhanhBQ3
 *
 */
@RestController
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private UsersService usersService;

	@CrossOrigin(allowedHeaders = "*")
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		final CustomUserDetails userDetails = (CustomUserDetails) usersService
				.loadUserByUsername(authenticationRequest.getUsername());
		if (authenticationRequest.getPassword().equals(userDetails.getPassword())) {
			final String token = jwtTokenProvider.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponse(token));
		} else {
			System.out.println("No token generated");
			return null;
		}
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}