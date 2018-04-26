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

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] inputs = new String[8];
				
		//get parameters
		String title, aFirst, aLast, isbn, sub, clas, condition, price;
		
		title = request.getParameter("title");                  inputs[0] = title.trim();
		aFirst = request.getParameter("authFirstname");         inputs[1] = aFirst.trim();
		aLast = request.getParameter("authLastName");           inputs[2] = aLast.trim();
		isbn = request.getParameter("isbn");                    inputs[3] = isbn.trim();
		sub = request.getParameter("Subject");                  inputs[4] = sub.trim();
		clas = request.getParameter("ofClass");                 inputs[5] = clas.trim();
		condition = request.getParameter("condition");          inputs[6] = condition.trim();
		price = request.getParameter("price");                  inputs[7] = price.trim();
		
		// check if one or more parameters are empty or null
		if ( incomplete(inputs) ) {
			response.sendRedirect("Post");
			return;
		}
		
		Connection c = null;
		try {
			Config cfg = new Config();
			//String url = cfg.getProperty("dbUrl");
			String username = cfg.getProperty("dbUserName");
			String password = cfg.getProperty("dbPassword");
			
			
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu49";
			//String username = "cs3220stu49";
			//String password = "#Enwva2#";
			
			
			// writing database query
			
			String sql = "INSERT INTO `Books2` (`BookID`, `Price`, `Title`, `ISBN`, `AuthorFirst`, `AuthorLast`, `Subject`, `Class`, `State`) VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?);";
			c = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, aFirst);
			pstmt.setString(3, aLast);
			pstmt.setString(4, isbn);
			pstmt.setString(5, sub);
			pstmt.setString(6, clas);
			pstmt.setString(7, condition);
			pstmt.setString(8, price);
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

	private boolean incomplete(String[] strs) {
		for (String s : strs) {
			if ( s.length() == 0 || s == null )
				return true;
		}
		return false;
	}
}
