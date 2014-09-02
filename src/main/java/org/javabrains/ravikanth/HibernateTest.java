package org.javabrains.ravikanth;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String [] args){

		//Build session factory and open a session
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.getTransaction().begin();
		
		Query query=session.createQuery("from UserDetails where userId > 5");
		List users=query.list();
		session.getTransaction().commit();
		session.close();
		sf.close();
			
		System.out.println("Number of users in the table : "+users.size());
	}
}
