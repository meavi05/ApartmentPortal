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
import org.springframework.web.bind.annotation.RestController;

import com.apartment.apartmentPortal.Entity.ApartmentEntity;
import com.apartment.apartmentPortal.Entity.TestTenantEntity;
import com.apartment.apartmentPortal.Entity.UserEntity;
import com.apartment.apartmentPortal.dto.ApartmentDTO;
import com.apartment.apartmentPortal.dto.TestTenantDTO;
import com.apartment.apartmentPortal.dto.UserDTO;
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

	@RequestMapping(value = "/authorizeUser", method = RequestMethod.POST)
	public ResponseEntity<UserEntity> authorizeUser(@RequestBody UserEntity userData) {
		System.out.println(userData);
		applicationPortalService.authorizeUser(userData);
		return new ResponseEntity<UserEntity>(userData,HttpStatus.OK);
	}

	@RequestMapping(value = "/getUserData/{email}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUserData(@PathVariable("email") String email) {
		System.out.println(email);
		UserDTO userDto = applicationPortalService.getUserData(email);
		return new ResponseEntity<UserDTO>(userDto,HttpStatus.OK);
	}

	@RequestMapping(value = "/addApartment", method = RequestMethod.POST)
	public ResponseEntity<ApartmentDTO> addApartment(@RequestBody ApartmentEntity apartment) {
		System.out.println(apartment);
		ApartmentDTO returnApartment = applicationPortalService.addApartment(apartment);
		return new ResponseEntity<ApartmentDTO>(returnApartment,HttpStatus.OK);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
		public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userData) {
			System.out.println(userData);
		applicationPortalService.addUser(userData);
		return  new ResponseEntity<UserEntity>(userData,HttpStatus.OK);
	}

	@RequestMapping(value = "/addTenant", method = RequestMethod.POST)
	public ResponseEntity<TestTenantDTO> addTenant(@RequestBody TestTenantEntity tenant) {
		System.out.println(tenant);
		return new ResponseEntity<TestTenantDTO>(applicationPortalService.addTenant(tenant),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteTenant/{email}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteTenant(@PathVariable("email") String email) {
		System.out.println(email);
		 applicationPortalService.deleteTenant(email);
		 return new ResponseEntity<String>("Tenant Deleted",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getTenantsData/{email}", method = RequestMethod.GET)
	public ResponseEntity<List<TestTenantDTO>> getTenantsData(@PathVariable("email") String email) {
		System.out.println(email);
		return new ResponseEntity<List<TestTenantDTO>>(applicationPortalService.getTenantsData(email),HttpStatus.OK);
	}
}
