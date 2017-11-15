package com.app.view.student;

import com.app.models.Model;

public class StudentUpdateLayout extends StudentCreateLayout {
	private final String studentId;
	
	public StudentUpdateLayout(Model student, String studentId) {
		super(student);
		this.studentId = studentId;
	}
	
	@Override
	protected String getAction() {
		return "action -> /student/update/" + studentId;
	}
}
