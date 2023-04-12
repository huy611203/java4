package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constant.SessionAttr;
import model.User;
import service.UserService;
import service.Impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/login", "/logout", "/register" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userservice = new UserServiceImpl();
	public UserController() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/login":
			doGetlogin(request, response);
			break;
		case "/register":
			doGetRegister(request, response);
			break;
		case "/logout":
			doGetlogout(session,request, response);
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/login":
			doPostlogin( session,request, response);
			break;
		case "/register":
		    doPostRegister(session, request, response);
			break;
		} 
		
	}
	private void doGetlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("view/user/index.jsp").forward(request, response);
	}
	private void doGetRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("view/user/register.jsp").forward(request, response);
	}
	
	private void doGetlogout(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session.removeAttribute(SessionAttr.CURRENT_USER);
		response.sendRedirect("index");
	}
	
	
	private void doPostlogin(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = userservice.login(username, password);
		
		if (user != null) {
			session.setAttribute(SessionAttr.CURRENT_USER, user);
			response.sendRedirect("index");
		}else {
			response.sendRedirect("login");
		}
		
	}
	private void doPostRegister(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User user = userservice.create(username, password, email);
		
		if (user != null) {
			session.setAttribute(SessionAttr.CURRENT_USER, user);
			response.sendRedirect("index");
		}else {
			response.sendRedirect("register");
		}
		request.getRequestDispatcher("view/user/login.jsp").forward(request, response);

	}
}




