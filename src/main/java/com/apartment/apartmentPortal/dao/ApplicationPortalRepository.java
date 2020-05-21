/**
 * 
 */
package com.apartment.apartmentPortal.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apartment.apartmentPortal.Entity.ApartmentEntity;
import com.apartment.apartmentPortal.Entity.TestTenantEntity;
import com.apartment.apartmentPortal.Entity.UserEntity;
import com.apartment.apartmentPortal.dto.ApartmentDTO;
import com.apartment.apartmentPortal.dto.TestTenantDTO;
import com.apartment.apartmentPortal.dto.UserDTO;
/*
 * 
 */
/**
 * @author avi08
 *
 */
@Repository
public class ApplicationPortalRepository {
	@Autowired
	ModelMapper mapper;
	@PersistenceContext
	EntityManager em;
	@Transactional
	public String addUser(UserEntity userData) {
		em.persist(userData);
				return "ApplicationPortalService : " + "addUser";
	}
	public void authorizeUser(UserEntity userData) {
		// TODO Auto-generated method stub
		
		
	}
	public UserDTO getUserData(String email) {
		// TODO Auto-generated method stub
		TypedQuery<UserEntity> userDataQuery = em.createNamedQuery("UserEntity.findByEmail", UserEntity.class);
		userDataQuery.setParameter("email", email);
		UserEntity userDataEntity = userDataQuery.getSingleResult();
		UserDTO userDTO = new UserDTO();
		mapper.map(userDataEntity, userDTO);
		return userDTO;
		
	}
	@Transactional
	public ApartmentDTO addApartment(ApartmentEntity apartmentEntity) {
		/*
		 * Tenant tenant = new Tenant(); tenant.setName("Shivam");
		 * apartment.getTenants().add(tenant); TestTenant testTenant = new TestTenant();
		 * testTenant.setApartment(apartment); testTenant.setName("Praveen");
		 * apartment.getTesttenants().add(testTenant);
		 */
		em.persist(apartmentEntity);
		em.flush();
		ApartmentDTO apartmentDTO = new ApartmentDTO();
		mapper.map(apartmentEntity,apartmentDTO);
		return apartmentDTO;
		
	}
	@Transactional
	public TestTenantDTO addTenant(TestTenantEntity tenantEntity) {
		// TODO Auto-generated method stub
		em.persist(tenantEntity);
		TestTenantDTO testTenantDTO = new TestTenantDTO();
		mapper.map(tenantEntity,testTenantDTO);
		System.out.println(testTenantDTO);
		return testTenantDTO;
	}

}
