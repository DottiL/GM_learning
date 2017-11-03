import java.util.List;
import java.util.Map;

public class CsvCourseInformationRenderer extends CourseInformationRenderer {
	private String separator;
	private String delimiter;
	
	public CsvCourseInformationRenderer(Map<String, String> courseInfo, List<String> students) {
		super(courseInfo, students);
		separator = ";";
		delimiter = "\"";
	}
	
	@Override
	public String renderCourseInformation() {
		String result = "";
		
		result += delimiter + courseInfo.get("number") + delimiter + separator;
		result += delimiter + courseInfo.get("name") + delimiter + separator;
		result += delimiter + courseInfo.get("description") + delimiter + separator;
		result += delimiter + courseInfo.get("location") + delimiter + separator;
		result += delimiter + courseInfo.get("seatsLeft") + delimiter;
		
		result += "\n";
		
		return result;
	}

	@Override
	public String renderStudentsInformation() {
		String result = "";
		
		for(String s: students) {
			result += delimiter + s.split(" ")[0] + delimiter + separator + delimiter + s.split(" ")[1] + delimiter + "\n";
		}
		
		return result.substring(0, result.length()-1);
	}
	
	

}
