package principal;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class BD {

	public static final String URL = "sql2.freemysqlhosting.net";
	public static final String PORTA = "3306";
	public static final String USUARIO = "sql250894";
	public static final String NOME_BD = "sql250894";
	public static final String SENHA = "gU3*wG3!";

	/*
	 * To connect to your database use these details Host: sql2.freemysqlhosting.net Database name: sql250894 Database user:
	 * sql250894 Database password: gU3*wG3! Port number: 3306
	 */

	@Deprecated
	public static Connection conectar() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return null;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection conexao = null;

		try {
			conexao = DriverManager.getConnection("jdbc:mysql://" + URL + ":" + PORTA, NOME_BD, SENHA);

		}
		catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}

		if (conexao != null) {
			System.out.println("Success!");
			return conexao;
		}
		else {
			System.out.println("Failed to make connection!");
			return null;
		}

	}
}
