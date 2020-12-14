package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArtistsDAO {
	
	Database object = new Database();
	Connection connection = object.connect();
	
	public List<Artist> getAllItems() {
		
		try {
			connection = object.connect();
			List<Artist> list = new ArrayList<Artist>();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Artist");
			ResultSet results = statement.executeQuery();
			// Loop the results
			while (results.next()) {
				int id = results.getInt("ArtistId");
				String name = results.getString("Name");
				Artist item = new Artist(id, name);
				list.add(item);
			}
			results.close();
			statement.close();
			connection.close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }

   /* @Override
    public ShoppingListItem getItem(String title) {
    	try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection(URL);
    
			statement = connection.prepareStatement("SELECT * FROM ShoppingListItem WHERE title = ?");
			statement.setString(1, title);
			results = statement.executeQuery();
			int id = results.getInt("id");
			ShoppingListItem item = new ShoppingListItem(id, title);
		
			results.close();
			statement.close();
			connection.close();
			return item;
    	} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }*/

    public boolean addItem(String newItem) {
    	try {
    		connection = object.connect();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO Artist (Name) VALUES (?)");
			statement.setString(1, newItem);
			statement.executeUpdate();
		
			statement.close();
			connection.close();
			return true;
    	} catch (Exception e) {
			throw new RuntimeException(e);
		}
    } 

}
