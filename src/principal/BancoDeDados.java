package principal;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class BancoDeDados {

	/*
	 * To connect to your database use these details 
	 * Host: sql2.freemysqlhosting.net 
	 * Database name: sql250894 
	 * Database user: sql250894 
	 * Database password: gU3*wG3! 
	 * Port number: 3306
	 */

	private static Connection conexao;
	
	public static void conectar() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		conexao = null;

		try {
			conexao = DriverManager.getConnection("jdbc:mysql://sql2.freemysqlhosting.net:3306", "sql250894", "gU3*wG3!");

		}
		catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (conexao != null) {
			System.out.println("Success!");
		}
		else {
			System.out.println("Failed to make connection!");
		}

	}
	
	public static Connection getConexao(){
		return conexao;
	}
}
