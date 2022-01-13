/**
 * 
 */
package com.application.dto;

import java.io.Serializable;

/**
 * @author avi08
 *
 */
public class TenantDTO_Old implements Serializable {

	private static final long serialVersionUID = 1L;
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

	@Override
	public String toString() {
		return "TenantDTO [tenantId=" + tenantId + ", name=" + name + ", mobile=" + mobile + ", email=" + email
				+ ", accountDetail=" + accountDetail + "]";
	}
	
}
