/**
 * This class represents a course.
 * 
 * @author Luca Dotti
 *
 */
public class Course {
	//course's name
	private String name;
	//course's number
	private String number;
	//course's description
	private String description;
	
	/**
	 * Constructor that takes the course's name, number and description.
	 * 
	 * @param name
	 * @param number
	 * @param description
	 */
	public Course(String name, String number, String description) {
		this.name = name;
		this.number = number;
		this.description = description;
	}
	
	/**
	 * Getter for course's name.
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter for course's number.
	 * 
	 * @return String
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Getter for course's description.
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description;
	}
}
