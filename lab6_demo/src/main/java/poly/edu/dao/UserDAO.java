package poly.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import poly.edu.model.User;
import poly.edu.untility.JpaUtils;

public class UserDAO extends Dao<User, String>{

	private EntityManager em = JpaUtils.getEntityManager();
    
    @Override
    protected void finalize() throws Throwable{
    	em.close();
    	super.finalize();
    	
    }
	@Override
	public void insert(User entity) {
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
	public void update(User entity) {
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
		User user = this.finByID(key);
		try {
			em.getTransaction().begin();
			em.remove(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<User> finAll() {
	String jpql = "SELECT o FROM User o";
	TypedQuery<User> query = em.createQuery(jpql, User.class);
	List<User> list = query.getResultList();
	
		return list;
	}

	@Override
	public User finByID(String key) {
	     User user = em.find(User.class, key);
		return user;
	}
	
	public List<User> findUserLikeVideo(String videoId){
		String jpql = "SELECT o.user FROM Favorite o WHERE o.video.id=:vid";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("vid", videoId);
		List<User> list = query.getResultList();
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}