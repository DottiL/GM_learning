package com.seminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import validators.RuleValidator;
import validators.rules.DateFormatValidationRule;
import validators.rules.MaxLengthValidationRule;
import validators.rules.NotEmptyValidationRule;
import validators.rules.NumberUpperboundValidationRule;
import validators.rules.NumericValidationRule;
import validators.rules.PositiveNumberValidationRule;

/**
 * This class represents a course.
 * 
 * @author Luca Dotti
 *
 */
public class Course {
	public final static String NAME = "name";
	public final static String ID = "id";
	public final static String DESCRIPTION = "description";
	public final static String LOCATION = "location";
	public final static String SEATS_LEFT = "seatsleft";
	public final static String STARTING_DATE = "startingdate";
	public final static String TOTAL_SEATS = "totalseats";
	
	//course's name
	private String name;
	//course's number
	private int id;
	//course's description
	private String description;
	//course's location
	private String location;
	//course's seats left
	private int seatsLeft;
	//starting date
	private String startingDate;
	//total seats
	private int totalSeats;
	//course's enrollments
	private List<Enrollment> enrollments;
	
	private Map<String, RuleValidator> validators;
	
	private boolean hasErrors;
	private boolean isNew;
	
	/**
	 * Constructor that takes the course's name, number, description, location and seatsLeft.
	 * 
	 * @param name
	 * @param number
	 * @param description
	 */
	public Course(String name, String number, String description, String location, int seatsLeft, String startingDate) {
		this.name = name;
		this.id = Integer.parseInt(number);
		this.description = description;
		this.location = location;
		this.seatsLeft = seatsLeft;
		this.startingDate = startingDate;
		this.enrollments = new ArrayList<>();
	}
	
	public Course() {
		defineValidators();
		
		hasErrors = false;
		this.enrollments = new ArrayList<>();
		this.isNew = true;
		totalSeats = -1;
		id = -1;
	}
	
	private void defineValidators() {
		validators = new HashMap<>();
		
		RuleValidator nameValidator = new RuleValidator();
		nameValidator.forField(Course.NAME);
		nameValidator.addRule(new NotEmptyValidationRule());
		nameValidator.addRule(new MaxLengthValidationRule(15));
		validators.put(Course.NAME, nameValidator);
		
		RuleValidator startValidator = new RuleValidator();
		startValidator.forField(Course.STARTING_DATE);
		startValidator.addRule(new NotEmptyValidationRule());
		startValidator.addRule(new DateFormatValidationRule("dd.mm.yyyy", "([0-9]{2})\\.([0-9]{2})\\.([0-9]{4})"));
		validators.put(Course.STARTING_DATE, startValidator);
		
		RuleValidator locationValidator = new RuleValidator();
		locationValidator.forField(Course.LOCATION);
		locationValidator.addRule(new NotEmptyValidationRule());
		locationValidator.addRule(new MaxLengthValidationRule(20));
		validators.put(Course.LOCATION, locationValidator);
		
		RuleValidator totalSeatsValidator = new RuleValidator();
		totalSeatsValidator.forField(Course.TOTAL_SEATS);
		totalSeatsValidator.addRule(new NotEmptyValidationRule());
		totalSeatsValidator.addRule(new NumericValidationRule());
		totalSeatsValidator.addRule(new NumberUpperboundValidationRule(100));
		totalSeatsValidator.addRule(new PositiveNumberValidationRule());
		totalSeatsValidator.addRule(new MaxLengthValidationRule(3));
		validators.put(Course.TOTAL_SEATS, totalSeatsValidator);
		
		RuleValidator idValidator = new RuleValidator();
		idValidator.forField(Course.ID);
		validators.put(Course.ID, idValidator);
		
		RuleValidator descriptionValidator = new RuleValidator();
		descriptionValidator.forField(Course.DESCRIPTION);
		validators.put(Course.DESCRIPTION, descriptionValidator);
	}
	
	private void setAttribute(String field, String fieldValue) {
		switch (field) {
			case Course.NAME:
				name = fieldValue;
				break;
			case Course.ID:
				id = Integer.parseInt(fieldValue);
				break;
			case Course.DESCRIPTION:
				description = fieldValue;
				break;
			case Course.LOCATION:
				location = fieldValue;
				break;
			case Course.SEATS_LEFT:
				seatsLeft = Integer.parseInt(fieldValue);
				break;
			case Course.STARTING_DATE:
				startingDate = fieldValue;
				break;
			case Course.TOTAL_SEATS:
				totalSeats = Integer.parseInt(fieldValue);
				break;
			default:
				break;
		}
	}
	
	public void setAttributes(Map<String, String> fields) {
		isNew = false;
		
		String field;
		String fieldValue;
		RuleValidator currentValidator;
		
		for(Map.Entry<String, String> entry: fields.entrySet()) {
			field = entry.getKey();
			fieldValue = entry.getValue();
			currentValidator = validators.get(field);
			currentValidator.withValue(fieldValue).applyRules();
			
			if(!currentValidator.hasErrors()) {
				setAttribute(field, fieldValue);
			} else {
				hasErrors = hasErrors || currentValidator.hasErrors();
			}
		}
	}
	
	public boolean isNew() {
		return isNew;
	}
	
	public boolean fieldHasError(String field) {
		return validators.get(field).hasErrors();
	}
	
	public List<String> getErrorsForField(String field) {
		return validators.get(field).getErrors();
	}
	
	public boolean hasErrors() {
		return hasErrors;
	}
	
	public String getAttribute(String field) {
		switch (field) {
			case Course.NAME:
				return name == null ? "" : name;
			case Course.ID:
				return id < 0 ? "" : Integer.toString(id); 
			case Course.DESCRIPTION:
				return description == null ? "" : description;
			case Course.LOCATION:
				return location == null ? "" : location;
			case Course.SEATS_LEFT:
				return seatsLeft < 0 ? "" : Integer.toString(seatsLeft);
			case Course.STARTING_DATE:
				return startingDate == null ? "" : startingDate;
			case Course.TOTAL_SEATS:
				return totalSeats < 0 ? "" : Integer.toString(totalSeats);
			default:
				return "";
		}
	}
	
	/**
	 * Getter for course's name.
	 * 
	 * @return String
	 */
	public String getCourseName() {
		return name + "_" + id;
	}
	
	/**
	 * Getter for course's description.
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Getter for the course's location.
	 * 
	 * @return String
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Getter for the course's seats left.
	 * 
	 * @return int
	 */
	public int getSeatsLeft() {
		return seatsLeft;
	}
	
	public int getId() {
		return id;
	}
	
	public int getTotalSeats() {
		return totalSeats;
	}
	
	public String getStartingDate() {
		return startingDate;
	}
	
	/**
	 * Getter for the course's student list.
	 * 
	 * @return List<String>
	 */
	public List<String> getStudentList() {
		List<String> studentList = new ArrayList<>();
		
		for(Enrollment e: enrollments) {
			studentList.add(e.getInfo());
		}
		
		return studentList;
	}
	
	public void addStudent(Student student) {
		if(seatsLeft > 0) {
			enrollments.add(new Enrollment(student));
			seatsLeft--;
		}
	}
	
	public String renderCsv() {
		return new CsvCourseInformationRenderer().renderInformation(this);
	}
	
	public String renderHtml() {
		return new HtmlCourseInformationRenderer().renderInformation(this);
	}
	
	public String renderRaw() {
		return new RawCourseInformationRenderer().renderInformation(this);
	}
}
