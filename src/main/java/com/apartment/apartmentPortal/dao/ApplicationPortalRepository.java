/**
 * 
 */
package com.apartment.apartmentPortal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apartment.apartmentPortal.Entity.ApartmentEntity;
import com.apartment.apartmentPortal.Entity.TenantEntity;
import com.apartment.apartmentPortal.Entity.UserEntity;
import com.apartment.apartmentPortal.exception.CustomException;

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

	private static final Logger Logger = LogManager.getLogger(ApplicationPortalRepository.class);

	@Transactional
	public UserEntity register(UserEntity user) throws CustomException {
		Logger.debug("Inside addUser method: Start", ApplicationPortalRepository.class);
		em.persist(user);
		Logger.debug("Inside addUser method: End", ApplicationPortalRepository.class);
		return user;
	}

	public UserEntity getUser(String email) {
		Logger.debug("Inside getUserData method: Start", ApplicationPortalRepository.class);
		UserEntity userEntity = null;
		TypedQuery<UserEntity> userDataQuery = em.createNamedQuery("UserEntity.findByEmail", UserEntity.class);
		userDataQuery.setParameter("email", email);
		try {
			userEntity = userDataQuery.getSingleResult();
		} catch (NoResultException e) {
			Logger.debug("No user return for the given user name", ApplicationPortalRepository.class);
			return null;
		}
		Logger.debug("Inside getUserData method: End", ApplicationPortalRepository.class);
		return userEntity;
	}

	@Transactional
	public ApartmentEntity addApartment(ApartmentEntity apartmentEntity) {
		Logger.debug("Inside addApartment method: Start", ApplicationPortalRepository.class);
		em.persist(apartmentEntity);
		Logger.debug("Inside addApartment method: End", ApplicationPortalRepository.class);
		return apartmentEntity;
	}
	
	public ApartmentEntity getApartment(Integer apartmentNumber) {
		Logger.debug("Inside getApartment method: Start", ApplicationPortalRepository.class);
		ApartmentEntity apartmentEntity = null;
		TypedQuery<ApartmentEntity> apartmentDataQuery = em.createNamedQuery("ApartmentEntity.findByApartmentNumber", ApartmentEntity.class);
		apartmentDataQuery.setParameter("apartmentNumber", apartmentNumber);
		try {
			apartmentEntity = apartmentDataQuery.getSingleResult();
		} catch (NoResultException e) {
			Logger.debug("No apartment return for the given apartment number", ApplicationPortalRepository.class);
			return null;
		}
		Logger.debug("Inside getApartment method: End", ApplicationPortalRepository.class);
		return apartmentEntity;
	}

	@Transactional
	public TenantEntity addTenant(TenantEntity tenantEntity) {
		Logger.debug("Inside addTenant method: Start", ApplicationPortalRepository.class);
		if (null != getTenant(tenantEntity.getEmail()))
			em.merge(tenantEntity);
		else
			em.persist(tenantEntity);
		Logger.debug("Inside addTenant method: End", ApplicationPortalRepository.class);
		return tenantEntity;
	}
	
	public TenantEntity getTenant(String email) {
		Logger.debug("Inside getTenant method: Start", ApplicationPortalRepository.class);
		TenantEntity tenantEntity = null;
		TypedQuery<TenantEntity> tenentDataQuery = em.createNamedQuery("TenantEntity.findByEmail", TenantEntity.class);
		tenentDataQuery.setParameter("email", email);
		try {
			tenantEntity = tenentDataQuery.getSingleResult();
		} catch (NoResultException e) {
			Logger.debug("No tenant return for the given email", ApplicationPortalRepository.class);
			return null;
		}
		Logger.debug("Inside getTenant method: End", ApplicationPortalRepository.class);
		return tenantEntity;
	}

	@Transactional
	public void deleteTenant(TenantEntity tenantEntity) {
		Logger.debug("Inside deleteTenant method: Start", ApplicationPortalRepository.class);
		em.remove(tenantEntity);
		Logger.debug("Inside deleteTenant method: End", ApplicationPortalRepository.class);
	}

	public List<TenantEntity> getAllTenantsForUser(String userEmail) {
		UserEntity userEntity = getUser(userEmail);
		List<TenantEntity> tenantEntities = new ArrayList<TenantEntity>();
		List<ApartmentEntity> apartments = userEntity.getApartments();
		for (ApartmentEntity apartment : apartments) {
			tenantEntities.addAll(apartment.getTesttenants());
		}
		return tenantEntities;
	}
}
