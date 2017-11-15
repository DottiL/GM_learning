package com.app.models.course;

public class HtmlCourseInformationRenderer extends CourseInformationRenderer {

	@Override
	public String renderInformation(Course course) {
		String result = "";
		
		result += "<html>";
		result += "<head>";
		result += "<title>" + course.getCourseName() + "</title>";
		result += "</head>";
		result += "<body>";
		result += renderCourseInformation(course);
		result += renderStudentsInformation(course);
		result += "</body>";
		result += "</html>";
		
		return result;
	}
	
	@Override
	public String renderCourseInformation(Course course) {
		String result = "";
		
		result += "<div>" + course.getCourseName() + "</div>";
		result += "<ul>";
		
		result += "<li>" + course.getDescription() + "</li>";
		result += "<li>" + course.getLocation() + "</li>";
		result += "<li>" + course.getSeatsLeft() + "</li>";
		result += "<li>" + course.getStartingDate() + "</li>";
		
		result += "</ul>";
		
		return result;
	}

	@Override
	public String renderStudentsInformation(Course course) {
		String result = "";
		
		result += "<div>partecipanti:</div>";
		result += "<ul>";
		
		for(String s: course.getStudentList()) {
			result += "<li>" + s.split(" ")[0] + " " + s.split(" ")[1] + "</li>";
		}
		
		result += "</ul>";
		
		return result;
	}

}
