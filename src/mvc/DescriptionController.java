package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Book;
import models.User;

/**
 * Servlet implementation class DescriptionController
 */
@WebServlet("/Description")
public class DescriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private String getCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies)
				if (cookie.getName().equals("user"))
					return cookie.getValue();

		return null;
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		User user = (User) request.getSession().getAttribute("authorizedUser");
		request.setAttribute("user", user);
		if(user == null) {
			response.sendRedirect("Login");
			return;
		}
		
		ArrayList<Book> books = (ArrayList<Book>) getServletContext().getAttribute("books");
		
		int i;
		int index = 0;
		for ( i = 0; i< books.size() ; i ++) {
			if (id == books.get(i).getId()) {
				index = i;
				System.out.println(index);
			}
		}
		request.getServletContext().setAttribute("id", index);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Description.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
