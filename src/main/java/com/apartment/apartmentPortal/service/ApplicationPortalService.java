package com.apartment.apartmentPortal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.apartment.apartmentPortal.Entity.ApartmentEntity;
import com.apartment.apartmentPortal.Entity.TenantEntity;
import com.apartment.apartmentPortal.Entity.UserEntity;
import com.apartment.apartmentPortal.dao.ApplicationPortalRepository;
import com.apartment.apartmentPortal.dto.ApartmentDTO;
import com.apartment.apartmentPortal.dto.TenantDTO;
import com.apartment.apartmentPortal.dto.UserDTO;
import com.apartment.apartmentPortal.exception.CustomException;

@Service
public class ApplicationPortalService {

	@Autowired
	ModelMapper mapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	ApplicationPortalRepository applicationPortalRepository;
	

	public UserDTO register(UserDTO userData) throws CustomException {
		if (null != applicationPortalRepository.getUser(userData.getEmail())) {
			throw new CustomException("User is already added.", HttpStatus.CONFLICT);
		} else {
			userData.setPassword(passwordEncoder.encode(userData.getPassword()));
			UserEntity userEntity = mapper.map(userData, UserEntity.class);
			applicationPortalRepository.register(userEntity);
			return mapper.map(userEntity, UserDTO.class);
		}
	}

	public UserDTO getUserData(String email) throws CustomException {
		UserEntity userEntity = applicationPortalRepository.getUser(email);
		if (userEntity == null)
			throw new CustomException("User Not Found", HttpStatus.NOT_FOUND);
		else
			return mapper.map(userEntity, UserDTO.class);
	}

	public ApartmentDTO addApartment(ApartmentDTO apartment) {
		if (null != applicationPortalRepository.getApartment(apartment.getApartmentNumber())) {
			throw new CustomException("Apartment is already added.", HttpStatus.CONFLICT);
		} else {
		ApartmentEntity apartmentEntity = mapper.map(apartment, ApartmentEntity.class);
		applicationPortalRepository.addApartment(apartmentEntity);
		return mapper.map(apartmentEntity, ApartmentDTO.class);
		}
	}

	public TenantDTO addTenant(TenantDTO tenant) {
			TenantEntity tenantEntity = mapper.map(tenant, TenantEntity.class);
			applicationPortalRepository.addTenant(tenantEntity);
			return mapper.map(tenantEntity, TenantDTO.class);
	}

	public void deleteTenant(String email) {
		TenantEntity tenantEntity = applicationPortalRepository.getTenant(email);
		if (tenantEntity == null)
			throw new CustomException("Tenant Not Found for deletion", HttpStatus.NOT_FOUND);
		else
		applicationPortalRepository.deleteTenant(tenantEntity);
	}

	public List<TenantDTO> getAllTenantsForUser(String userEmail) {
		List<TenantDTO> tenants = null;
		UserEntity userEntity = applicationPortalRepository.getUser(userEmail);
		if (userEntity == null)
			throw new CustomException("User Not Found", HttpStatus.NOT_FOUND);
		else {
			List<TenantEntity> tenantEntities = applicationPortalRepository.getAllTenantsForUser(userEmail);
			if (!tenantEntities.isEmpty()) {
				tenants = new ArrayList<TenantDTO>();
				tenantEntities.stream().map(tenantEntity -> mapper.map(tenantEntity, TenantDTO.class))
						.collect(Collectors.toList());
			}
		}
		return tenants;
	}
}
