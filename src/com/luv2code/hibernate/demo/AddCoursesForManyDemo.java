package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Cource;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForManyDemo {

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
			
			System.out.println("courses : "+ tempStudent.getCource());
			
			// create more courses
			Cource tempCource = new Cource(" learn All Java ");
			Cource tempCource1 = new Cource(" learn All Node js ");
			
			// add student to courses
			tempCource.addStudent(tempStudent);
			tempCource1.addStudent(tempStudent);
			
			//save the courses
			System.out.println("save done");
			session.save(tempCource);
			session.save(tempCource1);
			
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
