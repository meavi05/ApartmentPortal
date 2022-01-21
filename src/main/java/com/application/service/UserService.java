package com.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.application.Entity.ApartmentEntity;
import com.application.Entity.TenantEntity;
import com.application.Entity.UserEntity;
import com.application.dao.UserRepository;
import com.application.dto.ApartmentDTO;
import com.application.dto.TenantDTO;
import com.application.dto.UserDTO;
import com.application.exception.CustomException;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Service
public class UserService {

	@Autowired
	ModelMapper mapper;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	EurekaClient eurekaClient;
	@Value("${service.authService.serviceId}")
	private String authServiceId;


	public UserDTO getUserData(String email) throws CustomException {
		Application application = eurekaClient.getApplication(authServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "auth/getUserData/" + email;
        System.out.println("URL" + url);
        UserDTO user = restTemplate.getForObject(url, UserDTO.class);
        System.out.println("RESPONSE " + user);
		if (user == null)
			throw new CustomException("User Not Found", HttpStatus.NOT_FOUND);
		else
			return user;
	}

	public ApartmentDTO addApartment(ApartmentDTO apartment) {
		if (null != userRepository.getApartment(apartment.getApartmentNumber())) {
			throw new CustomException("Apartment is already added.", HttpStatus.CONFLICT);
		} else {
			ApartmentEntity apartmentEntity = mapper.map(apartment, ApartmentEntity.class);
			userRepository.addApartment(apartmentEntity);
			return mapper.map(apartmentEntity, ApartmentDTO.class);
		}
	}

	public TenantDTO addTenant(TenantDTO tenant) {
		TenantEntity tenantEntity = mapper.map(tenant, TenantEntity.class);
		userRepository.addTenant(tenantEntity);
		return mapper.map(tenantEntity, TenantDTO.class);
	}

	public void deleteTenant(String email) {
		TenantEntity tenantEntity = userRepository.getTenant(email);
		if (tenantEntity == null)
			throw new CustomException("Tenant Not Found for deletion", HttpStatus.NOT_FOUND);
		else
			userRepository.deleteTenant(tenantEntity);
	}

	public List<TenantDTO> getAllTenantsForUser(String userEmail) {
		List<TenantDTO> tenants = null;
		UserEntity userEntity = userRepository.getUser(userEmail);
		if (userEntity == null)
			throw new CustomException("User Not Found", HttpStatus.NOT_FOUND);
		else {
			List<TenantEntity> tenantEntities = userRepository.getAllTenantsForUser(userEmail);
			if (!tenantEntities.isEmpty()) {
				tenants = new ArrayList<TenantDTO>();
				tenantEntities.stream().map(tenantEntity -> mapper.map(tenantEntity, TenantDTO.class))
						.collect(Collectors.toList());
			}
		}
		return tenants;
	}

}
