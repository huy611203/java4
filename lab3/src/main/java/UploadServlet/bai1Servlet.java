package UploadServlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/bai1")
public class bai1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public bai1Servlet() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.getRequestDispatcher("/view/upload.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// đường dẫn thư mục tính từ gốc của website
		File dir = new File(request.getServletContext().getRealPath("/files"));
		if(!dir.exists()) { // tạo nếu chưa tồn tại
		dir.mkdirs();
		}
		// lưu các file upload vào thư mục files
		Part photo = request.getPart("photo_file"); // file hình
		File photoFile = new File(dir, photo.getSubmittedFileName());
		photo.write(photoFile.getAbsolutePath());
		Part doc = request.getPart("doc_file"); // file tài liệu
		File docFile = new File(dir, doc.getSubmittedFileName());
		doc.write(docFile.getAbsolutePath());
		// chia sẻ cho result.jsp để hiển thị
		request.setAttribute("img", photoFile);
		request.setAttribute("doc", docFile);
		request.getRequestDispatcher("view/result.jsp").forward(request, response);
	}

}
