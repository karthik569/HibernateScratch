package org.javabrains.ravikanth;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.javabrains.ravikanth.dto.UserDetails;

public class HibernateTest {

	public static void main(String [] args){

		//Build session factory and open a session
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		//SessionFactory sf=new AnnotationConfiguration().configure(new File("hibernate.cfg.xml")).buildSessionFactory();
		
		Session session=sf.openSession();
		session.getTransaction().begin();
		
		UserDetails uD=(UserDetails)session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		
		//Open the session again and retrieve the object
		// Observe the number of select statements in the console.
		session = sf.openSession();
		session.getTransaction().begin();
		
		uD=(UserDetails)session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
			
		
	}
}
