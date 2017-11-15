package com.app.models.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.app.models.Model;
import com.app.models.student.Student;
import com.app.validation.RuleValidator;
import com.app.validation.rules.DateFormatValidationRule;
import com.app.validation.rules.MaxLengthValidationRule;
import com.app.validation.rules.NotEmptyValidationRule;
import com.app.validation.rules.NumberUpperboundValidationRule;
import com.app.validation.rules.NumericValidationRule;
import com.app.validation.rules.PositiveNumberValidationRule;

/**
 * This class represents a course.
 * 
 * @author Luca Dotti
 *
 */
public class Course extends Model {
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
	private final List<Student> students;
	
	/**
	 * Constructor that takes the course's name, number, description, location and seatsLeft.
	 * 
	 * @param name
	 * @param number
	 * @param description
	 */
	public Course(int id, String name, String description, String location, int totalSeats, String startingDate) {
		this.name = name;
		this.id = id;
		this.description = description;
		this.location = location;
		this.totalSeats = totalSeats;
		this.startingDate = startingDate;
		this.students = new ArrayList<>();
		defineValidators();
		this.isNew = false;
		totalSeats = -1;
	}
	
	public Course() {
		defineValidators();
		
		hasErrors = false;
		this.students = new ArrayList<>();
		this.isNew = true;
		totalSeats = -1;
		id = -1;
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
		
		for(Student s: students) {
			studentList.add(s.getInfo());
		}
		
		return studentList;
	}
	
	@Override
	protected void defineValidators() {
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
	
	@Override
	public void setAttribute(String field, String fieldValue) {
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
	
	@Override
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
	
	public void addStudent(Student student) {
		if(seatsLeft > 0) {
			students.add(student);
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

	@Override
	public String toString() {
		return "Course [name=" + name + ", id=" + id + ", description=" + description + ", location=" + location
				+ ", seatsLeft=" + seatsLeft + ", startingDate=" + startingDate + ", totalSeats=" + totalSeats
				+ ", students=" + students + ", validators=" + validators + "]";
	}
}
