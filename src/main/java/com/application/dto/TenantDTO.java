/**
 * 
 */
package com.application.dto;

import java.io.Serializable;

/**
 * @author avi08
 *
 */
public class TenantDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer tenantId;
	private String tenantName;
	private String mobile;
	private String email;
	private Integer accountDetail;
	private Integer apartmentId;

	/**
	 * @return the tenantId
	 */
	public Integer getTenantId() {
		return tenantId;
	}

	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	

	/**
	 * @return the tenantName
	 */
	public String getTenantName() {
		return tenantName;
	}

	/**
	 * @param tenantName the tenantName to set
	 */
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the accountDetail
	 */
	public Integer getAccountDetail() {
		return accountDetail;
	}

	/**
	 * @param accountDetail the accountDetail to set
	 */
	public void setAccountDetail(Integer accountDetail) {
		this.accountDetail = accountDetail;
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

	@Override
	public String toString() {
		return "TestTenantDTO [tenantId=" + tenantId + ", tenantName=" + tenantName + ", mobile=" + mobile + ", email="
				+ email + ", accountDetail=" + accountDetail + ", apartmentId=" + apartmentId + "]";
	}



	
	
}
