/**
 * 
 */
package com.apartment.apartmentPortal.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author avi08
 *
 */
public class ApartmentDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer apartmentId;
	private Integer apartmentNumber;
	private String apartmentName;
	private String location;
	private String apartmentOwner;
	@JsonBackReference
	private UserDTO user;
	List<TenantDTO> tenants;
	@JsonManagedReference
	List<TestTenantDTO> testtenants;
	
	/**
	 * @return the apartmentNumber
	 */
	public Integer getApartmentNumber() {
		return apartmentNumber;
	}
	/**
	 * @return the apartmentId
	 */
	public Integer getApartmentId() {
		return apartmentId;
	}
	/**
	 * @param apartmentId the apartmentId to set
	 */
	public void setApartmentId(Integer apartmentId) {
		this.apartmentId = apartmentId;
	}
	/**
	 * @param apartmentNumber the apartmentNumber to set
	 */
	public void setApartmentNumber(Integer apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	/**
	 * @return the apartmentName
	 */
	public String getApartmentName() {
		return apartmentName;
	}
	/**
	 * @param apartmentName the apartmentName to set
	 */
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	/**
	 * @return the apartmentOwner
	 */
	public String getApartmentOwner() {
		return apartmentOwner;
	}
	/**
	 * @param apartmentOwner the apartmentOwner to set
	 */
	public void setApartmentOwner(String apartmentOwner) {
		this.apartmentOwner = apartmentOwner;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the user
	 */
	public UserDTO getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
	
	/**
	 * @return the tenants
	 */
	public List<TenantDTO> getTenants() {
		return tenants;
	}
	/**
	 * @param tenants the tenants to set
	 */
	public void setTenants(List<TenantDTO> tenants) {
		this.tenants = tenants;
	}
	/**
	 * @return the testtenants
	 */
	public List<TestTenantDTO> getTesttenants() {
		return testtenants;
	}
	/**
	 * @param testtenants the testtenants to set
	 */
	public void setTesttenants(List<TestTenantDTO> testtenants) {
		this.testtenants = testtenants;
	}
	@Override
	public String toString() {
		return "ApartmentDTO [apartmentId=" + apartmentId + ", apartmentNumber=" + apartmentNumber + ", apartmentName="
				+ apartmentName + ", location=" + location + ", apartmentOwner=" + apartmentOwner + ", user=" + user
				+ ", testtenants=" + testtenants + "]";
	}
}
