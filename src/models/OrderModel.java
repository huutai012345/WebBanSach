package models;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Order;
import entity.OrderDetail;

public class OrderModel {
	private SessionFactory factory;	
	
	public OrderModel(SessionFactory factory) {
		// TODO Auto-generated constructor stub
		super();
		this.factory=factory;
	}
	
	public OrderModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order get(int id)
	{
		Session session = factory.getCurrentSession();
		String hql = "FROM Order WHERE id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Order> list = query.list();
		return list.get(0);
	}
	
	public OrderDetail getOrderDetail1(int id)
	{
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderDetail WHERE id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<OrderDetail> list = query.list();
		return list.get(0);
	}
	
	public OrderDetail getOrderDetail1(int bookId,int orderId)
	{
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderDetail WHERE book.id=:bookId AND order.id=:orderId";
		Query query = session.createQuery(hql);
		query.setParameter("bookId", bookId);
		query.setParameter("orderId", orderId);
		@SuppressWarnings("unchecked")
		List<OrderDetail> list = query.list();
		return list.get(0);
	}
	
	public Order getOrderByUser(int id)
	{
		Session session = factory.getCurrentSession();
		String hql = "FROM Order WHERE user.id=:id AND status=0";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Order> list = query.list();
		return list.get(0);
	}
	
	public List<OrderDetail> getOrderDetail(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderDetail u WHERE u.order.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<OrderDetail> list = query.list();
		return list;
	}
		
	public List<OrderDetail> getOrderDetailByUser(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderDetail WHERE order.user.id=:id AND order.status=0";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<OrderDetail> list = query.list();
		
		return list;
	}
	
	public List<OrderDetail> getOrderDetailHistoryByUser(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderDetail WHERE order.user.id=:id AND order.status=1";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<OrderDetail> list = query.list();
		
		return list;
	}
	
	
	public double getTotalOrder(int id) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT SUM(book.price*amount) FROM OrderDetail WHERE order.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Double> list = query.list();
		
		if(list.get(0)==null)
		{
			return 0;
		}
		return list.get(0);
	}
	
	public long getNumProductOrderDetail(int id) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT amount FROM OrderDetail WHERE id = :id ";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Long> list = query.list();
		
		if(list.get(0)==null)
		{
			return 0;
		}
		return list.get(0);
	}

	public boolean insertOrderDetail(OrderDetail orderDetail) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(orderDetail);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.print(e);
			return false;
		} finally {
			session.close();
		}
		
		return true;
	}
	
	public boolean insertOrder(Order order) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(order);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.print(e);
			return false;
		} finally {
			session.close();
		}
		
		return true;
	}
	
	public boolean deleteOrderByUser(int id) {
		Session session = factory.openSession();
		String hql = "DELETE FROM Order WHERE user.id = :id";
		int result =0;
		
		Transaction t = session.beginTransaction();
		try {
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			result = query.executeUpdate();
			t.commit();
		} catch (Exception e) {
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
	
	public boolean deleteOrderDetail(int id) {
		Session session = factory.openSession();
		String hql = "DELETE FROM OrderDetail WHERE id = :id";
		int result =0;
		
		Transaction t = session.beginTransaction();
		try {
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			result = query.executeUpdate();
			t.commit();
		} catch (Exception e) {
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
	
	public boolean updateStatusOrder(int id) {
		Session session = factory.openSession();
		String hql = "UPDATE Order SET status = true WHERE id=:id";
		int result =0;
		
		Transaction t = session.beginTransaction();
		try {
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			result = query.executeUpdate();
			t.commit();
		} catch (Exception e) {
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
	
	public boolean updateAmount(int bookId,int orderId,int amount) {
		Session session = factory.openSession();
		String hql = "UPDATE OrderDetail u SET amount = :amount WHERE u.order.id=:id AND u.book.id=:bookId";
		int result =0;
		
		Transaction t = session.beginTransaction();
		try {
			Query query = session.createQuery(hql);
			query.setParameter("id", orderId);
			query.setParameter("bookId", bookId);
			query.setParameter("amount", amount);
			result = query.executeUpdate();
			t.commit();
		} catch (Exception e) {
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
	
	public boolean updateAmount1(int bookId,int orderId,int amount) {
		Session session = factory.openSession();
		String hql = "UPDATE OrderDetail u SET amount = amount + :amount WHERE u.order.id=:id AND u.book.id=:bookId";
		int result =0;
		
		Transaction t = session.beginTransaction();
		try {
			Query query = session.createQuery(hql);
			query.setParameter("id", orderId);
			query.setParameter("bookId", bookId);
			query.setParameter("amount", amount);
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
	
	public boolean checkExistOrderDetail(int bookId,int orderId) {
		Session session = factory.openSession();
		String hql = "FROM OrderDetail WHERE order.id=:id AND book.id=:bookId";
		
		Query query = session.createQuery(hql);
		query.setParameter("id", orderId);
		query.setParameter("bookId", bookId);
		@SuppressWarnings("unchecked")
		List<Order> list = query.list();
	
		if(list.isEmpty())
		{
			return true;
		}	
		return false;
	}
}
