/**
 * 
 */
package com.apartment.apartmentPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.apartmentPortal.dto.ApartmentDTO;
import com.apartment.apartmentPortal.dto.TenantDTO;
import com.apartment.apartmentPortal.dto.UserDTO;
import com.apartment.apartmentPortal.exception.CustomException;
import com.apartment.apartmentPortal.service.ApplicationPortalService;


/**
 * @author avi08
 *
 */
@CrossOrigin
@RestController
public class ApartmentController {
	
	@Autowired
	ApplicationPortalService applicationPortalService;

	@RequestMapping(value = "/")
	public ResponseEntity<String> health() {
		return new ResponseEntity<String>("Welcome", HttpStatus.OK);

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login( @RequestParam String email, @RequestParam String password) {
		 String jwtToken =  applicationPortalService.login(email, password);
		return new ResponseEntity<String>(jwtToken, HttpStatus.OK);
	}

	@RequestMapping(value = "/refresh", method = RequestMethod.GET)
	  public String refresh(@RequestParam String email) {
	    return applicationPortalService.refresh(email);
	  } 
	@RequestMapping(value = "/getUserData/{email}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUserData(@PathVariable("email") String email) throws CustomException {
		UserDTO userDto = applicationPortalService.getUserData(email);
		return new ResponseEntity<UserDTO>(userDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/addApartment", method = RequestMethod.POST)
	public ResponseEntity<ApartmentDTO> addApartment(@RequestBody ApartmentDTO apartment) {
		ApartmentDTO returnApartment = applicationPortalService.addApartment(apartment);
		return new ResponseEntity<ApartmentDTO>(returnApartment, HttpStatus.OK);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody UserDTO userData) throws CustomException {
		String jwtToken = applicationPortalService.register(userData);
		return new ResponseEntity<String>(jwtToken, HttpStatus.OK);
	}

	@RequestMapping(value = "/addTenant", method = RequestMethod.POST)
	public ResponseEntity<TenantDTO> addTenant(@RequestBody TenantDTO tenant) {
		return new ResponseEntity<TenantDTO>(applicationPortalService.addTenant(tenant), HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteTenant/{email}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteTenant(@PathVariable("email") String email) {
		applicationPortalService.deleteTenant(email);
		return new ResponseEntity<String>("Tenant Deleted", HttpStatus.OK);
	}

	@RequestMapping(value = "/getTenantsData/{email}", method = RequestMethod.GET)
	public ResponseEntity<List<TenantDTO>> getAllTenantsForUser(@PathVariable("email") String email) {
		return new ResponseEntity<List<TenantDTO>>(applicationPortalService.getAllTenantsForUser(email), HttpStatus.OK);
	}
}
