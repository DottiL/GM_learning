package com.seminar;

/**
 * This class represents an enrollment.
 * 
 * @author Luca Dotti
 *
 */
public class Enrollment {
	//the student corresponding to this enrollment
	private final Student student;
	
	/**
	 * Constructor that takes the student of that enrollment.
	 * 
	 * @param student
	 */
	public Enrollment(Student student) {
		this.student = student;
	}
	
	/**
	 * Get the info of this enrollment.
	 * 
	 * @return String
	 */
	public String getInfo() {
		return student.getInfo();
	}
}
