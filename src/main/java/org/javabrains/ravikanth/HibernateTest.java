package org.javabrains.ravikanth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.ravikanth.dto.UserDetails;

public class HibernateTest {

	public static void main(String [] args){

		//Build session factory and open a session
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.getTransaction().begin();
		
		UserDetails uD=(UserDetails) session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		//make changes to the detached object
		uD.setUserName("Ravikanth Updated.");
		
		//retrieve the object and update the record
		session=sf.openSession();
		session.getTransaction().begin();
		
		session.update(uD);
		
		session.getTransaction().commit();
		session.close();
		
		//retrieve again to see if the update happened
		session=sf.openSession();
		session.getTransaction().begin();
		
		uD=(UserDetails)session.get(UserDetails.class, 1);
		
		System.out.println("Name : "+uD.getUserName());
		session.close();
		
		
	}
}
