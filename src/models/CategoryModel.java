package models;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Category;

public class CategoryModel extends IndexModel{
	private SessionFactory factory;
	
	public CategoryModel(SessionFactory factory) {
		// TODO Auto-generated constructor stub
		super();
		this.factory=factory;
	}
	
	public CategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Category> getCate()
	{
		Session session = factory.getCurrentSession();
		String hql = "FROM Category ORDER BY name";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> listCate = query.list();
		
		return listCate;
	}
	
	public long getNumCate(int id)
	{
		Session session = factory.getCurrentSession();
		
		String hql = "SELECT COUNT(*) FROM Book WHERE cate.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id",id);
		@SuppressWarnings("unchecked")
		List<Long> list = query.list();
		
		return list.get(0);
	}
	
	public HashMap<Category, Long> getListCountCate()
	{
		HashMap<Category, Long> hash=new HashMap<Category, Long>();
		List<Category> cate=this.getCate();
		cate.forEach((element)->{
			hash.put(element, getNumCate(element.getId()));
		});
		
       
		return hash;
	}
	
	public boolean deleteCate(int id) {
		Session session = factory.openSession();
		String hql = "DELETE FROM Category WHERE id = :id";
		
		Transaction t = session.beginTransaction();
		try {
			Query query = session.createQuery(hql);
			query.setParameter("id", id).executeUpdate();
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return false;
		} finally {
			session.close();
		}
		
		return true;
	}
	
	public boolean checkDeleteCate(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Book WHERE cate.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Category> list = query.list();
		if(list.isEmpty())
		{
			return true;
		}
		return false;
	}
}
