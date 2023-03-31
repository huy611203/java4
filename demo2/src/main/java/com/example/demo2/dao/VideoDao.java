package com.example.demo2.dao;

import com.example.demo2.common.*;
import javax.persistence.EntityManager;
import com.example.demo2.model.*;

import java.util.List;

public class VideoDao {

    EntityManager em;

    public List<VideoEntity> getAllVideo(){
        em = JPSUtils.getEntityManager();
        String jql ="Select v from VideoEntity v";
        List<VideoEntity>  listAllVideo = em.createQuery(jql).getResultList();
        em.close();
        return listAllVideo;
    }
    public boolean create(VideoEntity newVideo) {
        em = JPSUtils.getEntityManager();
        em.getTransaction().begin();
        Boolean insertResult = false;
        try {
            em.persist(newVideo);
            insertResult = true;
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
            em.getTransaction().rollback();
        } finally {
            em.close();
            // Return
            return insertResult;
        }
    }
    public boolean deleteVideo(VideoEntity newVideo) {
        em = JPSUtils.getEntityManager();
        em.getTransaction().begin();
        Boolean insertResult = false;
        try {
            System.out.println(newVideo.getId());

            VideoEntity deleteVideo = em.find(VideoEntity.class,newVideo.getId());

            em.remove(deleteVideo);

            System.out.println("Delete dao");
            insertResult = true;
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
            em.getTransaction().rollback();
        } finally {
            em.close();
            // Return
            return insertResult;
        }
    }
    public boolean updateVideo(VideoEntity video){
        em = JPSUtils.getEntityManager();
        em.getTransaction().begin();
        Boolean insertResult = false;
        try {
            em.merge(video);
            insertResult = true;
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.toString());
            em.getTransaction().rollback();
        } finally {
            // Return
            em.close();
            return insertResult;
        }
    }
    public VideoEntity getVideoByID(String ID){
        em = JPSUtils.getEntityManager();
        VideoEntity curentVideo = em.find(VideoEntity.class,ID);
        em.close();
        return  curentVideo;

    }

}
