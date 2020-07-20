package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Cource;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Cource.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
		// create session

		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// create a course
			Cource tempCource = new Cource("Pacman - how to scorce one Million");

			// add some reviews
			tempCource.addReview(new Review("Great course ... loved it! "));
			tempCource.addReview(new Review("cool course, job well donw!"));
			tempCource.addReview(new Review("what a dumb course, you are an idiot ! "));

			// save the course ... the leverage the cascade all :- )
			System.out.println("Saving the course");
			System.out.println(tempCource);
			System.out.println(tempCource.getReview());
			session.save(tempCource);

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
