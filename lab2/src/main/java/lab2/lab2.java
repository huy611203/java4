package lab2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/tamgiac","/dientich","/chuvi"})
public class lab2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public lab2() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.getRequestDispatcher("/view/lab2.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         double a = Double.parseDouble(request.getParameter("a"));
         double b = Double.parseDouble(request.getParameter("b"));
         double c = Double.parseDouble(request.getParameter("c"));
         
         double chuvi = a + b + c;
         if (a+b>c && a+c>b && b+c>a) {
        	 String ur = request.getRequestURI();
			if (ur.contains("chuvi")) {
				request.setAttribute("message","chu vi của tam giác là:" + chuvi);
			} else if(ur.contains("dientich")){
                double dientich = Math.sqrt(chuvi*(a+b-c)*(a+c-b)*(b+c-a))/4;
                request.setAttribute("message", "diện tích của tam giác là" + dientich);
			}
		} else {
                request.setAttribute("message","Không thỏa mãn của một cạnh tam giác");
		}
         request.getRequestDispatcher("/view/lab2.jsp").forward(request, response);

         
	}

}
