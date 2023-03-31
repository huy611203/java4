package poly.edu.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.dao.VideoDao;


@WebServlet("/showVideo")
public class bai4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setAttribute("boo", "checked");
	    VideoDao daoVideoDao = new VideoDao();
	    request.setAttribute("videos", daoVideoDao.showVideo(true));
	    request.getRequestDispatcher("views/bai4/bai4.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VideoDao daoVideo = new VideoDao();
		boolean favorite = Boolean.parseBoolean(request.getParameter("favorite"));
		request.setAttribute("videos", daoVideo.showVideo(favorite));
		request.getRequestDispatcher("views/bai4/bai4.jsp").forward(request, response);
	}

}
