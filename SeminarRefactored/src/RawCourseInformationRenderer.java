import java.util.List;
import java.util.Map;

public class RawCourseInformationRenderer extends CourseInformationRenderer {
	
	public RawCourseInformationRenderer(Map<String, String> courseInfo, List<String> students) {
		super(courseInfo, students);
	}

	@Override
	public String renderCourseInformation() {
		String result = "";
		
		result += "Course info:\n";
		
		result += courseInfo.get("number") + "\n";
		result += courseInfo.get("name") + "\n";
		result += courseInfo.get("description") + "\n";
		result += courseInfo.get("location") + "\n";
		result += courseInfo.get("seatsLeft") + "\n";
		
		return result;
	}

	@Override
	public String renderStudentsInformation() {
		String result = "";
		
		result += "Students:\n";
		
		for(String s: students) {
			result += "\t" + s + "\n";
		}
		
		return result.substring(0, result.length()-1);
	}

}
