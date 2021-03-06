package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlbumsDAO {
	
	Database object = new Database();
	Connection connection = object.connect();
	
	public List<Album> getAllItems() {
		
		try {
			connection = object.connect();
			List<Album> list = new ArrayList<Album>();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Album");
			ResultSet results = statement.executeQuery();
			// Loop the results
			while (results.next()) {
				int id = results.getInt("AlbumId");
				String name = results.getString("Title");
				int artist = results.getInt("ArtistId");
				Album item = new Album(id, name, artist);
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

    public List<Album> getItem(int artist) {
    	try {
    		connection = object.connect();
    		List<Album> list = new ArrayList<Album>();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Album WHERE ArtistId = ?");
			statement.setInt(1, artist);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				int id = results.getInt("AlbumId");
				String name = results.getString("Title");
				Album item = new Album(id, name, artist);
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

    public List<Album> searchItem(String x) {
    	try {
    		connection = object.connect();
    		List<Album> list = new ArrayList<Album>();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Album WHERE Title LIKE ?");
			statement.setString(1, "%" + x + "%");
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				int id = results.getInt("AlbumId");
				String name = results.getString("Title");
				int artistId = results.getInt("ArtistId");
				Album item = new Album(id, name, artistId);
				list.add(item);
			}
			statement.close();
			connection.close();
			return list;
    	} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }  

}
