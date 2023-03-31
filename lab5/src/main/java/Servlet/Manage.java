package Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;
import repo.UsersRepo;


import repo.UsersRepo;


@WebServlet(name = "Manage", value = { "/user/index", "/user/create","/user/update", "/user/delete", "/user/edit/*" })
public class Manage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersRepo repo = new UsersRepo(); 
  
    public Manage() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users u = new Users();
		ArrayList<Users> list = repo.getAll();
		request.setAttribute("list", list);
		if (request.getRequestURI().contains("edit")) {
			String id = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
			u = repo.getOne(id);
			request.setAttribute("user", u);
		}
		request.getRequestDispatcher("/view/Manage.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users u = new Users();
		boolean result = false;
		try {
			BeanUtils.populate(u, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			
			e.printStackTrace();
		}
		System.out.println(u.getId());
		if (request.getRequestURI().contains("create")) {
			result = repo.create(u);
		} else if (request.getRequestURI().contains("update")) {
			result = repo.update(u);
		} else if (request.getRequestURI().contains("delete")) {
			result = repo.delete(u.getId());
		}
		
		request.setAttribute("result", result);
		doGet(request, response);
		
	}

}