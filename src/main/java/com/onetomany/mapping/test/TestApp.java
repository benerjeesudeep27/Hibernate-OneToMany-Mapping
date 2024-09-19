package com.onetomany.mapping.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.onetomany.mapping.entity.House;
import com.onetomany.mapping.entity.Student;

public class TestApp {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		Properties props = new Properties();
		props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		props.put(Environment.URL, "jdbc:mysql://localhost:3306/One_To_Many");
		props.put(Environment.USER, "root");
		props.put(Environment.PASS, "Shiva@12345");
		props.put(Environment.HBM2DDL_AUTO, "update");
		props.put(Environment.SHOW_SQL, "true");
		props.put(Environment.FORMAT_SQL, "true");
		cfg.setProperties(props);
		cfg.addAnnotatedClass(House.class);
		cfg.addAnnotatedClass(Student.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		StandardServiceRegistry registry = builder.applySettings(cfg.getProperties()).build();
		SessionFactory factory = cfg.buildSessionFactory(registry);
		Session session = factory.openSession();
		Student std = new Student();
		std.setName("Kabir Singh");
		std.setCls("12th");
		Student std1 = new Student();
		std1.setName("Kabir Singh");
		std1.setCls("12th");
		Student std2 = new Student();
		std2.setName("Kabir Singh");
		std2.setCls("12th");
		List<Student> list = new ArrayList<Student>();
		list.add(std);
		list.add(std1);
		list.add(std2);
		House house = new House();
		house.setHouseId(101);
		house.setName("Gandhi");
		house.setDress("White");
		std.setHouse(house);
		std1.setHouse(house);
		std2.setHouse(house);
		house.setStudent(list);
		Transaction tx = session.beginTransaction();
		session.save(house);
//		session.save(list);
		tx.commit();
		System.out.println("Data Inserted");
		
	}
	
}
