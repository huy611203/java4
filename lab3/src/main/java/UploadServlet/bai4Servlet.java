package UploadServlet;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
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

		final String username = "bhuy94809@gmail.com";
        final String password = "lmdejwqsnntnkeed";

        String to = "trang22032005@gmail.com";

        // Địa chỉ email người gửi
        String from = "bhuy94809@gmail.com";

        // Cài đặt các thuộc tính cho phiên gửi email
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");



        // Tạo một phiên gửi email với thông tin xác thực tài khoản
        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        try {
            // Tạo đối tượng Message để thiết lập thông tin email
            Message message = new MimeMessage(session);

            // Thiết lập địa chỉ email người gửi
            message.setFrom(new InternetAddress(from));

            // Thiết lập địa chỉ email người nhận
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("trang22032005@gmail.com"));

            // Thiết lập tiêu đề email
            message.setSubject(request.getParameter("mmail"));

            // Thiết lập nội dung email
            message.setText(request.getParameter("mmail"));

            // Gửi email
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
		
		
		 request.getRequestDispatcher("/view/mail.jsp").forward(request, response);
	}

}
