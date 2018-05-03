package mvc;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Config;

/**
 * Servlet implementation class RemoveBook
 */
@WebServlet("/RemoveBook")
public class RemoveBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id"));
		
		java.sql.Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu49";

			Config cfg = new Config();
			// String url = cfg.getProperty("dbUrl");
			String username = cfg.getProperty("dbUserName");
			String password = cfg.getProperty("dbPassword");
			c = DriverManager.getConnection(url, username, password);
			// change name of database
			String sql = "delete from Books where BookID = ?";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, id);
			
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
		response.sendRedirect("Profile");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
