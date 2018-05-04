package mvc;

import java.io.IOException;
import java.sql.DriverManager;
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

import models.Book;
import models.Config;
import models.User;

@WebServlet("/Home")
public class HomeController extends HttpServlet {
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
						rs.getString("SUBJECT"), rs.getString("Class"), rs.getString("State"));
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/HomePage.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}