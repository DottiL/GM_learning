package com.app.controller.course;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.Servlet;
import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.view.course.CreateLayout;
import com.seminar.Course;

public class CreateController implements Controller {
	public final static String POST_METHOD = "POST";
	public final static String ROUTE = "/course/create";
	
	@Override
	public boolean handles(String route) {
		return CreateController.ROUTE.equals(route);
	}

	@Override
	public void execute(Context context) throws Exception {
		context.response().setContentType("text/html");
		context.response().setCharacterEncoding("UTF-8");
		
		Course course = new Course();
		if(isPostRequest(context.request())) {
			course.setAttributes(extractFields(context.request()));
			
			if(!course.hasErrors()) {
				Servlet.courses.add(course);
				context.response().sendRedirect(AdminController.ROUTE);
			} else {
				context.response().getWriter().write(new CreateLayout(course).build().render());
			}
		} else {
			context.response().getWriter().write(new CreateLayout(course).build().render());
		}
	}
	
	private Map<String, String> extractFields(HttpServletRequest request) {
		Map<String, String> fields = new HashMap<>();
		fields.put(Course.NAME, request.getParameter(Course.NAME));
		fields.put(Course.STARTING_DATE, request.getParameter(Course.STARTING_DATE));
		fields.put(Course.LOCATION, request.getParameter(Course.LOCATION));
		fields.put(Course.TOTAL_SEATS, request.getParameter(Course.TOTAL_SEATS));
		fields.put(Course.DESCRIPTION, request.getParameter(Course.DESCRIPTION));
		
		return fields;
		
	}
	
	private boolean isPostRequest(HttpServletRequest request) {
		return request.getMethod().equals(POST_METHOD);
	}

}
