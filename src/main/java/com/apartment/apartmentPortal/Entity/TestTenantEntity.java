/**
 * 
 */
package com.apartment.apartmentPortal.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author avi08
 *
 */
@Entity
@NamedQuery(name = "TestTenantEntity.findByEmail", query = "SELECT t FROM TestTenantEntity t WHERE t.email=:email")
public class TestTenantEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer tenantId;
	private String tenantName;
	private String mobile;
	private String email;
	private Integer accountDetail;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonBackReference
	private ApartmentEntity apartment;

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

	public ApartmentEntity getApartment() {
		return apartment;
	}

	public void setApartment(ApartmentEntity apartment) {
		this.apartment = apartment;
	}

	@Override
	public String toString() {
		return "TestTenant [tenantId=" + tenantId + ", name=" + tenantName + ", mobile=" + mobile + ", email=" + email
				+ ", accountDetail=" + accountDetail + ", apartment=" + apartment + "]";
	}
	
	
}