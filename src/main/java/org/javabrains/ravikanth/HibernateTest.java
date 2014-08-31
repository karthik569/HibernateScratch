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
		userDetails.setJoinDate(new Date());
		userDetails.setDescription("Some sample Description.");
		Address homeAddr=new Address();
		homeAddr.setCity("San Jose");
		homeAddr.setState("CA");
		homeAddr.setStreet("The Alameda");
		homeAddr.setZipcode("95126");
		userDetails.setHomeAddress(homeAddr);
		Address officeAddr=new Address();
		officeAddr.setCity("SUNNY VALE");
		officeAddr.setState("CA");
		officeAddr.setStreet("NORTH FIRST STREET");
		officeAddr.setZipcode("95100");
		userDetails.setOfficeAddress(officeAddr);
		
		
		UserDetails userDetails2=new UserDetails();
		userDetails2.setUserName("Ravikanth2");
		userDetails2.setJoinDate(new Date());
		userDetails2.setDescription("Some sample Description 2.");
		Address homeAddr2=new Address();
		homeAddr2.setCity("Buffalo");
		homeAddr2.setState("NY");
		homeAddr2.setStreet("Englewood");
		homeAddr2.setZipcode("14214");
		userDetails2.setHomeAddress(homeAddr2);
		Address officeAddr2=new Address();
		officeAddr2.setCity("Amherst");
		officeAddr2.setState("NY");
		officeAddr2.setStreet("Flint Loop");
		officeAddr2.setZipcode("14221");
		userDetails2.setOfficeAddress(officeAddr2);
		
		//begin the transaction
		session.beginTransaction();
		
		//save the objects
		session.save(userDetails);
		session.save(userDetails2);

		//commit the transaction
		session.getTransaction().commit();
		
		//release the resources;
		session.close();		
		
		//open the session to retrieve objects
		session=sf.openSession();
			
		//retrieve the record using primary key
		UserDetails uD=(UserDetails)session.get(UserDetails.class, 1);
		
		System.out.println(uD.getHomeAddress().getCity());
		System.out.println(uD.getOfficeAddress().getCity());
		System.out.println(uD.getDescription());
		System.out.println(uD.getUserId());
		System.out.println(uD.getUserName());
		System.out.println(uD.getJoinDate());
		
		
        uD=(UserDetails)session.get(UserDetails.class, 2);
		
		System.out.println(uD.getHomeAddress().getCity());
		System.out.println(uD.getOfficeAddress().getCity());
		System.out.println(uD.getDescription());
		System.out.println(uD.getUserId());
		System.out.println(uD.getUserName());
		System.out.println(uD.getJoinDate());
		

		//close the resources
		session.close();
		sf.close();
		
	}
}
