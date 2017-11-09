package com.seminar;

public class RawCourseInformationRenderer extends CourseInformationRenderer {

	@Override
	public String renderCourseInformation(Course course) {
		String result = "";
		
		result += "Course[";
		
		result += "number: " + course.getId() + ", ";
		result += "name: " + course.getCourseName() + ", ";
		result += "description: " + course.getDescription() + ", ";
		result += "location: " + course.getLocation() + ", ";
		result += "seatsLeft: " + course.getSeatsLeft() + ", ";
		result += "startingDate: " + course.getStartingDate() + ", ";
		
		return result;
	}

	@Override
	public String renderStudentsInformation(Course course) {
		String result = "";
		
		result += "Students: ";
		
		for(String s: course.getStudentList()) {
			result += s + ", ";
		}
		
		result += "]";
		
		return result;
	}

}
