package org.javabrains.ravikanth.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
		
	// List of addresses
	@ElementCollection
	@JoinTable(name="USER_ADDRESS")// configure the name of join table
	@GenericGenerator(name="hilo-generator", strategy="hilo")// define a primary key generator 
	@CollectionId(columns = { @Column(name="PK") }, generator = "hilo-generator", type = @Type(type="long"))
	private Collection<Address> addresses=new ArrayList<Address>();
	
	public Collection<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
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
