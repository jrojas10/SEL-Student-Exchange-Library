package mvc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import models.Config;
import models.User;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ArrayList<User> users = new ArrayList<User>();
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
			getServletContext().setAttribute("users", users);
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

		@SuppressWarnings("unchecked")
		ArrayList<User> users = (ArrayList<User>) getServletContext().getAttribute("users");

		String value = null;
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("User")) {
					value = cookie.getValue();
				}
			}
		}
		if (value != null) {
			for (User user : users) {

				String sID = Integer.toString(user.getId());
				String sHash = hash(sID);

				if (value.equals(sHash)) {

					HttpSession session = request.getSession();
					session.setAttribute("authorizedUser", user);

					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Profile.jsp");
					dispatcher.forward(request, response);
					return;
				}
			}

			return;
		}

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

				User user = new User(rs.getInt("UserID"), rs.getString("FirstName"), rs.getString("LastName"),
						rs.getString("EMail"), rs.getString("PASSWORD"), rs.getString("UserName"),
						rs.getString("Phone"));

				//
				HttpSession session = request.getSession();
				session.setAttribute("authorizedUser", user);

				String studentId = Integer.toString(user.getId());
				String value = hash(studentId);
				Cookie cookie = new Cookie("user", value);
				cookie.setMaxAge(60 * 60 * 24 * 7);
				cookie.setPath("/cs3220stu49");
				response.addCookie(cookie);

				//

				request.setAttribute("u", user);
				response.sendRedirect("Profile");
				return;
			}
			response.sendRedirect("Login");
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

	public String hash(String s) {

		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		byte[] encodedhash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
		return bytesToHex(encodedhash);
	}

	private static String bytesToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
