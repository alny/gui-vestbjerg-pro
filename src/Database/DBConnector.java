package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/vestbjergdb?autoReconnect=true&useSSL=false";
	private static final String username = "root";
	private static final String pw = "toor";

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement stmt = null;
		try {
			// Register JDBC driver
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println(e);
		}
		// Open a connection
		connection = DriverManager.getConnection(URL, username, pw);
		System.out.println("Connected to DB " + connection);
//		stmt = connection.createStatement();
//
//		String sql = "CREATE TABLE CUSTOMER " + 
//					 "(id INTEGER not NULL, " + 
//					 "name VARCHAR(255), " + 
//					 "address VARCHAR(255), " + 
//					 "zip VARCHAR(255), " + 
//					 "city VARCHAR(255), " + 
//					 "phone VARCHAR(255), " +
//				     "type VARCHAR(255), " +
//					 "PRIMARY KEY ( id ))";
//
//		stmt.executeUpdate(sql);
//		System.out.println("Created table in given database...");

	}

	public Connection createConnection() throws SQLException {

		Connection connection = DriverManager.getConnection(URL, username, pw);

		if (connection == null) {
			throw new SQLException("Could not connect to database");
		}

		return connection;
	}
}
