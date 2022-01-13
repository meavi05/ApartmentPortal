/**
 * 
 */
package com.application.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author avi08
 *
 */
@Entity
public class TenantEntity_Old implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer tenantId;
	private String name;
	private String mobile;
	private String email;
	private Integer accountDetail;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the apartment
	 */
	/*
	 * public Apartment getApartment() { return apartment; }
	 *//**
		 * @param apartment the apartment to set
		 *//*
			 * public void setApartment(Apartment apartment) { this.apartment = apartment; }
			 * 
			 * @Override public String toString() { return "Tenant [tenantId=" + tenantId +
			 * ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", apartment="
			 * + apartment + ", accountDetail=" + accountDetail + "]"; }
			 */

}
