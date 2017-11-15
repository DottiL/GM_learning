package com.app.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.app.models.Model;
import com.app.models.student.Student;

public class StudentDBHelper extends DBHelper {

	public StudentDBHelper(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	protected Model buildModel(ResultSet result) throws SQLException {
		return new Student(
				result.getInt(1),
				result.getString(2),
				result.getString(3));
	}

	@Override
	protected String buildSqlSelectStatement() {
		return "SELECT * FROM Student";
	}

	@Override
	protected String buildSqlSelectStatement(int id) {
		return "SELECT * FROM Student WHERE id=" + id;
	}

	@Override
	protected String buildSqlInsertStatement(Model model) {
		return "INSERT INTO Student (id, name, surname) values (" 
				+ "NULL, " 
				+ "\"" + model.getAttribute(Student.NAME) + "\"" + ", " 
				+ "\"" + model.getAttribute(Student.SURNAME) + "\"" + ")";
	}

	@Override
	protected String buildSqlDeleteStatement(int id) {
		return "DELETE FROM Student WHERE id=" + id;
	}

	@Override
	protected String buildSqlUpdateStatement(int id, Map<String, String> fields) {
		return "UPDATE Student SET " 
				+ "name=\"" + fields.get(Student.NAME) + "\", "
				+ "surname=\"" + fields.get(Student.SURNAME) + "\" "
				+ "WHERE id=" + id;
	}

}
