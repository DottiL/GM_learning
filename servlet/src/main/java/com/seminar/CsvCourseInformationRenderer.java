package com.seminar;

public class CsvCourseInformationRenderer extends CourseInformationRenderer {
	private final String separator;
	private final String delimiter;
	
	public CsvCourseInformationRenderer() {
		separator = ";";
		delimiter = "\"";
	}
	
	@Override
	public String renderCourseInformation(Course course) {
		String result = "";
		
		result += delimiter + course.getId() + delimiter + separator;
		result += delimiter + course.getCourseName() + delimiter + separator;
		result += delimiter + course.getDescription() + delimiter + separator;
		result += delimiter + course.getLocation() + delimiter + separator;
		result += delimiter + course.getSeatsLeft() + delimiter;
		result += delimiter + course.getStartingDate() + delimiter;
		
		result += "\n";
		
		return result;
	}

	@Override
	public String renderStudentsInformation(Course course) {
		String result = "";
		
		for(String s: course.getStudentList()) {
			result += delimiter + s.split(" ")[0] + delimiter + separator + delimiter + s.split(" ")[1] + delimiter + "\n";
		}
		
		return result.substring(0, result.length()-1);
	}
	
	

}
