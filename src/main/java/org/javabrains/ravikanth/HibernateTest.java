package org.javabrains.ravikanth;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.javabrains.ravikanth.dto.UserDetails;

public class HibernateTest {

	public static void main(String [] args){

		//Build session factory and open a session
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.getTransaction().begin();
		
		//create a criteria object and add restrictions
		/*Example 1 using criteria and projection*/
		Criteria criteria=session.createCriteria(UserDetails.class)
				                 .setProjection(Projections.property("userName"));
		
		List<String> users=(List<String>)criteria.list();
		
		/*Example 2 using criteria and prjection */
		Criteria c2=session.createCriteria(UserDetails.class)
						   .setProjection(Projections.property("userId"));
		List<Integer> userIds =(List<Integer>)c2.list();
		
		/*Example using "Example" object */		
		UserDetails exampleUser=new UserDetails();
		exampleUser.setUserName("User 10");
		Example example =Example.create(exampleUser);
		Criteria c3= session.createCriteria(UserDetails.class)
							.add(example);
		
		List<UserDetails> uD=(List<UserDetails>)c3.list();
		
		
		
		session.getTransaction().commit();
		session.close();
		sf.close();
			
		System.out.println("Number of users in the table : "+users.size());
		
		
		System.out.println("Projection result of usernames");
		for(String user : users) System.out.println(" Name  : "+user);
		
		
		System.out.println("Projection result of userIds");
		for(Integer id : userIds) System.out.println("Id : "+id);
		
		
		System.out.println("Result using Example object");
		System.out.println("Result size : "+uD.size());
	}
}
