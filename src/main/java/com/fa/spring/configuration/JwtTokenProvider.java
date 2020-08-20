/**
 * 
 */
package com.fa.spring.configuration;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

/**
 * @author KhanhBQ3
 *
 */
@Component
@Slf4j
public class JwtTokenProvider {
	private final String JWT_SECRET = "bigboobssavelives";
	private final long JWT_EXPRIATION = 6000000l;

	public String generateToken(CustomUserDetails userDetails) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + JWT_EXPRIATION);
		return Jwts.builder().setSubject(userDetails.getUsers().getUsername()).setIssuedAt(now)
				.setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
	}

	public String getUsernameFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromJWT(token);
		return (username.equals(userDetails.getUsername()));
	}
}
