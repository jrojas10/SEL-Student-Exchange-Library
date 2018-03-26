package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;

@WebServlet("/SignUp")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUpController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/SignUp.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String first = request.getParameter("FirstName");
		String second = request.getParameter("LastName");
		String email = request.getParameter("email");
		String ps1 = request.getParameter("password1");
		String ps2 = request.getParameter("password2");
		
		ArrayList<User> users = (ArrayList<User>) getServletContext().getAttribute("users");
		User newUser = new User (first,second,email,ps1);
		users.add(newUser);
		response.sendRedirect("Profile");

		doGet(request, response);
	}
	

}
