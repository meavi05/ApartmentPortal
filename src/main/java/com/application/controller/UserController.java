/**
 * 
 */
package com.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author avi08
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/welcome")
	public ResponseEntity<String> health() {
		return new ResponseEntity<String>("Welcome", HttpStatus.OK);

	}

}
