package edu.poly.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ChuNhat")
public class ChuNhat extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChuNhat() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/View/ChuNhat.jsp").forward(request, response);
//		super.doGet(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dai = request.getParameter("dai");
        String rong = request.getParameter("rong");
        
        double chieuDai = Double.parseDouble(dai);
        double chieuRong = Double.parseDouble(rong);
        
        double chuVi = (chieuDai+chieuRong)*2;
        double dienTich = (chieuDai*chieuRong);
        
        request.setAttribute("chuvi", chuVi);
        request.setAttribute("dientich", dienTich);
        
        request.getRequestDispatcher("/View/ChuNhat.jsp").forward(request, response);

//	  	super.doPost(request, response);
	}

}
