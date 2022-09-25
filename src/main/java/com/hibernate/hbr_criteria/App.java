package com.hibernate.hbr_criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class App {
	public static void main(String[] args) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		
		//writeToDB(session);
		
		Criteria criteria = session.createCriteria(Laptop.class);
		
//		List<Laptop> laptops = criteria.list();	//All Laptops
		
//		criteria.add(Restrictions.gt("id", 46));	//Laptop with id greater than 46
		
//		criteria.add(Restrictions.lt("id", 16));	//Laptop with id less than 16
		
//		criteria.add(Restrictions.like("brand", "%1"));	//brand ending with 1
		
		criteria.add(Restrictions.eqOrIsNull("id", 33));
		
		List<Laptop> laptops = criteria.list();
		laptops.forEach(System.out::println);
		

	}

	private static void writeToDB(Session session) {
		
		session.beginTransaction();
		
		for (int i = 1; i < 51; i++)
			session.save(new Laptop(i, "Dell" + i));
		
		session.getTransaction().commit();
	}
}
