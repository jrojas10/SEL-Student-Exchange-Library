package mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

import models.Book;
import models.Config;

/**
 * Servlet implementation class BookSearchController
 */
@WebServlet("/Search")
public class BookSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
    	
		ArrayList<Book> books = new ArrayList<Book>();
		java.sql.Connection c = null;
		try {
			Config cfg = new Config();
			String username = cfg.getProperty("dbUserName");
			String password = cfg.getProperty("dbPassword");
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu49";
			c = DriverManager.getConnection(url, username, password);
			java.sql.Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Books");
			while (rs.next()) {
				Book book = new Book(rs.getInt("BookID"), rs.getDouble("Price"), rs.getString("Title"),
						rs.getString("ISBN"), rs.getString("AuthorFirst"), rs.getString("AuthorLast"),
						rs.getString("SUBJECT"),rs.getString("Class"),rs.getString("State"));
				books.add(book);
			}
			getServletContext().setAttribute("books", books);
		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}
    	
    }
  
    public BookSearchController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Search.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("query");
		
		ArrayList<Book> books = (ArrayList<Book>) getServletContext().getAttribute("books");
		
		
		ArrayList<Book> results = new ArrayList<Book>();
		for (Book book : books) {
			
			if (query == null || query.equals("") || query.equalsIgnoreCase(book.getTitle()) || query.equalsIgnoreCase(book.getIsbn()) ||
					query.equalsIgnoreCase(book.getAuthorFirst()) || query.equalsIgnoreCase(book.getAuthorLast()) || query.equalsIgnoreCase(book.getState()) || query.equalsIgnoreCase(book.getSubject()) ||
					query.equalsIgnoreCase(book.getCourse()) || book.getTitle().toLowerCase().contains(query.toLowerCase()) || book.getAuthorFirst().toLowerCase().contains(query.toLowerCase()) || 
					book.getAuthorFirst().toLowerCase().contains(query.toLowerCase())){
				System.out.println("match: " + book.getTitle());
				
				results.add(book);
			}
		}
		
		
		
	//	books = results;
		request.setAttribute("results", results);
		//request.setAttribute("results", results);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Search.jsp");
		dispatcher.forward(request, response);

}
}
