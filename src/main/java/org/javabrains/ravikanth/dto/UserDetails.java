package org.javabrains.ravikanth.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	//Another entity inside this class
	// one-to-one mapping
	
	@OneToOne
	private Vehicle vehicle;

	public UserDetails(){
		
	}
	
	
	public java.util.Date getJoinDate() {
		return joinDate;
	}
	
	public void setJoinDate(java.util.Date date) {
		this.joinDate = date;
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
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
