package poly.edu.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import poly.edu.utils.JpaUtils;

public class VideoDao {
	public List<Videos> findVideoFavoriteUserID(String uID) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "SELECT o.video FROM Favorites o WHERE o.user.id =:username" ;
		TypedQuery<Videos> query = em.createQuery(jpql, Videos.class);
		query.setParameter("username", uID);
		return query.getResultList();
	}
}
