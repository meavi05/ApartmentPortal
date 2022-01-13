/**
 * 
 */
package com.application.dao;

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

import com.application.Entity.ApartmentEntity;
import com.application.Entity.TenantEntity;
import com.application.Entity.UserEntity;

/*
 * 
 */
/**
 * @author avi08
 *
 */
@Repository
public class UserRepository {
	
	@Autowired
	ModelMapper mapper;
	@PersistenceContext
	EntityManager em;

	private static final Logger Logger = LogManager.getLogger(UserRepository.class);


	public UserEntity getUser(String email) {
		Logger.debug("Inside getUserData method: Start", UserRepository.class);
		UserEntity userEntity = null;
		TypedQuery<UserEntity> userDataQuery = em.createNamedQuery("UserEntity.findByEmail", UserEntity.class);
		userDataQuery.setParameter("email", email);
		try {
			userEntity = userDataQuery.getSingleResult();
		} catch (NoResultException e) {
			Logger.debug("No user return for the given user name", UserRepository.class);
			return null;
		}
		Logger.debug("Inside getUserData method: End", UserRepository.class);
		return userEntity;
	}

	@Transactional
	public ApartmentEntity addApartment(ApartmentEntity apartmentEntity) {
		Logger.debug("Inside addApartment method: Start", UserRepository.class);
		em.persist(apartmentEntity);
		Logger.debug("Inside addApartment method: End", UserRepository.class);
		return apartmentEntity;
	}
	
	public ApartmentEntity getApartment(Integer apartmentNumber) {
		Logger.debug("Inside getApartment method: Start", UserRepository.class);
		ApartmentEntity apartmentEntity = null;
		TypedQuery<ApartmentEntity> apartmentDataQuery = em.createNamedQuery("ApartmentEntity.findByApartmentNumber", ApartmentEntity.class);
		apartmentDataQuery.setParameter("apartmentNumber", apartmentNumber);
		try {
			apartmentEntity = apartmentDataQuery.getSingleResult();
		} catch (NoResultException e) {
			Logger.debug("No apartment return for the given apartment number", UserRepository.class);
			return null;
		}
		Logger.debug("Inside getApartment method: End", UserRepository.class);
		return apartmentEntity;
	}

	@Transactional
	public TenantEntity addTenant(TenantEntity tenantEntity) {
		Logger.debug("Inside addTenant method: Start", UserRepository.class);
		if (null != getTenant(tenantEntity.getEmail()))
			em.merge(tenantEntity);
		else
			em.persist(tenantEntity);
		Logger.debug("Inside addTenant method: End", UserRepository.class);
		return tenantEntity;
	}
	
	public TenantEntity getTenant(String email) {
		Logger.debug("Inside getTenant method: Start", UserRepository.class);
		TenantEntity tenantEntity = null;
		TypedQuery<TenantEntity> tenentDataQuery = em.createNamedQuery("TenantEntity.findByEmail", TenantEntity.class);
		tenentDataQuery.setParameter("email", email);
		try {
			tenantEntity = tenentDataQuery.getSingleResult();
		} catch (NoResultException e) {
			Logger.debug("No tenant return for the given email", UserRepository.class);
			return null;
		}
		Logger.debug("Inside getTenant method: End", UserRepository.class);
		return tenantEntity;
	}

	@Transactional
	public void deleteTenant(TenantEntity tenantEntity) {
		Logger.debug("Inside deleteTenant method: Start", UserRepository.class);
		em.remove(tenantEntity);
		Logger.debug("Inside deleteTenant method: End", UserRepository.class);
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
