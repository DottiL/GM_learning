package com.app.models.student;

import java.util.HashMap;

import com.app.models.Model;
import com.app.validation.RuleValidator;
import com.app.validation.rules.MaxLengthValidationRule;
import com.app.validation.rules.NotEmptyValidationRule;

/**
 * This class represents a student.
 * 
 * @author Luca Dotti
 *
 */
public class Student extends Model {
	public final static String ID = "id";
	public final static String NAME = "name";
	public final static String SURNAME = "surname";
	
	private int id;
	//student name
	private String name;
	//student surname
	private String surname;
	
	/**
	 * Constructor that takes student's name and surname.
	 * 
	 * @param name
	 * @param surname
	 */
	public Student(int id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		defineValidators();
		hasErrors = false;
		isNew = false;
		id = -1;
	}
	
	public Student() {
		defineValidators();
		hasErrors = false;
		isNew = true;
		id = -1;
	}
	
	@Override
	protected void defineValidators() {
		validators = new HashMap<>();
		
		RuleValidator nameValidator = new RuleValidator();
		nameValidator.forField(Student.NAME);
		nameValidator.addRule(new NotEmptyValidationRule());
		nameValidator.addRule(new MaxLengthValidationRule(15));
		validators.put(Student.NAME, nameValidator);
		
		RuleValidator surnameValidator = new RuleValidator();
		surnameValidator.forField(Student.SURNAME);
		surnameValidator.addRule(new NotEmptyValidationRule());
		surnameValidator.addRule(new MaxLengthValidationRule(15));
		validators.put(Student.SURNAME, surnameValidator);
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

	@Override
	public void setAttribute(String field, String fieldValue) {
		switch (field) {
			case Student.ID:
				id = Integer.parseInt(fieldValue);
				break;
			case Student.NAME:
				name = fieldValue;
				break;
			case Student.SURNAME:
				surname = fieldValue;
				break;
			default:
				break;
		}
	}

	@Override
	public String getAttribute(String field) {
		switch (field) {
			case Student.ID:
				return id < 0 ? "" : Integer.toString(id);
			case Student.NAME:
				return name == null ? "" : name;
			case Student.SURNAME:
				return surname == null ? "" : surname; 
			default:
				return "";
		}
	}
}
