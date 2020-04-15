package jpa.entitymodels;

import javax.persistence.*;


@Entity
@Table(name = "course")
public class Course {
	
	/**
	 * Primary Key
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cId;
	
	@Basic
	@Column(name = "name", nullable=false, length=50)
	private String cName;
	
	@Basic
	@Column(name = "Instructor", nullable=false, length=50)
	private String cInstructorName;
	
	
	//Constructors
	
	/**
	 * First constructor takes no parameters and it initializes every members to
	 *  an initial value
	 */
	public Course() {}
	
	/**
	 * @param cId
	 * @param cName
	 * @param cInstructorName
	 * Second constructor must initialize every private member with a parameter provided 
	 * to the constructor.
	 */
	public Course(int cId, String cName, String cInstructorName) {
	
		this.cId = cId;
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}



	//Getters/Setters
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcInstructorName() {
		return cInstructorName;
	}
	public void setcInstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
	}
	
	

}
