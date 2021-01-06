package models;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.OrderDetail;
import entity.User;

public class UserModel {
	private SessionFactory factory;

	public UserModel(SessionFactory factory) {
		// TODO Auto-generated constructor stub
		super();
		this.factory = factory;
	}

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<User> getBookRanByCate(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Book u WHERE u.category_id =:id  ORDER BY NEW ID()";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		return list;
	}

	public boolean insert(User user) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(user);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.println(e);
			return false;
		} finally {
			session.close();
		}

		return true;
	}
	
	public boolean delete(int id) {
		Session session = factory.openSession();
		String hql = "DELETE FROM User WHERE id = :id";
		
		Transaction t = session.beginTransaction();
		try {
			Query query = session.createQuery(hql);
			query.setParameter("id", id).executeUpdate();
			t.commit();
		} catch (Exception e) {
			t.rollback();
			session.close();	
			return false;
		} 
		
		session.close();	
		return true;
	}
	
	public User login(String email,String password) {
		Session session = factory.getCurrentSession();
		String hql = "FROM User u WHERE email = :email AND password =:password";
		try {
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			@SuppressWarnings("unchecked")
			List<User> list = query.list();

			if (list.get(0) == null) {
				return null;
			}
			return list.get(0);
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
		
	}

	public User get(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM User u WHERE u.id = :id";
		
		try {
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			@SuppressWarnings("unchecked")
			List<User> list = query.list();

			if (list.get(0) == null) {
				return null;
			}
			return list.get(0);
		} catch (Exception e) {
			return null;
		}
	}
	
	public User findByEmail(String email) {
		Session session = factory.getCurrentSession();
		String hql = "FROM User u WHERE u.email = :email";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();

		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	public boolean updateUser(User user) {
		Session session = factory.openSession();
		String hql = "UPDATE User SET name = :name , email = :email , birthday = :birthday, sex = :sex ,address = :address ,phone = :phone WHERE id=:id";
		int result = 0;

		Transaction t = session.beginTransaction();
		try {
			Query query = session.createQuery(hql);
			query.setParameter("id", user.getId());
			query.setParameter("name", user.getName());
			query.setParameter("email", user.getEmail());
			query.setParameter("birthday", user.getBirthday());
			query.setParameter("sex", user.getSex());
			query.setParameter("address", user.getAddress());
			query.setParameter("phone", user.getPhone());
			
			result = query.executeUpdate();
			t.commit();
		} catch (Exception e) {
			System.out.print(e);
			t.rollback();
			return false;
		}
		session.close();
		if (result > 0) {
			return true;
		}

		return false;
	}
	
	public boolean updatePasswordUser(String email,String password) {
		Session session = factory.openSession();
		String hql = "UPDATE User SET password = :password WHERE email=:email";
		int result = 0;

		Transaction t = session.beginTransaction();
		try {
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			
			result = query.executeUpdate();
			t.commit();
		} catch (Exception e) {
			System.out.print(e);
			t.rollback();
			return false;
		}
		session.close();
		if (result > 0) {
			return true;
		}

		return false;
	}
	
	public boolean checkDeleteUser(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderDetail WHERE order.user.id=:id";
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
