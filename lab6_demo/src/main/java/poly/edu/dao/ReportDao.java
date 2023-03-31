package poly.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import poly.edu.model.Report;
import poly.edu.model.User;
import poly.edu.untility.JpaUtils;

public class ReportDao extends Dao<Report, String>{
private EntityManager em = JpaUtils.getEntityManager();
    
    @Override
    protected void finalize() throws Throwable{
    	em.close();
    	super.finalize();
    	
    }
	@Override
	public void insert(Report entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Report entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Report> finAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Report finByID(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Report> getInfor(){
		String jpql = "SELECT new Report(o.video.title,count(o),"
				+ "max(o.likeDate),min(o.likeDate))"
				+ "FROM Favorite o"
				+ "GROUP BY o.video.title";
		TypedQuery<Report> query = em.createQuery(jpql, Report.class);
		List<Report> list = query.getResultList();
		return list;
	}

}
