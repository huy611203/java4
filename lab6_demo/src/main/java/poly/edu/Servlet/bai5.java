package poly.edu.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.dao.ReportDao;


@WebServlet("/ShowReport")
public class bai5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      ReportDao reportDao = new ReportDao();
	      request.setAttribute("items", reportDao.getInfor());
	      request.getRequestDispatcher("views/bai5/bai5.jsp").forward(request, response);
	}

}
