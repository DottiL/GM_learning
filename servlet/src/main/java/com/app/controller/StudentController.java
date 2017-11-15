package com.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.app.db.DBHelper;
import com.app.db.StudentDBHelper;
import com.app.models.Model;
import com.app.models.student.Student;
import com.app.view.student.StudentAdminLayout;
import com.app.view.student.StudentCreateLayout;
import com.app.view.student.StudentUpdateLayout;
import com.utils.Utils;

public class StudentController implements Controller {
	public final static String ADMIN_ROUTE = "/student";
	public final static String CREATE_ROUTE = "/student/create";
	public final static String VIEW_ROUTE = "/student/([0-9]*)+";
	public final static String DELETE_ROUTE = "/student/delete/([0-9]*)+";
	public final static String UPDATE_ROUTE = "/student/update/([0-9]*)+";
	
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
		dbHelper = new StudentDBHelper(context.connection());
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
		System.out.println("ADMIN Student");
		context.response().getWriter().write(new StudentAdminLayout(dbHelper.selectAll()).render());
	}
	
	private void actionCreate(Context context) throws SQLException, IOException {
		System.out.println("CREATING Student");
		Model student = new Student();
		
		if(Utils.isPostRequest(context)) {
			student.setAttributes(extractFieldsFromContext(context));
			
			if(!student.hasErrors()) {
				dbHelper.insert(student);
				context.response().sendRedirect(StudentController.ADMIN_ROUTE);
			} else {
				context.response().getWriter().write(new StudentCreateLayout(student).build().render());
			}
		} else {
			context.response().getWriter().write(new StudentCreateLayout(student).build().render());
		}
	}
	
	private void actionView(Context context) throws SQLException, IOException{
		System.out.println("VIEWING Student " + Utils.extractIdFromContext(context));
		Model student = dbHelper.select(Utils.extractIdFromContext(context));
		context.response().getWriter().write(new StudentUpdateLayout(student, student.getAttribute(Student.ID)).build().render());
	}
	
	private void actionDelete(Context context) throws SQLException, IOException{
		System.out.println("DELETING Student " + Utils.extractIdFromContext(context));
		dbHelper.delete(Utils.extractIdFromContext(context));
		context.response().sendRedirect(StudentController.ADMIN_ROUTE);
	}
	
	private void actionUpdate(Context context) throws SQLException, IOException{
		System.out.println("UPDATING Student " + Utils.extractIdFromContext(context));
		dbHelper.update(
				Utils.extractIdFromContext(context), 
				extractFieldsFromContext(context));
		context.response().sendRedirect(StudentController.ADMIN_ROUTE);
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
		fields.put(Student.NAME, context.request().getParameter(Student.NAME));
		fields.put(Student.SURNAME, context.request().getParameter(Student.SURNAME));
		
		return fields;
	}
}
