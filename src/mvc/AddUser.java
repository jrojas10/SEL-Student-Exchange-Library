package mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Config;
import models.User;

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddUser() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get parameters from Sign up form
		int code = (int) getServletContext().getAttribute("code");
		int codeEntered = Integer.parseInt(request.getParameter("key"));
		boolean match = code == codeEntered;
		
		if(!match) {
			response.sendRedirect("SignUp");
			return;
		}
		
		User verified = (User) getServletContext().getAttribute("pending");
//		String first = request.getParameter("FirstName");
//		String second = request.getParameter("LastName");
//		String email = request.getParameter("email");
//		String username2 = request.getParameter("username");
//		String phone = request.getParameter("phone");
//		String ps1 = request.getParameter("password1");
//		String ps2 = request.getParameter("password2");

		String first = verified.getFirstName();
		String second = verified.getLastName();
		String email = verified.getEmail();
		String username2 = verified.getUsername();
		String ps1 = verified.getPassword();
		String phone = verified.getPhone();
		
		// validation for null or empty values
		
		
//		if (first == null || first.trim().length() == 0 || second == null || second.trim().length() == 0
//				|| email == null || email.trim().length() == 0 || ps1 == null || ps1.trim().length() == 0 || ps2 == null
//				|| ps2.trim().length() == 0 || username2.trim().length() == 0 || username2 == null) {
//			response.sendRedirect("SignUp");
//			return;
//		}

		// validate for calstatela email here.
		
//		boolean valid = email.toLowerCase().contains("@calstatela.edu");
//		if(!valid) {
//			response.sendRedirect("SignUp");
//			return;
//		}
		
		
		// connection to database
		// query to add person to database
		Connection c = null;
		try {
			Config cfg = new Config();

			String username = cfg.getProperty("dbUserName");
			String password = cfg.getProperty("dbPassword");

			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu49";
			// `EMail`,`Phone` `PASSWORD`) VALUES (?, ?, ?, ?, ?, ?);";

			String sql = "INSERT INTO `Users` (`UserID`, `FirstName`, `LastName`, `UserName`, `EMail`, `Phone`, `PASSWORD`) VALUES (NULL,?,?,?,?,?,?);";

			c = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, first);
			pstmt.setString(2, second);
			pstmt.setString(3, username2);
			pstmt.setString(4, email);
			pstmt.setString(5, phone);
			pstmt.setString(6, ps1);

			pstmt.executeUpdate();
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
		response.sendRedirect("Login");

	}

}
