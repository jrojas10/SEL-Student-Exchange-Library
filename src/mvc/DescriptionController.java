package mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Book;
import models.Config;
import models.User;

/**
 * Servlet implementation class DescriptionController
 */
@WebServlet("/Description")
public class DescriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private String getCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies)
				if (cookie.getName().equals("user"))
					return cookie.getValue();

		return null;
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		User user = (User) request.getSession().getAttribute("authorizedUser");
		request.setAttribute("user", user);
		if(user == null) {
			response.sendRedirect("Login");
			return;
		}
		
		ArrayList<Book> books = (ArrayList<Book>) getServletContext().getAttribute("books");
		
		int i;
		int index = 0;
		int bookID = 0;
		for ( i = 0; i< books.size() ; i ++) {
			if (id == books.get(i).getId()) {
				index = i;
				bookID = books.get(i).getId();
				System.out.println(index);
			}
		}
		
		
		Connection c = null;
		try {
			Config cfg = new Config();
			
			//String url = cfg.getProperty("dbUrl");
			String username = cfg.getProperty("dbUserName");
			String password = cfg.getProperty("dbPassword");			
			
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu49";
			
			String sql = "SELECT DISTINCT *\n" + 
					"FROM Users\n" + 
					"JOIN Posts\n" + 
					"USING (UserID)\n" + 
					"JOIN Books\n" + 
					"USING (BookID)\n" + 
					"WHERE BOOKID = ?;";
			
			c = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = c.prepareStatement(sql);
			String string = "" + bookID;
			pstmt.setString(1, string);
			ResultSet rs = pstmt.executeQuery();
			User user = null;
			while (rs.next()) {
				 user = new User(rs.getInt("UserID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("EMail"), rs.getString("Password"), rs.getString("UserName"), rs.getString("Phone"));
			}
			request.setAttribute("userobject", user);
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
		
		
		request.getServletContext().setAttribute("id", index);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Description.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
