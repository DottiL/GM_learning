package com.app.view.course;

import com.app.models.Model;

public class CourseUpdateLayout extends CourseCreateLayout {
	private final String courseId;
	
	public CourseUpdateLayout(Model course, String courseId) {
		super(course);
		this.courseId = courseId;
	}
	
	@Override
	protected String getAction() {
		return "action -> /course/update/" + courseId;
	}
}
