package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Cource;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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

			// create a course
			Cource tempCource = new Cource("Pacman - how to scorce one Million");

			// save the course
			System.out.println("\nsaving the course...");
			session.save(tempCource);
			System.out.println("saved the course: " + tempCource);

			// create the student
			Student tempStudent = new Student("prasad", "Chaudhari", "prasad@gmail.com");
			Student tempStudent1 = new Student("snehal", "Chaudhari", "snehal@gmail.com");

			// add students to the course
			tempCource.addStudent(tempStudent);
			tempCource.addStudent(tempStudent1);

			// save the students
			session.save(tempStudent);
			session.save(tempStudent1);
			
			System.out.println("get student ------------> "+ tempCource.getStudents());
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
