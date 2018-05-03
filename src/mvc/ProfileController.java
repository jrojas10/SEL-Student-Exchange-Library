package mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BookTable;
import models.Config;
import models.User;

@WebServlet("/Profile")
public class ProfileController extends HttpServlet {
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("authorizedUser");
		request.setAttribute("user", user);
		if (user == null ) {
			response.sendRedirect("Login");
			return;
		}
		java.sql.Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu49";

			Config cfg = new Config();
			// String url = cfg.getProperty("dbUrl");
			String username = cfg.getProperty("dbUserName");
			String password = cfg.getProperty("dbPassword");
			c = DriverManager.getConnection(url, username, password);
			
		ArrayList<BookTable> booksPosted = new ArrayList<BookTable> ();
		
		String sql2 = "select * from Posts join Books using(BookID) where UserID = ? ";
		PreparedStatement pstmt2 = c.prepareStatement(sql2);
		pstmt2.setInt(1, user.getId());
		ResultSet rs2 = pstmt2.executeQuery();
		while (rs2.next()) {
			BookTable posted = new BookTable (rs2.getInt("BookID"),rs2.getString("Title"),rs2.getString("Price"),rs2.getDate("PostDate"),rs2.getDate("ExperationDate"));
			booksPosted.add(posted);
		}
		request.setAttribute("bookInfo", booksPosted);
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
	//	getServletContext().setAttribute("posts", booksPosted);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Profile.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
