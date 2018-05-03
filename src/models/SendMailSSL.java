package models;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailSSL {
	public static void main(String[] args) {
		 int passcode = passcode();
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
					InternetAddress.parse("receiverHERE"));
			message.setSubject("SEL-Verification Code");
			message.setText("Dear SEL user," +
					"\n\n This is your verification code: " + passcode + "\n\n Please enter this code in the sign up page to complete your verification");

			Transport.send(message);

			System.out.println("Done, passcode is: " + passcode);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	public static int passcode () {

        Random rand = new Random();

        int num = rand.nextInt(9999);

        return num;

    }
}