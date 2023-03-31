package com.example.demo2.servlet;

import com.example.demo2.dao.Video2Dao;
import com.example.demo2.model.VideoEntity;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
@WebServlet(name = "VideoServlet2", value = {"/video2/index","/video2/create","/video2/edit/*","/video2/delete"})
public class VideoServlet2 extends HttpServlet {

    Video2Dao videoDao = new Video2Dao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<VideoEntity> listAllVideo = videoDao.getAllVideo();
        VideoEntity videoForm2 = new VideoEntity();

        String uri = request.getRequestURI();

        if(uri.contains("edit")){

            String videoID = uri.substring(uri.lastIndexOf("/")+1);
            System.out.println(videoID);

            //Find video by ID
            videoForm2 =videoDao.getVideoByID(videoID);
        }
        request.setAttribute("videoForm2",videoForm2 );
        request.setAttribute("listvideo",listAllVideo );
        System.out.println(listAllVideo.size());

        request.getRequestDispatcher("/views/Video2.jsp").forward(request,response);
    }

    public  void  createVideo(HttpServletRequest request){
        try {
        //Get video from JSP
        VideoEntity newVideo = new VideoEntity();
        BeanUtils.populate(newVideo,request.getParameterMap());
        //Save to DB -> call dao
         videoDao.saveVideo(newVideo);
         request.setAttribute("message","Lưu video thành công" );

        } catch (Exception e) {
            request.setAttribute("message","Lưu video thất bại" );

            System.out.println(e.toString());
        }
    }
    public  void  updateVideo(HttpServletRequest request){
        try {
            //Get video from JSP
            VideoEntity newVideo = new VideoEntity();
            BeanUtils.populate(newVideo,request.getParameterMap());
            //Save to DB -> call dao
            videoDao.updateVideo(newVideo);
            request.setAttribute("message","Sửa video thành công" );

        } catch (Exception e) {
            request.setAttribute("message","Sửa video thất bại" );

            System.out.println(e.toString());
        }
    }

    public  void  deleteVideo(HttpServletRequest request){
        try {
            //Get video from JSP
            VideoEntity newVideo = new VideoEntity();
            BeanUtils.populate(newVideo,request.getParameterMap());
            //Save to DB -> call dao

            videoDao.deleteVideo(newVideo);
            request.setAttribute("message","Xóa video thành công" );

        } catch (Exception e) {
            request.setAttribute("message","Xóa video thất bại" );

            System.out.println(e.toString());
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

        String uri = request.getRequestURI();

        if (uri.contains("create")){
            createVideo(request);
        } else if (uri.contains("edit")) {

            updateVideo(request);
        }else  if (uri.contains("delete")) {

            deleteVideo(request);
        }

        doGet(request,response);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
