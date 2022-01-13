/**
 * 
 */
package com.application.dto;

import java.util.List;

/**
 * @author avi08
 *
 */
public class UserDTO {

	private Integer userId;
	private String userName;
	private String password;
	private String email;
	private String mobile;
	private String dob;
	private String gender;
	private String userType;
	private List<ApartmentDTO> apartments;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
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
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	/**
	 * @return the apartments
	 */
	public List<ApartmentDTO> getApartments() {
		return apartments;
	}
	/**
	 * @param apartments the apartments to set
	 */
	public void setApartments(List<ApartmentDTO> apartments) {
		this.apartments = apartments;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", mobile=" + mobile + ", dob=" + dob + ", gender=" + gender + ", userType=" + userType
				+ ", apartments=" + apartments + "]";
	}
	
	
}
