package com.seminar;

/**
 * This class represents a student.
 * 
 * @author Luca Dotti
 *
 */
public class Student {
	//student name
	private final String name;
	//student surname
	private final String surname;
	
	/**
	 * Constructor that takes student's name and surname.
	 * 
	 * @param name
	 * @param surname
	 */
	public Student(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	/**
	 * Get student's info.
	 * 
	 * @return String
	 */
	public String getInfo() {
		return getFullName();
	}
	
	/**
	 * Get student's full name.
	 * 
	 * @return String
	 */
	private String getFullName() {
		return name + " " + surname;
	}
}
