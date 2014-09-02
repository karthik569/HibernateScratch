package org.javabrains.ravikanth;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.javabrains.ravikanth.dto.UserDetails;

public class HibernateTest {

	public static void main(String [] args){

		//Build session factory and open a session
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.getTransaction().begin();
		
		//create a criteria object and add restrictions
		Criteria criteria=session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("userName", "User 10"));
		
		
		List<UserDetails> users=(List<UserDetails>)criteria.list();
		session.getTransaction().commit();
		session.close();
		sf.close();
			
		System.out.println("Number of users in the table : "+users.size());
		
		for(UserDetails user : users) System.out.println(" Name  : "+user.getUserName());
	}
}
