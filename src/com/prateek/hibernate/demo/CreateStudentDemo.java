package com.prateek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prateek.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			// create a student object
			System.out.println("Creating new student object...");
			Student student = new Student("John", "Smith", "john.smith@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student record...");
			session.save(student);

			// commit transaction
			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}
	}

}
