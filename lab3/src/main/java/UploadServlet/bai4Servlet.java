package UploadServlet;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bai4")
public class bai4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public bai4Servlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              request.getRequestDispatcher("/view/mail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String to = request.getParameter("to");
		 String subjeck = request.getParameter("subject");
		 String content = request.getParameter("content");
		 
		 Properties props = new Properties();
		 props.put("mail.smtp.auth", "true");
		 props.put("mail.smtp.starttls.enable","true");
		 props.put("mail.smtp.host", "smtp.gmail.com");
		 props.put("mail.smtp.port", "587");
		 
		 final String username="bhuy94809@gmail.com";
		 final String password="lmdejwqsnntnkeed";
		 
		 Session session = Session.getInstance(props,new javax.mail.Authenticator() {
			 protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				 return new javax.mail.PasswordAuthentication(username, password);
			 } 
				 });
		 try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(
					Message.RecipientType.TO, 
					InternetAddress.parse(to));
			message.setSubject(subjeck);
			message.setText(content);
			Transport.send(message);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		 request.getRequestDispatcher("/view/mail.jsp").forward(request, response);
	}

}
