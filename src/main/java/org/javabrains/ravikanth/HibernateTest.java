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
	
		//Create the model object to be saved
		UserDetails userDetails=new UserDetails();
		userDetails.setUserName("Ravikanth");
		Address addr=new Address();
		addr.setCity("San Jose");
		addr.setState("CA");
		addr.setStreet("The Alameda");
		addr.setZipcode("95126");
		userDetails.setAddress(addr);
		userDetails.setJoinDate(new Date());
		userDetails.setDescription("Some sample Description.");
		
		
		UserDetails userDetails2=new UserDetails();
		userDetails2.setUserName("Ravikanth2");
		Address addr2=new Address();
		addr2.setCity("Milipitas");
		addr2.setState("CA");
		addr2.setStreet("Montogue");
		addr2.setZipcode("95132");
		userDetails2.setAddress(addr2);		
		userDetails2.setJoinDate(new Date());
		userDetails2.setDescription("Some sample Description 2.");
		
		//begin the transaction
		session.beginTransaction();
		
		//save the object
		session.save(userDetails);
		session.save(userDetails2);

		//commit the transaction
		session.getTransaction().commit();
		
		//release the resources;
		session.close();
		
		
		session=sf.openSession();
		
		
		//retrieve the record using primary key
		UserDetails uD=(UserDetails)session.get(UserDetails.class, 1);
		
		System.out.println(uD.getAddress().getCity());
		System.out.println(uD.getDescription());
		System.out.println(uD.getUserId());
		System.out.println(uD.getUserName());
		System.out.println(uD.getJoinDate());
		
		
        uD=(UserDetails)session.get(UserDetails.class, 2);
		
		System.out.println(uD.getAddress().getCity());
		System.out.println(uD.getDescription());
		System.out.println(uD.getUserId());
		System.out.println(uD.getUserName());
		System.out.println(uD.getJoinDate());
		

		session.close();
		sf.close();
		
	}
}
