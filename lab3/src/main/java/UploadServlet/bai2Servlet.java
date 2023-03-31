package UploadServlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

@MultipartConfig
@WebServlet("/bai2")
public class bai2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public bai2Servlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/form.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 
		 

		try {
			     classbean bean = new classbean();
            
            	DateTimeConverter dtc = new DateConverter(new Date());
            	dtc.setPattern("MM/dd/yyyy"); 
            	ConvertUtils.register(dtc, Date.class);
            	
            	
            	BeanUtils.populate(bean, request.getParameterMap());
            	
         
            	String hobbies = request.getParameter("hobbies");
            	String [] hobbies_2 = request.getParameterValues("hobbies");
            	StringBuilder sb = new StringBuilder();
            	for(String item : hobbies_2) {
            		sb.append(item).append(",").toString();
            	}
            	
            	request.setAttribute("bean", bean);
                request.setAttribute("hobbies", sb);
            
            
            
			} catch (Exception e) {
			e.printStackTrace();
			}
		request.getRequestDispatcher("/view/resultBean.jsp").forward(request, response);
	}

}
