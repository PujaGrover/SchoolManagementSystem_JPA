package jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

public class CourseService implements CourseDAO {

	// CODE FOR REQUIREMENT 4
	// IMPLEMENTED METHODS
	// 1. public void createCourse(Course newCourse)
	// 2. publicList<Course> getAllCourses()

	EntityManagerFactory emfactory = null;
	EntityManager entitymanager = null;

	// Store Course in the database
	public void createCourse(Course newCourse) {

		try {
			emfactory = Persistence.createEntityManagerFactory("SMS");
			entitymanager = emfactory.createEntityManager();
			entitymanager.getTransaction().begin();
			entitymanager.persist(newCourse);
			entitymanager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error creating the course object.");
		} finally {
			entitymanager.close();
			emfactory.close();
		}

	}

	@Override
	public List<Course> getAllCourses() {

		// Creating an object of list of courses
		List<Course> sCourses = new ArrayList<Course>();

		try {
			emfactory = Persistence.createEntityManagerFactory("SMS");
			entitymanager = emfactory.createEntityManager();

			// Filling the course list sCourses with the course list from the database
			sCourses = entitymanager.createQuery("SELECT s FROM Course s", Course.class).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error getting the course list.");
		} finally {
			entitymanager.close();
			emfactory.close();
		}

		return sCourses;
	}

}
