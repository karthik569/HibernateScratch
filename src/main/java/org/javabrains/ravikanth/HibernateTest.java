package org.javabrains.ravikanth;

import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.ravikanth.dto.Address;
import org.javabrains.ravikanth.dto.UserDetails;
import org.javabrains.ravikanth.dto.Vehicle;

public class HibernateTest {

	public static void main(String [] args){
		
		
		//build the model objects;
		UserDetails userDetails=new UserDetails();
		userDetails.setJoinDate(new Date());
		userDetails.setUserName("Ravikanth");
		Vehicle v1=new Vehicle();
		v1.setVehicleName("Lamborgini");
		Vehicle v2=new Vehicle();
		v2.setVehicleName("Maserati");
		
		userDetails.getVehicles().add(v1);
		userDetails.getVehicles().add(v2);
		
		v1.getUser().add(userDetails);
		v2.getUser().add(userDetails);
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		//open a new session
		Session session=sf.openSession();
		
		//begin the transaction
		session.getTransaction().begin();
		
		session.save(userDetails);
		session.save(v1);
		session.save(v2);
		
		// commit the trasaction
		session.getTransaction().commit();
		//close the session
		session.close();
		
		//open the session again and retrieve the objects
		session=sf.openSession();
		UserDetails uD=(UserDetails)session.get(UserDetails.class, 1);
		Collection<Vehicle> vs=uD.getVehicles();
		
		System.out.println("User Name "+uD.getUserName());
		System.out.println("Number of vehicles : "+vs.size());
		System.out.println("First Vehicle Name : "+vs.size());
		
		//release the resources
		session.close();
		sf.close();
		
	}
}
