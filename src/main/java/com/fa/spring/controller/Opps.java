/**
 * 
 */
package com.fa.spring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author KhanhBQ3
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/oops")
public class Opps {
	@GetMapping
	public String opps() {
		return "Oppsy Daisy, U r not allow to be here right now";
	}
}
