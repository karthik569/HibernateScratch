package org.javabrains.ravikanth.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name="USER_DETAILS")
public class UserDetails {
	
	@Id
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Temporal(TemporalType.DATE)
	private java.util.Date joinDate;
	private String address;
	@Lob
	private String description;
	
	
	
	public java.util.Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(java.util.Date date) {
		this.joinDate = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
