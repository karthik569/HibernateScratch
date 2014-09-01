package org.javabrains.ravikanth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.ravikanth.dto.UserDetails;

public class HibernateTest {

	public static void main(String [] args){
		
		//build the model objects
		UserDetails uD=new UserDetails();
		uD.setUserName("Ravikanth");
		
		//Build session factory and open a session
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.getTransaction().begin();
		
		session.save(uD);
		uD.setUserName("Updated User Name.");
		
		session.getTransaction().commit();
		session.close();
		
		//retrieve the object and display the result
		session=sf.openSession();
		uD=(UserDetails)session.get(UserDetails.class, 1);
		System.out.println("Name : "+uD.getUserName());
		
		session.close();
		sf.close();
	}
}
