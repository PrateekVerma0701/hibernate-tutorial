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

			// display the students
			displayStudents(students);

			// query student: lastName='Verma'
			students = session.createQuery("from Student s where s.lastName='Verma'").list();

			// display the students
			System.out.println("\n\nStudents who have last name of Verma");
			displayStudents(students);

			// query student: lastName='Verma' OR firstName='John'
			students = session.createQuery("from Student s where" + " s.lastName='Verma' OR s.firstName='John'").list();

			// display the students
			System.out.println("\n\nStudents who have last name of Verma OR first name of Smith");
			displayStudents(students);

			// query students where email LIKE '%gmail.com'
			students = session.createQuery("from Student s where"
					+" s.email LIKE '%yahoo.com'").list();

			System.out.println("\n\nStudents who have email adress end with gmail.com");
			displayStudents(students);

			// commit transaction
			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student tempStudent : students) {
			System.out.println(tempStudent);
		}
	}

}
