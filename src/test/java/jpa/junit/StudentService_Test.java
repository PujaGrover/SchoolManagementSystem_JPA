package jpa.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jpa.entitymodels.Student;
import jpa.service.StudentService;

public class StudentService_Test {
	
	@Test
	public void getStudentByEmailTest() {
		
		StudentService sc = new StudentService();
		Student actual = null;
		Student expected = null;
		
		actual = sc.getStudentByEmail("htaffley6@columbia.edu");
		System.out.println(actual.getsEmail() + " " + actual.getsName() + " " + actual.getsPass() + " " + actual.getsCourses());
		expected = new Student("htaffley6@columbia.edu", "Holmes Taffley", "xowtOQ", null);
		
		assertEquals(actual,expected);
	}
	
	@Test
	public void validateStudent() {
		StudentService sc = new StudentService();
		boolean actual = false;
		boolean expected = true;
		
		actual = sc.validateStudent("tattwool4@biglobe.ne.jp", "Hjt0SoVmuBz");

		assertEquals(actual,expected);
		
	}
	

}
