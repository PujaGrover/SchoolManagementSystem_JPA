package jpa.mainrunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {

	public static void main(String[] args) {

		// SMSRUNNER (MAIN) CODE FOR REQUIREMENT 5 STARTS HERE
		StudentService sService = new StudentService();
 		CourseService cService = new CourseService();
 		List<Course> sCourses = new ArrayList<Course>();
 		//List<Student> studentList = new ArrayList<Student>();
		
		int answer = 0;
		Scanner input = new Scanner(System.in);

		// GIVE CHOICE TO USER TO LOGIN OR QUIT
		System.out.println("Please choose the appropriate number to Login or Quit");
		System.out.println("1. Login" + "\n2. Quit" + "\nAnswer: ");
		answer = input.nextInt();

		if (answer == 1) {

			//Declare variables email, password and validation to store student input using Scanner object
			String email = null;
			String password = null;
			boolean validation = false;
			//Scanner in = new Scanner(System.in);
			// Ask for student email and password
			System.out.println("Please enter student email: ");
			email = input.next();
			System.out.println("Please enter student password: ");
			password = input.next();

			// Validate Student
			validation = sService.validateStudent(email, password);
			
            //Check if validation is true allow the student to register for a course
			//Else Print message "Wrong Credentials"
			if (validation) {
				int output = 0;
				int registerToCourse = 0;

				List<Course> studentCourses = sService.getStudentCourses(email);
                //Check if studentCourses list is not empty then print the course details that student has registered for
				//Else print "Student has not registered to any course." 
				//Give Student a choice to Register to a course or Logout
				if (!studentCourses.isEmpty()) {

					// Print all the courses the student has registered
					for (Course c : studentCourses) {
						System.out.println("CourseId: " + c.getcId() + "| CourseName: " + c.getcName()
								+ "| Instructor Name: " + c.getcInstructorName());
					}

				} else {
					System.out.println("Student has not registered to any course.");
				}//if-else

				System.out.println("Please choose the appropriate number to Register to a course or Logout");
				System.out.println("1. Register to a course" + "\n2. Logout" + "\nAnswer: ");
				output = input.nextInt();

				if (output == 1) {
					// get list of all the courses
					sCourses = cService.getAllCourses();
					// print the list of all courses
					for (Course c : sCourses) {

						System.out.println("CourseId: " + c.getcId() + "| CourseName: " + c.getcName()
								+ "! Course Instructor: " + c.getcInstructorName() + "\n");
					}
					System.out.println("Please enter the CourseId you wish to register to: ");
					registerToCourse = input.nextInt();

					// Register student to the course
					sService.registerStudentToCourse(email, registerToCourse);
					System.out.println("Student successfully registered to the course: " + registerToCourse);

				} else {
					System.out.println("You are logged out!");
				} // if-else

			} else {
				System.out.println("Wrong Credentials");
			} // if-else

		} else if (answer == 2) {
			System.out.println("Thank You!");
		} else {
			System.out.println("Invalid choice of option");
		}//if-(else-if)-else
        input.close();
        
//*************************************************************************************************************************
//  SMSRUNNER CODE FOR MAIN ENDS HERE  
        
     // TESTING: TO SEE IF THE DATA CAN BE INSERTED USING JPA IN THE DATABASE
     		// OUTPUT: DATA INPUT DONE SUCCESSFULLY IN THE DATABASE
//     		StudentService sService = new StudentService();
//     		CourseService cService = new CourseService();
//     		List<Course> sCourses = new ArrayList<Course>();
//     		
//     		Course course1 = new Course(1, "English", "Anderea Scamaden");
//     		Course course2 = new Course(2, "Mathematics", "Eustace Niemetz");
//     		cService.createCourse(course1);
//     		cService.createCourse(course2);
//     		sCourses.add(course1);
//     		sCourses.add(course2);
//     		
//     		Student student = new Student();
//     		student.setsEmail("hluckham0@google.ru");
//     		student.setsName("Hazel Luckham");
//     		student.setsPass("X1uZcoIh0dj");
//     		sService.createStudent(student);

     		// TESTING: TO SEE IF THE TABLES GOT CREATED
     		// OUTPUT: TABLES GOT CREATED IN THE DATABASE
//     		try {
//     			EntityManager em = emfactory.createEntityManager();
//     			em.createNativeQuery("SHOW TABLES");
//     			em.createNativeQuery("SHOW COLUMNS from student");
//     			em.createNativeQuery("SHOW COLUMNS from course");
//     			em.createNativeQuery("SHOW COLUMNS from student_course");
//     			em.close();
//     			
//     		}finally {
//     			emfactory.close();
//     		}
     //**********************************************************************************************************************
     		// TESTING: ALL THE METHODS
             // OUTPUT: Successful
//     		StudentService sService = new StudentService();
//     		CourseService cService = new CourseService();
//     		List<Course> sCourses = new ArrayList<Course>();
//     		List<Student> studentList = new ArrayList<Student>();

     		// TESTING: getAllCourses() and getAllStudents
     		// OUTPUT: Successful
//     		sCourses = cService.getAllCourses();
//     		studentList = sService.getAllStudents();
//     		// TESTING: Printing the list of all courses
//     		for (Course c : sCourses) {
//     			System.out.println("CourseId: " + c.getcId() + " CourseName: " + c.getcName() + "Instructor: "
//     					+ c.getcInstructorName());
//     		}
//
//     		// TESTING: Printing the list of all students
//     		for (Student s : studentList) {
//     			System.out.println("Email: " + s.getsEmail() + " Name: " + s.getsName() + " Password: " + s.getsPass());
//     		}
//
//     		// TESTING: validateStudent()
//     		// OUTPUT: Successful
//     		boolean validate = sService.validateStudent("hluckham0@google.ru", "X1uZcoIh0dj");
//     		System.out.println("Validation for student email and password: " + validate);
//
//     		// TESTING: getStudentByEmail
//     		// OUTPUT: Successful
//     		Student testStudent = sService.getStudentByEmail("cjaulme9@bing.com");
//     		System.out.println("Email: " + testStudent.getsEmail() + " Name: " + testStudent.getsName() + " Password: "
//     				+ testStudent.getsPass());
//
//     		// TESTING: getStudentCourses(String sEmail)
//     		// OUTPUT: Successful
//     		List<Course> testStudentCourses = sService.getStudentCourses("cjaulme9@bing.com");
//
//     		if (!testStudentCourses.isEmpty()) {
//
//     			for (Course c : testStudentCourses) {
//     				System.out.println("CourseId: " + c.getcId() + " CourseName: " + c.getcName() + " Instructor Name: "
//     						+ c.getcInstructorName());
//     			}//for
//     		} else {
//     			System.out.println("Student has not registered to any course.");
//     		}//if-else
     //************************************************************************************************************************
	}

}
