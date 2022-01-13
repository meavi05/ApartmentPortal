/**
 * 
 */
package com.application.dto;

import java.io.Serializable;
import java.util.List;

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
	private Integer userId;
	List<TenantDTO_Old> tenants;
	List<TenantDTO> testtenants;
	
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
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the tenants
	 */
	public List<TenantDTO_Old> getTenants() {
		return tenants;
	}
	/**
	 * @param tenants the tenants to set
	 */
	public void setTenants(List<TenantDTO_Old> tenants) {
		this.tenants = tenants;
	}
	/**
	 * @return the testtenants
	 */
	public List<TenantDTO> getTesttenants() {
		return testtenants;
	}
	/**
	 * @param testtenants the testtenants to set
	 */
	public void setTesttenants(List<TenantDTO> testtenants) {
		this.testtenants = testtenants;
	}
	@Override
	public String toString() {
		return "ApartmentDTO [apartmentId=" + apartmentId + ", apartmentNumber=" + apartmentNumber + ", apartmentName="
				+ apartmentName + ", location=" + location + ", apartmentOwner=" + apartmentOwner + ", userId=" + userId
				+ ", tenants=" + tenants + ", testtenants=" + testtenants + "]";
	}
}
