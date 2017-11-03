import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a seminar.
 * 
 * @author Luca Dotti
 *
 */
public class Seminar {
	//the seminar's course
	private Course course;
	//the seminar's name
	private String seminarName;
	//the seminar's location
	private String location;
	//the seminar's seats left. This will be inc and dec when adding and removing new students.
	private int seatsLeft;
	//the seminar's enrollments
	private List<Enrollment> enrollments;
	
	/**
	 * Constructor that takes the seminar's course, location and maxSeats.
	 * 
	 * @param course
	 * @param location
	 * @param maxSeats
	 */
	public Seminar(Course course, String location, int maxSeats) {
		this.course = course;
		this.location = location;
		seatsLeft = maxSeats;
		
		seminarName = course.getName() + "_" + course.getNumber();
	}
	
	/**
	 * Getter for the seminar's name.
	 * 
	 * @return String
	 */
	public String getName() {
		return seminarName;
	}
	
	/**
	 * Getter for the seminar's description.
	 * 
	 * @return String
	 */
	public String getDescription() {
		return course.getDescription();
	}
	
	/**
	 * Getter for the seminar's location.
	 * 
	 * @return String
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Getter for the seminar's seats left.
	 * 
	 * @return int
	 */
	public int getSeatsLeft() {
		return seatsLeft;
	}
	
	/**
	 * Getter for the seminar's student list.
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
