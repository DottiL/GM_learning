import java.util.List;
import java.util.Map;

public abstract class CourseInformationRenderer {
	protected Map<String, String> courseInfo;
	protected List<String> students;
	
	public String renderInformation() {
		return renderCourseInformation() + renderStudentsInformation();
	}
	
	public abstract String renderCourseInformation();
	public abstract String renderStudentsInformation();
	
	public CourseInformationRenderer(Map<String, String> courseInfo, List<String> students) {
		this.courseInfo = courseInfo;
		this.students = students;
	}
}
