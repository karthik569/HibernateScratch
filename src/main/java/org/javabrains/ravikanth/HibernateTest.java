package org.javabrains.ravikanth;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.ravikanth.dto.Address;
import org.javabrains.ravikanth.dto.UserDetails;

public class HibernateTest {

	public static void main(String [] args){
		
		// Build Session factory from the Xml configuration file
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
		//Open a session
		Session session=sf.openSession();
		
		// begin the transaction
		session.getTransaction().begin();
		
		//Create model objects
		UserDetails userDetails=new UserDetails();
		userDetails.setUserName("Ravikanth");
		userDetails.setJoinDate(new Date());
		userDetails.setDescription("Some Description");
		Address addr=new Address();
		addr.setCity("San Jose");
		addr.setState("California");
		addr.setStreet("The Alameda");
		addr.setZipcode("95126");
		userDetails.getAddresses().add(addr);
		Address addr2=new Address();
		addr2.setCity("Buffalo");
		addr2.setState("New York");
		addr2.setStreet("Englewood");
		addr2.setZipcode("14221");
		userDetails.getAddresses().add(addr2);
		
		//save the object into database
		session.save(userDetails);
		
		//commit the transaction
		session.getTransaction().commit();
		
		session.close();
		
		session=sf.openSession();
		UserDetails ud=(UserDetails)session.get(UserDetails.class, 1);
		
		System.out.println("User Details");
		System.out.println("Name " + ud.getUserName());
		System.out.println("id "+ ud.getUserId());
		System.out.println("Number of Addresses : "+ud.getAddresses().size());
		
		
		// Release the resources
		session.close();
		sf.close();
	}
}
