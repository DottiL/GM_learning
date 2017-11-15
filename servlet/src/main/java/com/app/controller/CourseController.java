package com.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.app.db.CourseDBHelper;
import com.app.db.DBHelper;
import com.app.models.Model;
import com.app.models.course.Course;
import com.app.view.course.CourseAdminLayout;
import com.app.view.course.CourseCreateLayout;
import com.app.view.course.CourseUpdateLayout;
import com.utils.Utils;

public class CourseController implements Controller {
	public final static String ADMIN_ROUTE = "/course";
	public final static String CREATE_ROUTE = "/course/create";
	public final static String VIEW_ROUTE = "/course/([0-9]*)+";
	public final static String DELETE_ROUTE = "/course/delete/([0-9]*)+";
	public final static String UPDATE_ROUTE = "/course/update/([0-9]*)+";
	
	private DBHelper dbHelper;

	@Override
	public boolean handles(String route) {
		return isAdminRoute(route)
				|| isCreateRoute(route)
				|| isViewRoute(route)
				|| isDeleteRoute(route)
				|| isUpdateRoute(route);
	}

	@Override
	public void execute(Context context) throws Exception {
		dbHelper = new CourseDBHelper(context.connection());
		context.response().setContentType("text/html");
		context.response().setCharacterEncoding("UTF-8");
		
		invokeAction(context);
	}
	
	private void invokeAction(Context context) throws IOException, SQLException {
		if(isAdminRoute(context.request().getRequestURI())) {
			actionAdmin(context);
		} else if(isCreateRoute(context.request().getRequestURI())) {
			actionCreate(context);
		} else if(isViewRoute(context.request().getRequestURI())) {
			actionView(context);
		} else if(isDeleteRoute(context.request().getRequestURI())) {
			actionDelete(context);
		} else if(isUpdateRoute(context.request().getRequestURI())) {
			actionUpdate(context);
		} else {
			sendNotFoundError(context);
		}
	}
	
	private void actionAdmin(Context context) throws IOException, SQLException {
		System.out.println("ADMIN Course");
		context.response().getWriter().write(new CourseAdminLayout(dbHelper.selectAll()).render());
	}
	
	private void actionCreate(Context context) throws SQLException, IOException {
		System.out.println("CREATING Course");
		Model course = new Course();
		
		if(Utils.isPostRequest(context)) {
			course.setAttributes(extractFieldsFromContext(context));
			
			if(!course.hasErrors()) {
				dbHelper.insert(course);
				context.response().sendRedirect(CourseController.ADMIN_ROUTE);
			} else {
				context.response().getWriter().write(new CourseCreateLayout(course).build().render());
			}
		} else {
			context.response().getWriter().write(new CourseCreateLayout(course).build().render());
		}
	}
	
	private void actionView(Context context) throws SQLException, IOException{
		System.out.println("VIEWING Course " + Utils.extractIdFromContext(context));
		Model course = dbHelper.select(Utils.extractIdFromContext(context));
		context.response().getWriter().write(new CourseUpdateLayout(course, course.getAttribute(Course.ID)).build().render());
	}
	
	private void actionDelete(Context context) throws SQLException, IOException{
		System.out.println("DELETING Course " + Utils.extractIdFromContext(context));
		dbHelper.delete(Utils.extractIdFromContext(context));
		context.response().sendRedirect(CourseController.ADMIN_ROUTE);
	}
	
	private void actionUpdate(Context context) throws SQLException, IOException{
		System.out.println("UPDATING Course " + Utils.extractIdFromContext(context));
		dbHelper.update(
				Utils.extractIdFromContext(context), 
				extractFieldsFromContext(context));
		context.response().sendRedirect(CourseController.ADMIN_ROUTE);
	}
	
	private boolean isAdminRoute(String route) {
		return route.matches(ADMIN_ROUTE);
	}
	
	private boolean isCreateRoute(String route) {
		return route.matches(CREATE_ROUTE);
	}
	
	private boolean isViewRoute(String route) {
		return route.matches(VIEW_ROUTE);
	}
	
	private boolean isDeleteRoute(String route) {
		return route.matches(DELETE_ROUTE);
	}
	
	private boolean isUpdateRoute(String route) {
		return route.matches(UPDATE_ROUTE);
	}
	
	private void sendNotFoundError(Context context) throws IOException {
		context.response().sendError(HttpServletResponse.SC_NOT_FOUND);
	}
	
	private Map<String, String> extractFieldsFromContext(Context context) {
		Map<String, String> fields = new HashMap<>();
		fields.put(Course.NAME, context.request().getParameter(Course.NAME));
		fields.put(Course.STARTING_DATE, context.request().getParameter(Course.STARTING_DATE));
		fields.put(Course.LOCATION, context.request().getParameter(Course.LOCATION));
		fields.put(Course.TOTAL_SEATS, context.request().getParameter(Course.TOTAL_SEATS));
		fields.put(Course.DESCRIPTION, context.request().getParameter(Course.DESCRIPTION));
		
		return fields;
	}
}
