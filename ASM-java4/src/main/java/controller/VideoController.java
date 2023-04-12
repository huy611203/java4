package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constant.SessionAttr;
import model.History;
import model.User;
import model.Video;
import service.HistoryService;
import service.VideoService;
import service.Impl.HistoryServiceImpl;
import service.Impl.VideoServiceImpl;


@WebServlet(urlPatterns = "/video")
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private VideoService videoService = new VideoServiceImpl();
    private HistoryService historyService = new HistoryServiceImpl();
    public VideoController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionParam = request.getParameter("action");
		String href = request.getParameter("id");
		HttpSession session = request.getSession();
		switch (actionParam) {
		case "watch":
			doGetWatch(session, href, request, response);
			break;
		case "like":
			doGetlike(session, href, request, response);	
            break;
		
		}
	}

	
	protected void doGetWatch(HttpSession session,String href,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = videoService.findByHref(href);
		request.setAttribute("video", video);
		
	    User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
         
	    if (currentUser != null) {
			History history = historyService.create(currentUser, video);
			request.setAttribute("flaglikeBtn", history.getIsLiked());
		}
		
		request.getRequestDispatcher("view/user/video-detail.jsp").forward(request, response);
	}
	
	
	
	
	
	
	protected void doGetlike(HttpSession session,String href,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = videoService.findByHref(href);
	    response.setContentType("application/json");
	    User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
	    boolean result = historyService.updateLikeOrUnLike(currentUser, href);
	    if (result == true) {
			response.setStatus(204);
		}else {
			response.setStatus(400);
		}
	}
}
