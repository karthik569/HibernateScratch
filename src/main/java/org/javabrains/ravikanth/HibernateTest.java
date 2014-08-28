package org.javabrains.ravikanth;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.ravikanth.dto.UserDetails;

public class HibernateTest {

	public static void main(String [] args){
		
		// Build Session factory from the Xml configuration file
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
		//Open a session
		Session session=sf.openSession();
	
		//Create the model object to be saved
		UserDetails userDetails=new UserDetails();
		userDetails.setUserId(1);
		userDetails.setUserName("Ravikanth");
		userDetails.setAddress("754 The Alameda");
		userDetails.setJoinDate(new Date());
		userDetails.setDescription("Some sample Description.");
		
		//begin the transaction
		session.beginTransaction();
		
		//save the object
		session.save(userDetails);

		//commit the transaction
		session.getTransaction().commit();
		
		//release the resources;
		session.close();
		sf.close();
		
	}
}
