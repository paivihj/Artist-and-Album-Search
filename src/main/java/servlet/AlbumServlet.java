package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Album;
import database.AlbumsDAO;

@WebServlet("/albums")
public class AlbumServlet extends HttpServlet {
	
	AlbumsDAO object = new AlbumsDAO();
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
    	
    	List<Album> albums = new ArrayList<Album>();
    	
    	try {
    	int artist = Integer.parseInt(req.getParameter("ArtistId"));
    	albums = object.getItem(artist);
    	if (albums.size()==0) {
    		Album e = new Album(0, "No albums", artist);
    		albums.add(e);
    	}
    	} catch(Exception e) {
    		albums = object.getAllItems();
    	}  	

        // pass to the JSP page as an attribute
        req.setAttribute("albums", albums);

        // forward the request to the index.jsp page
        req.getRequestDispatcher("/WEB-INF/albums.jsp").forward(req, resp);
    }
  
}
