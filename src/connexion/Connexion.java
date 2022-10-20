package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private static String url = "jdbc:mysql://localhost:3306/rappel";
	private static String username = "root";
	private static String password = "";
	private  Connection connection;
	private static Connexion instance;

	
	
	private Connexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Impossible de charger le driver");
		} catch (SQLException e) {
			System.out.println("Impossible d'établir la connexion : " + e.getMessage());
		}
	}



	public static Connexion getInstance() {
		if(instance == null)
			instance = new Connexion();
		return instance;
	}



	public Connection getConnection() {
		return connection;
	}



	

}
