package jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService implements StudentDAO {

	// CODE FOR REQUIREMENT 4
	// IMPLEMENTED METHODS
	// 1. public void createStudent(Student student)
	// 2. public List<Student> getAllStudents()
	// 3. public Student getStudentByEmail(String sEmail)
	// 4. public boolean validateStudent(String sEmail, String sPassword)
	// 5. registerStudentToCourse(String sEmail, int cId)
	// 6. public List<Course> getStudentCourses(String sEmail)

	EntityManagerFactory emfactory = null;
	EntityManager entitymanager = null;

	// Store Student in the database
	public void createStudent(Student student) {

		try {
			emfactory = Persistence.createEntityManagerFactory("SMS");
			entitymanager = emfactory.createEntityManager();
			entitymanager.getTransaction().begin();
			entitymanager.persist(student);
			entitymanager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error creating the student.");
		} finally {
			entitymanager.close();
			emfactory.close();
		}

	}

	@Override
	public List<Student> getAllStudents() {

		List<Student> studentList = new ArrayList<Student>();

		try {
			emfactory = Persistence.createEntityManagerFactory("SMS");
			entitymanager = emfactory.createEntityManager();

			studentList = entitymanager.createQuery("SELECT s FROM Student s", Student.class).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error getting the student list.");
		} finally {
			entitymanager.close();
			emfactory.close();
		}

		return studentList;
	}

	@Override
	public Student getStudentByEmail(String sEmail) {

		emfactory = Persistence.createEntityManagerFactory("SMS");
		entitymanager = emfactory.createEntityManager();
		//entitymanager.getTransaction().begin();

		Student foundStudent = new Student();
		foundStudent = entitymanager.find(Student.class, sEmail);
		//entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

		// Check if foundStudent is not empty and return the result
		if (foundStudent != null) {
			return foundStudent;
		} else {
			return null;
		}

	}

	@Override
	public boolean validateStudent(String sEmail, String sPassword) {

		emfactory = Persistence.createEntityManagerFactory("SMS");
		entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Student student = new Student();
		student = entitymanager.find(Student.class, sEmail);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

		if (student != null) {
			if ((student.getsEmail().equals(sEmail)) && (student.getsPass().equals(sPassword))) {

				return true;

			} else {
				return false;
			}//if-else
		} else {
			return false;
		}//if-else
	}

	@Override
	public void registerStudentToCourse(String sEmail, int cId) {

		try {

			emfactory = Persistence.createEntityManagerFactory("SMS");
			entitymanager = emfactory.createEntityManager();

			//entitymanager.getTransaction().begin(); TEST
			// Get the Student object using the sEmail
			Student student = new Student();
			student = entitymanager.find(Student.class, sEmail);
			// Create newCourse object.
			//Using cId find the Course that matches with that course Id in Course Class and store it in newCourseObject
			Course newCourse = new Course();
			newCourse = entitymanager.find(Course.class, cId);

			// Create list of course object.
			// Get the list of courses that student has registered and store the list in studentCourses List.
			List<Course> studentCourses = new ArrayList<Course>();
			studentCourses = student.getsCourses();

			// Add the the newCourse to studentCourses
			studentCourses.add(newCourse);
			Student studentRegistered = new Student(student.getsEmail(), student.getsName(), student.getsPass(),
					studentCourses);
			entitymanager.getTransaction().begin();
			entitymanager.merge(studentRegistered);
			entitymanager.getTransaction().commit();

		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error registering the student.");
		} finally {
			entitymanager.close();
			emfactory.close();
		}

	}

	@Override
	public List<Course> getStudentCourses(String sEmail) {

		List<Course> studentCourses = new ArrayList<Course>();
		
		try {
			emfactory = Persistence.createEntityManagerFactory("SMS");
			entitymanager = emfactory.createEntityManager();
			// entitymanager.getTransaction().begin();

			Student student = new Student();
			student = entitymanager.find(Student.class, sEmail);

			studentCourses = student.getsCourses();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error getting the list of student courses.");
		}finally {
			entitymanager.close();
			emfactory.close();
		}
		return studentCourses;

	}

}
