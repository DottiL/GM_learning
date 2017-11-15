package com.app.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.app.models.Model;
import com.app.models.course.Course;

public class CourseDBHelper extends DBHelper {
	
	public CourseDBHelper(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	protected Course buildModel(ResultSet result) throws SQLException {
		return new Course(
				result.getInt(1),
				result.getString(2),
				result.getString(3),
				result.getString(4),
				result.getInt(5),
				result.getString(6));
	}
	
	@Override
	protected String buildSqlInsertStatement(Model model) {
		return "INSERT INTO Course (id, name, description, location, totalSeats, start) VALUES (" 
				+ "NULL, " 
				+ "\"" + model.getAttribute(Course.NAME) + "\"" + ", " 
				+ "\"" + (model.getAttribute(Course.DESCRIPTION).length() == 0 ? "\"\"" : model.getAttribute(Course.DESCRIPTION))  + "\"" + ", " 
				+ "\"" + model.getAttribute(Course.LOCATION) + "\"" + ", "
				+ "\"" + model.getAttribute(Course.TOTAL_SEATS) + "\"" + ", "
				+ "\"" + model.getAttribute(Course.STARTING_DATE) + "\"" +");";
	}
	
	@Override
	protected String buildSqlSelectStatement() {
		return "SELECT * FROM Course";
	}
	
	@Override
	protected String buildSqlSelectStatement(int id) {
		return "SELECT * FROM Course WHERE id=" + id;
	}
	
	@Override
	protected String buildSqlDeleteStatement(int id) {
		return "DELETE FROM Course WHERE id=" + id;  
	}
	
	@Override
	protected String buildSqlUpdateStatement(int id, Map<String, String> fields) {
		return "UPDATE Course SET " 
				+ "name=\"" + fields.get(Course.NAME) + "\", "
				+ "description=\"" + fields.get(Course.DESCRIPTION) + "\", "
				+ "location=\"" + fields.get(Course.LOCATION) + "\", "
				+ "totalSeats=\"" + fields.get(Course.TOTAL_SEATS) + "\", "
				+ "start=\"" + fields.get(Course.STARTING_DATE) + "\" "
				+ "WHERE id=" + id;
	}
}
