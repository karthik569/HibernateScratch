package org.javabrains.ravikanth;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.ravikanth.dto.Address;
import org.javabrains.ravikanth.dto.UserDetails;
import org.javabrains.ravikanth.dto.Vehicle;

public class HibernateTest {

	public static void main(String [] args){
		
		// Build Session factory from the Xml configuration file
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		//Open a session
		Session session=sf.openSession();
		
		//begin the transaction
		session.getTransaction().begin();
		
		//Build the modle object
		UserDetails userDetails=new UserDetails();
		
		userDetails.setJoinDate(new Date());
		userDetails.setUserName("Ravikanth");
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Lamborgini");
		userDetails.setVehicle(vehicle);
		
		//save the objects
		session.save(userDetails);
		session.save(vehicle);
		
		// commit and and close the session
		session.getTransaction().commit();
		session.close();
		
		//open the session again and retreive the objects
		session=sf.openSession();
		UserDetails uD=(UserDetails)session.get(UserDetails.class, 1);
		Vehicle v=uD.getVehicle();
		
		System.out.println("User Name : "+uD.getUserName());
		System.out.println("Vehicle Name : "+uD.getVehicle().getVehicleName());
		
		session.close();
		sf.close();
	}
}
