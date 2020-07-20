package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Cource;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class GetCoursesDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Cource.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		// create session

		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();
			
			// get student mary from database
			int ID = 2;
			Student tempStudent = session.get(Student.class, ID);	
			System.out.println(tempStudent);
			System.out.println("courses : "+ tempStudent.getCource());
		
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done...........");
		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
