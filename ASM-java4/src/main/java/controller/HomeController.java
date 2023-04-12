package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


@WebServlet(urlPatterns = {"/index","/favorites","/history"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VideoService videoService = new VideoServiceImpl();
    private HistoryService historyService = new HistoryServiceImpl();
    public HomeController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/index":
			doGetIndex(request, response);
			break;
		case "/favorites":
			doGetFavorites(session,request, response);
			break;
		case "/history":
			doGetHistory(session,request, response);
			break;
		}
		
		
		
		
		
	}


	protected void doGetIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Video> videos = videoService.findAll();
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("/view/user/index.jsp").forward(request, response);
	}
	protected void doGetFavorites(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		List<History> histories = historyService.findByUserAndIsliked(user.getUsername());
		List<Video> videos = new ArrayList<>();
		histories.forEach(item -> videos.add(item.getVideo()));
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("view/user/favorites.jsp").forward(request, response);
	}
	
	protected void doGetHistory(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		List<History> histories = historyService.findByUser(user.getUsername());
		List<Video> videos = new ArrayList<>();
		histories.forEach(item -> videos.add(item.getVideo()));
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("view/user/history.jsp").forward(request, response);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
