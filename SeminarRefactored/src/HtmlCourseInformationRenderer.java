import java.util.List;
import java.util.Map;

public class HtmlCourseInformationRenderer extends CourseInformationRenderer {

	public HtmlCourseInformationRenderer(Map<String, String> courseInfo, List<String> students) {
		super(courseInfo, students);
	}

	@Override
	public String renderInformation() {
		String result = "";
		
		result += "<html>";
		result += "<head>";
		result += "<title>" + courseInfo.get("name") + "</title>";
		result += "</head>";
		result += "<body>";
		result += renderCourseInformation();
		result += renderStudentsInformation();
		result += "</body>";
		result += "</html>";
		
		return result;
	}
	
	@Override
	public String renderCourseInformation() {
		String result = "";
		
		result += "<div>" + courseInfo.get("name") + "</div>";
		result += "<ul>";
		
		result += "<li>" + courseInfo.get("description") + "</li>";
		result += "<li>" + courseInfo.get("location") + "</li>";
		result += "<li>" + courseInfo.get("seatsLeft") + "</li>";
		result += "<li>" + courseInfo.get("startingDate") + "</li>";
		
		result += "</ul>";
		
		return result;
	}

	@Override
	public String renderStudentsInformation() {
		String result = "";
		
		result += "<div>partecipanti:</div>";
		result += "<ul>";
		
		for(String s: students) {
			result += "<li>" + s.split(" ")[0] + " " + s.split(" ")[1] + "</li>";
		}
		
		result += "</ul>";
		
		return result;
	}

}
