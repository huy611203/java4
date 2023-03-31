package poly.edu.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.dao.VideoDao;


@WebServlet("/findvideotitle")
public class bai2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/views/bai2/bai2.jsp").forward(request, response);
	}
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String keyword = request.getParameter("keyword");
		VideoDao daovideo = new VideoDao();
		request.setAttribute("videos", daovideo.finByIDKeyWord(keyword));
		request.getRequestDispatcher("/views/bai2/bai2.jsp").forward(request, response);
	}

}
