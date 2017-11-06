import java.util.ArrayList;
import java.util.HashMap;
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
	private final String name;
	//course's number
	private final String number;
	//course's description
	private final String description;
	//course's location
	private final String location;
	//course's seats left
	private final int seatsLeft;
	//starting date
	private String startingDate;
	//course's enrollments
	private List<Enrollment> enrollments;
	
	/**
	 * Constructor that takes the course's name, number, description, location and seatsLeft.
	 * 
	 * @param name
	 * @param number
	 * @param description
	 */
	public Course(String name, String number, String description, String location, int seatsLeft, String startingDate) {
		this.name = name;
		this.number = number;
		this.description = description;
		this.location = location;
		this.seatsLeft = seatsLeft;
		this.startingDate = startingDate;
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
	
	private Map<String, String> getCourseInfoMap() {
		Map<String, String> result = new HashMap<>();
		result.put("number", number);
		result.put("name", name);
		result.put("description", description);
		result.put("location", location);
		result.put("seatsLeft", Integer.toString(seatsLeft));
		result.put("startingDate", startingDate);
		
		return result;
	}
	
	public String renderCsv() {
		return new CsvCourseInformationRenderer(getCourseInfoMap(), getStudentList()).renderInformation();
	}
	
	public String renderHtml() {
		return new HtmlCourseInformationRenderer(getCourseInfoMap(), getStudentList()).renderInformation();
	}
	
	public String renderRaw() {
		return new RawCourseInformationRenderer(getCourseInfoMap(), getStudentList()).renderInformation();
	}
}
