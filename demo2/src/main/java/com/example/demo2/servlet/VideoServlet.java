package com.example.demo2.servlet;

import com.example.demo2.dao.VideoDao;
import com.example.demo2.model.VideoEntity;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(name = "VideoServlet", value = {"/video/index","/video/create","/video/edit/*","/video/delete"})
public class VideoServlet extends HttpServlet {

    VideoDao videodao = new VideoDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Get all video from DB

        VideoEntity videoForm = new VideoEntity();

        String uri = request.getRequestURI();

        String method = request.getMethod();

        System.out.println(method);

        System.out.println(uri);

        if(uri.contains("edit")&&method.equals("GET")){
            String id = uri.substring(uri.lastIndexOf("/")+1);
            System.out.println(id);
            videoForm=  videodao.getVideoByID(id);
        }
        request.setAttribute("videoForm",videoForm);
        List<VideoEntity> listAllVideo = videodao.getAllVideo();
        request.setAttribute("listAllVideo",listAllVideo);

        request.getRequestDispatcher("/views/ListVideo.jsp").forward(request,response);
    }

    public void editVideo(HttpServletRequest request,VideoEntity videoForm ){
        try {
            BeanUtils.populate(videoForm,request.getParameterMap());
            videodao.updateVideo(videoForm);
            request.setAttribute("message","Sửa video thành công");
            System.out.println("VideoServlet.createVideo");
        }catch (Exception e){
            request.setAttribute("message","Sửa video thất bại");

            System.out.println(e.toString());
        }
    }
    public void createVideo(HttpServletRequest request,VideoEntity videoForm ){
            try {
                BeanUtils.populate(videoForm,request.getParameterMap());
                videodao.create(videoForm);
                request.setAttribute("message","Thêm video thành công");
                System.out.println("VideoServlet.createVideo");
            }catch (Exception e){
                request.setAttribute("message","Thêm video thất bại");

                System.out.println(e.toString());
            }
    }

    public void deleteVideo(HttpServletRequest request,VideoEntity videoForm ){
        try {
            BeanUtils.populate(videoForm,request.getParameterMap());
            videodao.deleteVideo(videoForm);
            request.setAttribute("message","Xóa video thành công");
            System.out.println("VideoServlet.createVideo");
        }catch (Exception e){
            request.setAttribute("message","Xóa video thất bại");

            System.out.println(e.toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        System.out.println(uri);
        VideoEntity videoForm = new VideoEntity();
        if(uri.contains("create")){
            createVideo(request,videoForm);
        } else if (uri.contains("edit")) {
            editVideo(request,videoForm);
        }else {

            deleteVideo(request,videoForm);
        }

        List<VideoEntity> listAllVideo = videodao.getAllVideo();
        request.setAttribute("listAllVideo",listAllVideo);
       // response.sendRedirect(request.getContextPath()+"/video/index");
        request.getRequestDispatcher("/views/ListVideo.jsp").forward(request,response);
    }
}
