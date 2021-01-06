package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "OrderDetails")
public class OrderDetail {
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull(message = "Không được để trống số lượng !")
	@Min(value = 1, message = "Số Lượng Phải Lớn Hơn 0")
	private int amount;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date created_at;

	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderDetail(Order order) {
		super();
		this.order = order;
		Date untilDate=new Date();
		this.created_at = new java.sql.Date(untilDate.getTime());
	}

	public OrderDetail(int id, int amount, Date created_at, Order order, Book book) {
		super();
		this.id = id;
		this.amount = amount;
		this.created_at = created_at;
		this.order = order;
		this.book = book;
	}
	
	public OrderDetail(int amount, Order order, Book book) {
		super();
		this.amount = amount;
		Date untilDate=new Date();
		this.created_at = new java.sql.Date(untilDate.getTime());
		this.order = order;
		this.book = book;
	}	
}
