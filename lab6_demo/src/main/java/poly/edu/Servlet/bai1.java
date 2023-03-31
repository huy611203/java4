package poly.edu.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.dao.UserDAO;
import poly.edu.model.Favorites;
import poly.edu.model.User;


@WebServlet("/findvideo")
public class bai1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/bai1/bai1.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		UserDAO daouser = new UserDAO();
		User user = daouser.finByID(username);
		List<Favorites> favorites = user.getFavorites();
		request.setAttribute("user", user);
		request.setAttribute("favorites", favorites);
		request.getRequestDispatcher("/views/bai1/bai1.jsp").forward(request, response);
	}

}