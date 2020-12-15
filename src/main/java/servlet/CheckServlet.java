package servlet;

import database.Database;
import java.sql.*;

public class CheckServlet {
	
	//This class only tests that the database connection works.
	
	public static void main(String[] args) {
		// LUODAAN DATABASE OLIO
		Database database = new Database();
		// KUTSUTAAN DATABASE OLION CONNECT-METODIA/FUNKTIO
		Connection connection = database.connect();
		
		try {
		//Luodaan kysely
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM Album");
		//Suoritetaan kysely ja otetaan tulokset talteen
		ResultSet results = statement.executeQuery();
		//loopataan tulokset niiden tulostamista varten
			while(results.next()) {
				System.out.println(results.getString("Title"));
			}
			//Suljetaan tietokantaresurssi
			results.close();
			statement.close();
			connection.close();
		} catch(Exception e) {
			System.out.println("Error");
		}
	}
}
