package org.javabrains.ravikanth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.ravikanth.dto.UserDetails;

public class HibernateTest {

	public static void main(String [] args){
		
		
		//Build session factory
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		//Open a session
		Session session=sf.openSession();
		
		//begin the transaction
		session.getTransaction().begin();
		
		// build the model objects
		for(int i=1;i<=10;i++){
			UserDetails ud=new UserDetails();
			ud.setUserName("User "+i);
			session.save(ud);
		}
		
		session.getTransaction().commit();
		session.close();
		
		
		//open a new session
		session=sf.openSession();
		session.getTransaction().begin();
		
		//perform the update operation
		UserDetails ud=(UserDetails)session.get(UserDetails.class, 5);
		ud.setUserName("Updated User");
		session.update(ud);
		
		//peform the deletion operation
		ud=(UserDetails)session.get(UserDetails.class, 10);
		session.delete(ud);
		
		session.getTransaction().commit();
		session.close();
		
		//Verify the above operations
		session=sf.openSession();
		session.getTransaction().begin();
		
		ud=(UserDetails)session.get(UserDetails.class, 5);
		System.out.println("update name of the User : "+ud.getUserName());
		
		session.clear();
		sf.close();
	}
}
