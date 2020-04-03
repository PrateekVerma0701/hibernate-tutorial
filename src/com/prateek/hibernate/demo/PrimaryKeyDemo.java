package com.prateek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prateek.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			// create 3 student objects
			System.out.println("Creating 3 student objects...");

			Student student1 = new Student("John", "Smith", "john.smith@gmail.com");
			Student student2 = new Student("Vinay", "Singh", "vinay.singh@gmail.com");
			Student student3 = new Student("Prateek", "Verma", "prateek.verma@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the students record...");

			session.save(student1);
			session.save(student2);
			session.save(student3);

			// commit transaction
			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}
	}
}
