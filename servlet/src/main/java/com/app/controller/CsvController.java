package com.app.controller;

import com.seminar.Course;
import com.seminar.Student;

public class CsvController implements Controller {

	@Override
	public boolean handles(String route) {
		return "/course/csv".equals(route);
	}

	@Override
	public void execute(Context context) throws Exception {
//		Course c = new Course("test", "1", "test", "Mendrisio", 50, "10.01.2017");
//		c.addStudent(new Student("a", "a"));
//		c.addStudent(new Student("b", "b"));
//		c.addStudent(new Student("c", "c"));
//		
//		context.response().setContentType("text/octet-stream");
//		context.response().setCharacterEncoding("UTF-8");
//		String headerKey = "Content-Disposition";
//        String headerValue = String.format("attachment; filename=\"%s\"",
//        c.getCourseName() + ".csv");
//        context.response().setHeader(headerKey, headerValue);
//		context.response().getOutputStream().write(c.renderCsv().getBytes());
//		context.response().getOutputStream().flush();
//		context.response().getOutputStream().close();
		context.response().sendError(404);
	}

}
