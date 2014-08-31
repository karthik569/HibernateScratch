package org.javabrains.ravikanth.dto;

import java.sql.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Generated;

@Entity(name="USER_DETAILS")
public class UserDetails {
	
	// Primary key
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	
	//User Name
	@Column(name="USER_NAME")
	private String userName;
	
	//Joining date
	@Temporal(TemporalType.DATE)
	private java.util.Date joinDate;
	
	// Small  descriptoin about the employee
	@Lob
	private String description;
		
	//Address object(home Address)
	@Embedded
	@AttributeOverrides(
			{@AttributeOverride(name="street", column=@Column(name="HOME_STREET")),
			 @AttributeOverride(name="city", column=@Column(name="HOME_CITY")),
			 @AttributeOverride(name="state" , column=@Column(name="HOME_STATE")),
			 @AttributeOverride(name="zipcode", column=@Column(name="HOME_ZIPCODE"))
			}	
		)
	private Address homeAddress;
	
	//Address object(office address)
	@Embedded
	@AttributeOverrides(
		{@AttributeOverride(name="street", column=@Column(name="OFFICE_STREET")),
		 @AttributeOverride(name="city", column=@Column(name="OFFICE_CITY")),
		 @AttributeOverride(name="state" , column=@Column(name="OFFICE_STATE")),
		 @AttributeOverride(name="zipcode", column=@Column(name="OFFICE_ZIPCODE"))
		}
	)
	private Address officeAddress;
	
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public java.util.Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(java.util.Date date) {
		this.joinDate = date;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UserDetails(){
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
