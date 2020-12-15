package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Artist;
import database.ArtistsDAO;

@WebServlet("/artists")
public class ArtistServlet extends HttpServlet {
		
		ArtistsDAO object = new ArtistsDAO();
		
		@Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	    		throws ServletException, IOException {
	    	
	    	List<Artist> artists = new ArrayList<Artist>();
	    	
	    	artists = object.getAllItems();

	        // pass to the JSP page as an attribute
	        req.setAttribute("artists", artists);

	        // forward the request to the index.jsp page
	        req.getRequestDispatcher("/WEB-INF/artists.jsp").forward(req, resp);
	    }
	  
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    	throws ServletException, IOException {
	    	String name =req.getParameter("Name");
	    	object.addItem(name);
	    	
	    	resp.sendRedirect("/artists");
	    }
}
