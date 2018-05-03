package mvc;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

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

import models.User;

@WebServlet("/Verification")
public class VerificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("Home");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String first = request.getParameter("FirstName");
		String second = request.getParameter("LastName");
		String email = request.getParameter("email");
		String username2 = request.getParameter("username");
		String phone = request.getParameter("phone");
		String ps1 = request.getParameter("password1");
		String ps2 = request.getParameter("password2");
		//verify password and no null entry
		if (first == null || first.trim().length() == 0 || second == null || second.trim().length() == 0
				|| email == null || email.trim().length() == 0 || ps1 == null || ps1.trim().length() == 0 || ps2 == null
				|| ps2.trim().length() == 0 || username2.trim().length() == 0 || username2 == null) {
			response.sendRedirect("SignUp");
			return;
		}
		
		//verify it contains @calstatela.edu
		boolean valid = email.toLowerCase().contains("@calstatela.edu");
		if(!valid) {
			response.sendRedirect("SignUp");
			return;
		}
		
		User pending = new User (0,first,second,email,ps2,username2,phone);
		
		getServletContext().setAttribute("pending", pending);
		
		
		
		 String passcode = passcode();
		 
		 
		 getServletContext().setAttribute("code", passcode);
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("sel.csula@gmail.com","moresecurepassword");
					}
				});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("sel.csula@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(email));
				message.setSubject("SEL-Verification Code");
				message.setText("Dear SEL user," +
						"\n\n This is your verification code: " + passcode + "\n\n Please enter this code in the sign up page to complete the verification process");

				Transport.send(message);

				System.out.println("Done, passcode is: " + passcode);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Verify.jsp");
			dispatcher.forward(request, response);
		}
		
	

	public static String passcode() {

		Random rand = new Random();
		String num = String.format("%04d", rand.nextInt(10000));
		return num;

	}

}
