package mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

	}

	public ProfileController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Profile.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get parameters
		String email = request.getParameter("email");
		String ps = request.getParameter("password");

		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu49";
			String username = "cs3220stu49";
			String password = "#Enwva2#";

			c = DriverManager.getConnection(url, username, password);
			//change name of database
			String sql = "select * from Users2 where email = ? and password = ?";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, ps);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Profile.jsp");
				dispatcher.forward(request, response);
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

}
