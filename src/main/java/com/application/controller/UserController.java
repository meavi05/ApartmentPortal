/**
 * 
 */
package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.dto.ApartmentDTO;
import com.application.dto.UserDTO;
import com.application.exception.CustomException;
import com.application.service.UserService;

/**
 * @author avi08
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/welcome")
	public ResponseEntity<String> health() {
		return new ResponseEntity<String>("Welcome", HttpStatus.OK);

	}


	@RequestMapping(value = "/getUserData/{email}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUserData(@PathVariable("email") String email) throws CustomException {
		UserDTO userDto = userService.getUserData(email);
		return new ResponseEntity<UserDTO>(userDto, HttpStatus.OK);
	}
	@RequestMapping(value = "/addApartment", method = RequestMethod.POST)
	public ResponseEntity<ApartmentDTO> addApartment(@RequestBody ApartmentDTO apartment) {
		ApartmentDTO returnApartment = userService.addApartment(apartment);
		return new ResponseEntity<ApartmentDTO>(returnApartment, HttpStatus.OK);
	}


}
