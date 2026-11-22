package week12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	static final String URL = "jdbc:mysql://127.0.0.1:3306/집현전";
	static final String USERNAME = "root";
	static final String PASSWORD = "Zxcvbn4657@";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);	
	}
}
