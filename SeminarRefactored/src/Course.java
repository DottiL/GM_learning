import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	//course's location
	private String location;
	//course's seats left
	private int seatsLeft;
	//course's enrollments
	private List<Enrollment> enrollments;
	
	/**
	 * Constructor that takes the course's name, number, description, location and seatsLeft.
	 * 
	 * @param name
	 * @param number
	 * @param description
	 */
	public Course(String name, String number, String description, String location, int seatsLeft) {
		this.name = name;
		this.number = number;
		this.description = description;
		this.location = location;
		this.seatsLeft = seatsLeft;
	}
	
	/**
	 * Constructor that takes a map containing the course's info.
	 * 
	 * @param name
	 * @param number
	 * @param description
	 */
	public Course(Map<String, String> info) {
		this.name = info.get("name");
		this.number = info.get("number");
		this.description = info.get("description");
		this.location = info.get("location");
		this.seatsLeft = Integer.parseInt(info.get("seatsLeft"));
	}
	
	
	/**
	 * Getter for course's name.
	 * 
	 * @return String
	 */
	public String getCourseName() {
		return name + "_" + number;
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
}
