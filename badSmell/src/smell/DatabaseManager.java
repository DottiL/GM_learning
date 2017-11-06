package smell;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	private String databaseUrl;
	private String userName;
	private String password;
	
	public DatabaseManager(String databaseUrl, String userName, String password) {
		this.databaseUrl = databaseUrl;
		this.userName = userName;
		this.password = password;
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(databaseUrl, userName, password);
	}
	
	public void executeUpdate(String sql) throws SQLException {
		Connection connection = getConnection();
		connection.prepareStatement(sql).executeUpdate();
		connection.close();
	}
}
