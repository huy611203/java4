package com.example.demo2.dao;

import com.example.demo2.common.JPSUtils;
import com.example.demo2.model.VideoEntity;
import java.util.List;
import javax.persistence.EntityManager;

public class Video2Dao {

    EntityManager em;

    public  VideoEntity getVideoByID(String id){
        em = JPSUtils.getEntityManager();

        VideoEntity videobyid = em.find(VideoEntity.class,id);

        return  videobyid;
    }

    public Boolean saveVideo(VideoEntity newVideo){

        em = JPSUtils.getEntityManager();
        Boolean saveResutl = false;
        try{
            em.getTransaction().begin();

            //save
            em.persist(newVideo);

            em.getTransaction().commit();
            saveResutl =true;
        }catch (Exception e){
            em.getTransaction().rollback();

        } 
        return  saveResutl;
    }

    public Boolean deleteVideo(VideoEntity newVideo){

        em = JPSUtils.getEntityManager();
        Boolean saveResutl = false;
        try{
            em.getTransaction().begin();

            VideoEntity delvideo =em.find(VideoEntity.class,newVideo.getId());
            //save
            em.remove(delvideo);

            em.getTransaction().commit();

            saveResutl =true;
        }catch (Exception e){
            em.getTransaction().rollback();
            System.out.println(e.toString());
        }
        return  saveResutl;
    }

    public Boolean updateVideo(VideoEntity newVideo){

        em = JPSUtils.getEntityManager();
        Boolean saveResutl = false;
        try{
            em.getTransaction().begin();

            //save
            em.merge(newVideo);

            em.getTransaction().commit();
            saveResutl =true;
        }catch (Exception e){
            em.getTransaction().rollback();

        }
        return  saveResutl;
    }
    public List
            <VideoEntity>  getAllVideo(){
        em = JPSUtils.getEntityManager();

        String sql ="Select v from VideoEntity v";

        List<VideoEntity> listAllvideo = em.createQuery(sql).getResultList();

        return  listAllvideo;

    }

}
