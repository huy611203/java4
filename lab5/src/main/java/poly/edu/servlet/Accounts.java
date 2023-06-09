package poly.edu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.model.User;
import poly.edu.model.UserDao;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;



@WebServlet(name = "Accounts", value = { "/account/sign-up", "/account/sign-in", "/account/sign-out",
		"/account/forgot-password", "/account/change-password", "/account/edit-profile" })
public class Accounts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDao dao = new UserDao();
  
    public Accounts() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("sign-in")) {
			request.getRequestDispatcher("/view/Signin.jsp").forward(request, response);
			return;
		}else if(uri.contains("sign-up")) {
			request.getRequestDispatcher("/view/Signup.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/view/Signin.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("sign-in")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User u = dao.findByID(username);
			System.out.println(password + "/" + u.getPassword());
			if(!u.getPassword().equalsIgnoreCase(password)) {
				request.setAttribute("result", "đăng nhập thất bại");
				request.getRequestDispatcher("/view/Signin.jsp").forward(request, response);
			}else {
				request.setAttribute("result", "đăng nhập thành công");
				request.setAttribute("user", u);
				request.getRequestDispatcher("/view/ManageAccount.jsp").forward(request, response);
			}
			
		} else if (uri.contains("sign-up")) {
			User u = new User();
			try {
				BeanUtils.populate(u, request.getParameterMap());
			} catch (IllegalAccessException | InvocationTargetException e) {
				
				e.printStackTrace();
			}
			if(dao.findByID(u.getId()) != null) {
				request.setAttribute("result", "tên đăng nhập này đã dc sử dụng bởi tài khoản khác");
			}else {
				dao.insert(u);
				request.setAttribute("result", "tạo mới thành công");
				request.getRequestDispatcher("/view/Signin.jsp").forward(request, response);
			}
		} else if (uri.contains("edit-profile")) {
			User u = new User();
			try {
				BeanUtils.populate(u, request.getParameterMap());
				dao.update(u);
			} catch (IllegalAccessException | InvocationTargetException e) {
				
				e.printStackTrace();
			}
			response.getWriter().write("cập nhật thành công");
			request.setAttribute("result", "cập nhật thành công");
		}
	}
	}


