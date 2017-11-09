package com.seminar;

public abstract class CourseInformationRenderer {
	public String renderInformation(Course course) {
		return renderCourseInformation(course) + renderStudentsInformation(course);
	}
	
	public abstract String renderCourseInformation(Course course);
	public abstract String renderStudentsInformation(Course course);
}
