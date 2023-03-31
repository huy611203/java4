package poly.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import poly.edu.model.User;
import poly.edu.model.Video;
import poly.edu.untility.JpaUtils;

public class VideoDao extends Dao<Video, String>{
private EntityManager em = JpaUtils.getEntityManager();
    
    @Override
    protected void finalize() throws Throwable{
    	em.close();
    	super.finalize();
    	
    }

	@Override
	public void insert(Video entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
		    em.getTransaction().rollback();
		    throw new RuntimeException(e);
		}
		
	}

	@Override
	public void update(Video entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void delete(String key) {
		Video video = this.finByID(key);
		try {
			em.getTransaction().begin();
			em.remove(video);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Video> finAll() {
		String jpql = "SELECT o FROM Video o";
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		List<Video> list = query.getResultList();
		
			return list;
		
	}

	@Override
	public Video finByID(String key) {
		 Video video = em.find(Video.class, key);
			return video;
		
	}
	
	public List<Video> finByIDKeyWord(String keyword){
	
		String jpql = "SELECT DISTINCT o.video FROM Favorites o "
		+ " WHERE o.video.title LIKE '%" + keyword + "%'";
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		
		
		List<Video> list = query.getResultList();
	    return list;
        
	}

    public List<Video> showVideo(boolean favorite){
    	
    	String jpql = "SELECT o FROM Video o WHERE o.Favorites IS EMPTY";
    	if(favorite) {
    	jpql = "SELECT o FROM Video o WHERE o.favorites IS NOT EMPTY";
    	}
    	TypedQuery<Video> query = em.createQuery(jpql, Video.class);
    	List<Video> list = query.getResultList();
        return list;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
}
