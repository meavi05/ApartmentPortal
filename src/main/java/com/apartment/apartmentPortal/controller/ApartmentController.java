/**
 * 
 */
package com.apartment.apartmentPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String addUser() {
		return null;

	}

	@RequestMapping(value = "/authorizeUser", method = RequestMethod.POST)
	@ResponseBody
	public UserEntity authorizeUser(@RequestBody UserEntity userData) {
		System.out.println(userData);
		applicationPortalService.authorizeUser(userData);
		return userData;
	}

	@RequestMapping(value = "/getUserData/{email}", method = RequestMethod.GET)
	@ResponseBody
	public UserDTO getUserData(@PathVariable("email") String email) {
		System.out.println(email);
		return applicationPortalService.getUserData(email);
	}

	@RequestMapping(value = "/addApartment", method = RequestMethod.POST)
	@ResponseBody
	public ApartmentDTO addApartment(@RequestBody ApartmentEntity apartment) {
		System.out.println(apartment);
		ApartmentDTO returnApartment = applicationPortalService.addApartment(apartment);
		return returnApartment;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
		public UserEntity addUser(@RequestBody UserEntity userData) {
			System.out.println(userData);
		applicationPortalService.addUser(userData);
		return userData;
	}

	@RequestMapping(value = "/addTenant", method = RequestMethod.POST)
	@ResponseBody
	public TestTenantDTO addTenant(@RequestBody TestTenantEntity tenant) {
		System.out.println(tenant);
		return applicationPortalService.addTenant(tenant);
	}
	@RequestMapping(value = "/deleteTenant/{email}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteTenant(@PathVariable("email") String email) {
		System.out.println(email);
		 applicationPortalService.deleteTenant(email);
	}
}
