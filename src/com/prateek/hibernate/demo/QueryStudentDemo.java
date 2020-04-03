package com.prateek.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prateek.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> students = session.createQuery("from Student").list();

			for (Student tempStudent : students) {
				System.out.println(tempStudent);
			}

			// commit transaction
			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}
	}

}
