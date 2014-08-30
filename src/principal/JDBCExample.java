package principal;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 
public class JDBCExample {
 
	/*
	 	To connect to your database use these details
		Host: sql2.freemysqlhosting.net
		Database name: sql250894
		Database user: sql250894
		Database password: gU3*wG3!
		Port number: 3306	 
	 */
  public static void main(String[] argv) {
 
	System.out.println("-------- MySQL JDBC Connection Testing ------------");
 
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
		return;
	}
 
	System.out.println("MySQL JDBC Driver Registered!");
	Connection connection = null;
 
	try {
		connection = DriverManager.getConnection("jdbc:mysql://sql2.freemysqlhosting.net:3306","sql250894", "gU3*wG3!");
 
	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}
 
	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
  }
}
