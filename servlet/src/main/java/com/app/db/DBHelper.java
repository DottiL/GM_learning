package com.app.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.app.models.Model;

public abstract class DBHelper {
	protected Connection connection;
	
	public void insert(Model model) throws SQLException {
		connection.createStatement().execute(buildSqlInsertStatement(model));
	}

	public void delete(int id) throws SQLException {
		connection.createStatement().execute(buildSqlDeleteStatement(id));
	}

	public void update(int id, Map<String, String> fields) throws SQLException {
		connection.createStatement().execute(buildSqlUpdateStatement(id, fields));
	}

	public Model select(int id) throws SQLException {
		ResultSet result = connection.createStatement().executeQuery(buildSqlSelectStatement(id));
		result.next();
		return buildModel(result);
	}

	public List<Model> selectAll() throws SQLException {
		List<Model> models = new ArrayList<>();
		
		ResultSet result = connection.createStatement().executeQuery(buildSqlSelectStatement());
		
		while(result.next()) {
			models.add(buildModel(result));
		}
		
		return models;
	}
	
	protected abstract Model buildModel(ResultSet result) throws SQLException;
	protected abstract String buildSqlSelectStatement();
	protected abstract String buildSqlSelectStatement(int id);
	protected abstract String buildSqlInsertStatement(Model model);
	protected abstract String buildSqlDeleteStatement(int id);
	protected abstract String buildSqlUpdateStatement(int id, Map<String, String> fields);
}
