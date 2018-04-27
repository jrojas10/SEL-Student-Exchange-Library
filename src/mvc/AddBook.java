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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] inputs = new String[8];
				
		//get parameters
		String title, aFirst, aLast, isbn, sub, clas, condition, price;
		
		title = request.getParameter("title");                  inputs[0] = title;
		aFirst = request.getParameter("authFirstName");         inputs[1] = aFirst;
		aLast = request.getParameter("authLastName");           inputs[2] = aLast;
		isbn = request.getParameter("isbn");                    inputs[3] = isbn;
		sub = request.getParameter("subject");                  inputs[4] = sub;
		clas = request.getParameter("ofClass");                 inputs[5] = clas;
		condition = request.getParameter("condition");          inputs[6] = condition;
		price = request.getParameter("price");                  inputs[7] = price;
		
		System.out.println("= = = = = = = ");
		for ( String str : inputs )
			System.out.println(str);
		System.out.println("- - - - - - - -");
		// check if one or more parameters are empty or null
		System.out.println(incomplete(inputs));
		if ( incomplete(inputs) ) {
			response.sendRedirect("Post");
			return;
		}
		
		Connection c = null;
		try {
			Config cfg = new Config();
			//String url = cfg.getProperty("dbUrl");
			//String username = cfg.getProperty("dbUserName");
			//String password = cfg.getProperty("dbPassword");
			
			
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu49";
			String username = "cs3220stu49";
			String password = "#Enwva2#";
			System.out.println(username + "  " + password);
			
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
			System.out.println("Query successful");
		} catch (SQLException e) {
			System.out.println("---- Error ----");
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
			if ( s.trim().length() == 0 || s == null )
				return true;
		}
		return false;
	}
}
