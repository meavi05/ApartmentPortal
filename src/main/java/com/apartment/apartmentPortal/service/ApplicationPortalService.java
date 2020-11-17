package com.apartment.apartmentPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.apartmentPortal.Entity.ApartmentEntity;
import com.apartment.apartmentPortal.Entity.TestTenantEntity;
import com.apartment.apartmentPortal.Entity.UserEntity;
import com.apartment.apartmentPortal.dao.ApplicationPortalRepository;
import com.apartment.apartmentPortal.dto.ApartmentDTO;
import com.apartment.apartmentPortal.dto.TestTenantDTO;
import com.apartment.apartmentPortal.dto.UserDTO;

@Service
public class ApplicationPortalService {

	ApartmentEntity apartment;
	@Autowired
	ApplicationPortalRepository applicationPortalRepository;
	public String addUser(UserEntity userData) {
		applicationPortalRepository.addUser(userData);
		return "ApplicationPortalService : " + "addUser";
	}
	public String authorizeUser(UserEntity userData) {
		applicationPortalRepository.authorizeUser(userData);
		return "ApplicationPortalService : " + "addUser";
		
	}
	public UserDTO getUserData(String email) {
		return applicationPortalRepository.getUserData(email);
		
	}
	public ApartmentDTO addApartment(ApartmentEntity apartment) {
		return applicationPortalRepository.addApartment(apartment);
	}
	public TestTenantDTO addTenant(TestTenantEntity tenant) {
		return applicationPortalRepository.addTenant(tenant);
		
	}
	public void deleteTenant(String email) {
		 applicationPortalRepository.deleteTenant(email);
	}
	public List<TestTenantDTO> getTenantsData(String email) {
		return applicationPortalRepository.getTenantsData(email);
	}
}
