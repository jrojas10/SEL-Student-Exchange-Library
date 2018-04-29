package mvc;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import models.Config;
import models.Post;
import models.User;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ArrayList<User> users = new ArrayList<User>();
		List<User> users = new ArrayList<User>();
		java.sql.Connection c = null;
		try {
			Config cfg = new Config();
			String username = cfg.getProperty("dbUserName");
			String password = cfg.getProperty("dbPassword");
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu49";
			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Users2");
			while (rs.next()) {
				User u = new User(rs.getInt("UserID"), rs.getString("FirstName"), rs.getString("LastName"),
						rs.getString("EMail"), rs.getString("PASSWORD"), rs.getString("UserName"),
						rs.getString("Phone"));
				users.add(u);
			}
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
		request.setAttribute("users", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Login.jsp");
		dispatcher.forward(request, response);
	}

	//

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get parameters
		String email = request.getParameter("email");
		String ps = request.getParameter("password");

		java.sql.Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu49";

			Config cfg = new Config();
			// String url = cfg.getProperty("dbUrl");
			String username = cfg.getProperty("dbUserName");
			String password = cfg.getProperty("dbPassword");
			c = DriverManager.getConnection(url, username, password);
			// change name of database
			String sql = "select * from Users2 where email = ? and password = ?";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, ps);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				User u = new User(rs.getInt("UserID"), rs.getString("FirstName"), rs.getString("LastName"),
						rs.getString("EMail"), rs.getString("PASSWORD"), rs.getString("UserName"),
						rs.getString("Phone"));
				request.setAttribute("u", u);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Profile.jsp");
				dispatcher.forward(request, response);

				return;
			}
			response.sendRedirect("Profile");
			return;

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
}
