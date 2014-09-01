package org.javabrains.ravikanth.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="USER_DETAILS")
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
	
	// One-to-many mapping
	@OneToMany
	//Configure the join table properties
	@JoinTable(joinColumns=@JoinColumn(name="USESR_ID"), inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	private Collection<Vehicle> vehicles=new ArrayList<Vehicle>();

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


	public Collection<Vehicle> getVehicles() {
		if(this.vehicles==null) this.vehicles=new ArrayList<Vehicle>();
		return this.vehicles;
	}
	

}
