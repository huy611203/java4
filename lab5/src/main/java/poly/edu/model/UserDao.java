package poly.edu.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import poly.edu.utils.JpaUtils;

public class UserDao {
	public int insert(User user) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			return -1;
		} finally {
			em.close();
		}
		return 1;
	}
	public int update(User user) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			return -1;
		} finally {
			em.close();
		}
		return 1;
	}
	public int delete(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			User u = em.find(User.class, id);
			System.out.println(u.toString());
			if (u != null) {
				em.remove(u);
			}
			trans.commit();
			System.out.println("Xoa Thanh Cong");
		} catch (Exception e) {
			trans.rollback();
			System.out.println(e.toString());
			return -1;
		} finally {
			em.close();
		}
		return 1;
	}
	public User findByID(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		User user = em.find(User.class, id);
		return user;
	}
	public List<User> findAll(){
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}
	public int count() {
		return findAll().size();
	}
	public boolean checkLogin(String username,String password) {
		User user = findByID(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	public boolean checkLogin1(String username,String password) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "Select u from User u where u.id = :username and u.password =:pass";
		TypedQuery<User> query = em.createNamedQuery(jpql, User.class);
		query.setParameter("username", username);
		query.setParameter("pass", password);
		User user = query.getSingleResult();
		if (user != null) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
}
