/**
 * 
 */
package com.apartment.apartmentPortal.Entity;

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
@Entity
public class ApartmentEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer apartmentId;
	private Integer apartmentNumber;
	private String apartmentName;
	private String location;
	private String apartmentOwner;
	@ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
	private UserEntity user;
	/**
	 * https://en.wikibooks.org/wiki/Java_Persistence/OneToMany#Example_of_a_OneToMany_relationship_database
	   Unidirectional one To Many mapping
	   This will work and it will create a join table with primary key of Apartment and Tenant
	   First one is used mostly. Second is the old way of specify the table details. Third one is just a tempId columns similar
	   to first one.
	   1)@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	   2)@JoinTable(joinColumns = @JoinColumn(name="apartmentId"),
		  inverseJoinColumns  =  @JoinColumn(name="tenantId" ))
	   3)@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
		 @JoinColumn(name="tempId", referencedColumnName="apartmentId")
	 */
	//@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL)
	List<TenantEntity> tenants;
	
	
	/**
	  Bidirectional mapping  one To Many (to TestTenant) & Many to One(to Apartment) mapping
	  mappedBy will add a foreign key to TestTenant table and will be the owner of the relationship
	 */
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,mappedBy="apartment")
	List<TestTenantEntity> testtenants;
	
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
	public UserEntity getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserEntity user) {
		this.user = user;
	}
	/**
	 * @return the tenants
	 */
	public List<TenantEntity> getTenants() {
		if(null==tenants) {
			tenants = new ArrayList<TenantEntity>();
		}
		return tenants;
	}
	/**
	 * @param tenants the tenants to set
	 */
	public void setTenants(List<TenantEntity> tenants) {
		this.tenants = tenants;
	}
	public List<TestTenantEntity> getTesttenants() {
		if(null==testtenants) {
			testtenants = new ArrayList<TestTenantEntity>();
		}
		return testtenants;
	}
	public void setTesttenants(List<TestTenantEntity> testtenants) {
		this.testtenants = testtenants;
	}
	@Override
	public String toString() {
		return "Apartment [apartmentId=" + apartmentId + ", apartmentNumber=" + apartmentNumber + ", apartmentName="
				+ apartmentName + ", location=" + location + ", apartmentOwner=" + apartmentOwner + ", user=" + user
				+ ", tenants=" + tenants + ", testtenants=" + testtenants + "]";
	}
	
	
	
	
	
}
