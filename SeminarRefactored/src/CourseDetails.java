import java.util.Map;

/**
 * This class represents the seminar details.
 * 
 * @author Luca Dotti
 *
 */
public class CourseDetails {
	//the seminar
	private Course course;
	
	private void createCourse(Map<String, String> infoMap) {
		course = new Course(infoMap);
	}
	
	public void loadCourseInformationFromCsv(String info) {
		CourseInformationLoader loader = new CsvCourseInformationLoader();
		createCourse(loader.loadInformation(info));
	}
	
	public void loadCourseInformationFromHtml(String info) {
		CourseInformationLoader loader = new HtmlCourseInformationLoader();
		createCourse(loader.loadInformation(info));
	}

}
