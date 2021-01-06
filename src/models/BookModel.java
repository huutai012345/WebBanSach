package models;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Book;
import entity.OrderDetail;

public class BookModel extends IndexModel{
	private SessionFactory factory;
	
	public BookModel(SessionFactory factory) {
		// TODO Auto-generated constructor stub
		super();
		this.factory=factory;
	}
	
	public BookModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean insert(Book book) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(book);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return false;
		} finally {
			session.close();
		}

		return true;
	}
	
	public boolean update(Book book) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(book);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return false;
		} finally {
			session.close();
		}
		
		return true;
	}
	
	public List<Book> getBookByCate(String name) {
		Session session = factory.getCurrentSession();
		
		String hql = "FROM Book u WHERE u.cate.name=:name";
		Query query = session.createQuery(hql);
		query.setParameter("name",name);
		@SuppressWarnings("unchecked")
		List<Book> list = query.list();
		
		return list;
	}
	
	public Long getCountBookByCate(int id) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT COUNT(id) FROM Book WHERE cate.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id",id);
		@SuppressWarnings("unchecked")
		List<Long> list = query.list();
		return list.get(0);
	}
	
	public List<Book> getBookByCate(String name, int num) {
		Session session = factory.getCurrentSession();
		
		String hql = "FROM Book u WHERE u.cate.name=:name";
		Query query = session.createQuery(hql);
		query.setParameter("name",name);
		query.setMaxResults(num);
		query.setMaxResults(9);
		@SuppressWarnings("unchecked")
		List<Book> list = query.list();
		
		return list;
	}
	
	public List<Book> getBookByCate(int idCate, int num) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Book u WHERE u.cate.id =:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", idCate);
		query.setMaxResults(num);
		query.setMaxResults(9);
		@SuppressWarnings("unchecked")
		List<Book> list = query.list();
		return list;
	}
	
	public Long getCountBook() {
		Session session = factory.getCurrentSession();
		String hql = "SELECT COUNT(id) FROM Book";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Long> list = query.list();
		return list.get(0);
	}
	
	public List<Book> getNewBook(int num) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Book ORDER BY id DESC";
		Query query = session.createQuery(hql);
		query.setMaxResults(num);
		@SuppressWarnings("unchecked")
		List<Book> list = query.list();
		return list;
	}
	
	public List<Book> getAllBook() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Book";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Book> list = query.list();
		return list;
	}
	
	public List<Book> getListBookByPage(int start) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Book";
		Query query = session.createQuery(hql);
		query.setFirstResult(start);
		query.setMaxResults(9);
		@SuppressWarnings("unchecked")
		List<Book> list = query.list();
		return list;
	}
	
	public Book getBook(int id)
	{
		Session session = factory.getCurrentSession();
		String hql = "FROM Book b WHERE b.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Book> list = query.list();
		return list.get(0);
	}

	public List<Book> getBooks(int num) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Book ORDER BY RAND()";
		Query query = session.createQuery(hql);
		query.setMaxResults(num);
		@SuppressWarnings("unchecked")
		List<Book> list = query.list();
		return list;
	}
	
	public boolean updateAmountBook(int id , int num) {
		Session session = factory.openSession();
		String hql = "UPDATE Book SET amount = amount + :num WHERE id=:id";
		int result =0;
		
		Transaction t = session.beginTransaction();
		try {
			Query query = session.createQuery(hql);
			query.setParameter("num", num);
			query.setParameter("id", id);
			result = query.executeUpdate();
			t.commit();
		} catch (Exception e) {
			System.out.print(e);
			t.rollback();
			return false;
		}
		session.close();
		if(result>0)
		{
			return true;
		}
		
		return false;
	}
	
	public List<Book> search(String name,int num) {
		Session session = factory.getCurrentSession();
		
		String hql = "FROM Book WHERE name LIKE '%"+name+"%' ";
		Query query = session.createQuery(hql);
		query.setMaxResults(num);
		query.setMaxResults(9);
		@SuppressWarnings("unchecked")
		List<Book> list = query.list();
		
		return list;
	}
	
	public List<Book> searchByCate(int cateId,String name,int num) {
		Session session = factory.getCurrentSession();
		
		String hql = "FROM Book WHERE cate.id=:cateId AND name LIKE '%"+name+"%' ";
		Query query = session.createQuery(hql);
		query.setParameter("cateId", cateId);
		query.setMaxResults(num);
		query.setMaxResults(9);
		@SuppressWarnings("unchecked")
		List<Book> list = query.list();
		
		return list;
	}
	
	public Long getCountBookBySearch(String name) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT COUNT(id) FROM Book WHERE name LIKE '%"+name+"%' ";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Long> list = query.list();
		return list.get(0);
	}
	
	public Long getCountBookBySearchCate(String name,int cateId) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT COUNT(id) FROM Book WHERE cate.id=:cateId AND name LIKE '%"+name+"%' ";
		Query query = session.createQuery(hql);
		query.setParameter("cateId", cateId);
		@SuppressWarnings("unchecked")
		List<Long> list = query.list();
		return list.get(0);
	}
	
	public boolean checkDeleteBook(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderDetail WHERE book.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<OrderDetail> list = query.list();
		if(list.isEmpty())
		{
			return true;
		}
		return false;
	}
}
