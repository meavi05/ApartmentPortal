/**
 * 
 */
package com.application.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author avi08
 *
 */
@Entity
@NamedQuery(name = "UserEntity.findByEmail", query = "SELECT u FROM UserEntity u WHERE u.email=:email")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer userId;
	
	@Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
	@Column(unique = true, nullable = false)
	private String userName;
	
	@Size(min = 3, message = "Minimum password length: 3 characters")
	private String password;
	@Column(unique = true )
	private String email;
	private String mobile;
	private String dob;
	private String gender;
	private String userType;
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user",fetch=FetchType.EAGER)
	@JsonManagedReference
	@ElementCollection(fetch = FetchType.EAGER)
	private List<ApartmentEntity> apartments;
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
	public List<ApartmentEntity> getApartments() {
		if(null==apartments) {
			apartments = new ArrayList<ApartmentEntity>();
		}
		return apartments;
	}
	/**
	 * @param apartments the apartments to set
	 */
	public void setApartments(List<ApartmentEntity> apartments) {
		this.apartments = apartments;
	}
	@Override
	public String toString() {
		return "UserData [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", mobile=" + mobile + ", dob=" + dob + ", gender=" + gender + ", userType=" + userType
				+ ", apartments=" + apartments + "]";
	}
	
}
