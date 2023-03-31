package repo;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Users;

public class UsersRepo {
	public ArrayList<Users> getAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		EntityManager em = emf.createEntityManager();
		String hql = "select u from Users u";
		try {
			em.getTransaction().begin();
			TypedQuery<Users> query = em.createQuery(hql, Users.class);
			ArrayList<Users> list = (ArrayList<Users>) query.getResultList();
			em.getTransaction().commit();
			em.close();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean create(Users u) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean update(Users u) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean delete(String id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Users u = em.find(Users.class, id);
			em.remove(u);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Users getOne(String id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Users u = em.find(Users.class, id);

			return u;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
