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
import database.Artist;
import database.ArtistsDAO;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	
	ArtistsDAO object1 = new ArtistsDAO();
	AlbumsDAO object2 = new AlbumsDAO();
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
	
	List<Album> albums = new ArrayList<Album>();
	List<Artist> artists = new ArrayList<Artist>();
	
	String search = req.getParameter("Name");
	albums = object2.searchItem(search);
	
	artists = object1.searchItem(search);

    // pass to the JSP page as an attribute
    req.setAttribute("albums", albums);
    req.setAttribute("artists", artists);

    // forward the request to the index.jsp page
    req.getRequestDispatcher("/WEB-INF/search.jsp").forward(req, resp);
	}
}
