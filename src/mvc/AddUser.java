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
		//get parameters from Sign up form
		String first = request.getParameter("FirstName");
		String second = request.getParameter("LastName");
		String email = request.getParameter("email");
		String ps1 = request.getParameter("password1");
		String ps2 = request.getParameter("password2");
		
		//validation here
		
		
		//connection to database
		// query to add person to database
		Connection c = null;
		try {
			String url = "jdbc:mysql://localhost:3306";
			String username = "root";
			String password = "pass";
			
			String sql = "INSERT INTO `sel`.`users` (`FirstName`, `LastName`, `email`, `password`) VALUES (?, ?, ?, ?);";
			c = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, first);
			pstmt.setString(2, second);
			pstmt.setString(3, email);
			pstmt.setString(4, ps1);
			
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
