package lab2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DangKy")
public class DangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DangKy() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("/view/dangKy/form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 request.getRequestDispatcher("/view/dangKy/result.jsp").forward(request, response);
		 
		 
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 
		 
		 String username = request.getParameter("Ten");
		 boolean gender = Boolean.parseBoolean(request.getParameter("gioiTinh"));
		 boolean married = (request.getParameter("DaCoGiaDinh") != null);
		 String country = request.getParameter("country");
		 System.out.println(">>username: " + username);
		 System.out.println(">>gender: " + gender);
		 System.out.println(">>married: " + married);
		 System.out.println(">>country: " + country);
	}

}
