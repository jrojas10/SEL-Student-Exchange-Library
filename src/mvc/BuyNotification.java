package mvc;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Book;
import models.User;

/**
 * Servlet implementation class BuyNotification
 */
@WebServlet("/Buy")
public class BuyNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyNotification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User seller = (User) getServletContext().getAttribute("seller");
		request.setAttribute("seller", seller);
		User user = (User) request.getSession().getAttribute("authorizedUser");
		Book book = (Book) getServletContext().getAttribute("booksold");
		//getServletContext().setAttribute("code", passcode);
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sel.csula@gmail.com", "passwordhere");
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("sel.csula@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(seller.getEmail()));
			message.setSubject("SEL-Buy Notice");
			message.setText("Dear SEL user," + "\n\n Someone is interested in buying your book, \n\n " + book.getTitle() + " by " 
			+ book.getAuthorFirst() + " " + book.getAuthorLast() + " \n\n Contact this email address to set up a place and time to meet up."
					+ "\n\n" + 	user.getEmail());
					

			Transport.send(message);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Alert.jsp");
			dispatcher.forward(request, response);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
