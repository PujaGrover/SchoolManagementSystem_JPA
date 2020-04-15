package jpa.entitymodels;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
	/**
	 * Primary Key
	 */
	@Id
	@Column(name = "email")
	private String sEmail;
	
	@Basic
	@Column(name = "name", nullable=false, length=50)
	private String sName;
	
	@Basic
	@Column(name= "password", nullable=false, length=50)
	private String sPass;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_course", joinColumns = { @JoinColumn(name = "email") }, inverseJoinColumns = { @JoinColumn (name = "id") })
	private List<Course> sCourses;
	
	

	//Constructors
	/**
	 * First constructor takes no parameters and it initializes every members to
	 *  an initial value
	 */
	public Student() {}



	/**
	 * @param sEmail
	 * @param sName
	 * @param sPass
	 * @param sCourses
	 * Second constructor must initialize every private member with a parameter provided 
	 * to the constructor.
	 */
	public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
	
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourses = sCourses;
	}
	
	//EXTRA CONSTRUCTOR WITHOUT LIST<COURSE> FOR JUNIT TEST TO TEST getStudentByEmailTest() METHOD
	public Student(String sEmail, String sName, String sPass) {
		
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
	}


	//Getters/Setters
	public String getsEmail() {
		return sEmail;
	}



	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}



	public String getsName() {
		return sName;
	}



	public void setsName(String sName) {
		this.sName = sName;
	}



	public String getsPass() {
		return sPass;
	}



	public void setsPass(String sPass) {
		this.sPass = sPass;
	}



	public List<Course> getsCourses() {
		return sCourses;
	}



	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}
	
	

}
