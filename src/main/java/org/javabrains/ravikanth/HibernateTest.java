package org.javabrains.ravikanth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.ravikanth.dto.FourWheeler;
import org.javabrains.ravikanth.dto.TwoWheeler;
import org.javabrains.ravikanth.dto.Vehicle;

public class HibernateTest {

	public static void main(String [] args){
		
		
		//build the model objects
		Vehicle v=new Vehicle();
		v.setVehicleName("Vehicle");
		
		TwoWheeler tv=new TwoWheeler();
		tv.setSteeringHandle("Monkey Handle");
		tv.setVehicleName("Ducati");
		
		FourWheeler fw=new FourWheeler();
		fw.setSteeringWheel("Five Spoke Wheel");
		fw.setVehicleName("Skoda");
		
		//build the sessionfactory from the configuratino file
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		//open a session
		Session session=sf.openSession();
		//begin the transaction
		session.getTransaction().begin();
		
		//save the objects
		session.save(v);
		session.save(tv);
		session.save(fw);
		
		//commit the transaction
		session.getTransaction().commit();
		//close the session.
		
		session.close();
		sf.close();
	}
}
