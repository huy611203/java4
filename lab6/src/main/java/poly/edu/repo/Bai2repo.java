package poly.edu.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import poly.edu.model.Users;
import poly.edu.model.Videos;

public class Bai2repo {
	public List<Users> getAllUser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab6");
		EntityManager em = emf.createEntityManager();
		String hql = "select u from Users u";
		try {
			em.getTransaction().begin();
			TypedQuery<Users> query = em.createQuery(hql, Users.class);
			List<Users> list =  query.getResultList();
			em.getTransaction().commit();
			em.close();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Users getOneUser(String id) {
		Users u = new Users();
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab6");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			u = em.find(Users.class, id);
			em.getTransaction().commit();
			em.close();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Videos> searchByTitle(String keyword){
		try {
			String hql = "SELECT DISTINCT o.video FROM Favourite o " + " WHERE o.video.title LIKE '%" + keyword + "%'";
			String hql2 = "select o from Video o join Favourite on Video.id = Favourite.video.id where Video.title like '" + keyword + "'";
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab6");
			EntityManager em = emf.createEntityManager();
			TypedQuery<Videos> query = em.createQuery(hql, Videos.class);
			em.getTransaction().begin();
			List<Videos> list = query.getResultList();
			System.out.println(list.size());
			em.getTransaction().commit();
			em.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Users> searchByVideoId(String videoId){
		try {
			String hql = "select o.user from Favourite o where o.video.id = " + videoId;
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab6");
			EntityManager em = emf.createEntityManager();
			TypedQuery<Users> query = em.createQuery(hql, Users.class);
			em.getTransaction().begin();
			List<Users> list = query.getResultList();
			em.getTransaction().commit();
			em.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
