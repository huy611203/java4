package poly.edu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import poly.edu.model.User;
import poly.edu.model.UserDao;

@WebServlet(name = "Manage", value = { "/user/index", "/user/create", "/user/update", "/user/delete", "/user/edit/*" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDao();

	public UserServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = new User();

		ArrayList<User> list = (ArrayList<User>) userDao.findAll();
		request.setAttribute("list", list);
		if (request.getRequestURI().contains("edit")) {
			String id = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
			u = userDao.findByID(id);
			request.setAttribute("user", u);
		}
		request.getRequestDispatcher("/view/view.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User u = new User();
		int result = 0;
		try {
			BeanUtils.populate(u, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {

			e.printStackTrace();
		}

		if (request.getRequestURI().contains("create")) {
			result = userDao.insert(u);
		} else if (request.getRequestURI().contains("update")) {
			result = userDao.update(u);
		} else if (request.getRequestURI().contains("delete")) {
			result = userDao.delete(u.getId());
		}

		request.setAttribute("result", result);
		doGet(request, response);
	}

}
