package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author NHT
 *
 */
@Entity
@Table(name = "Books")
public class Book {
	@Id
	@GeneratedValue
	private int id;

	@NotBlank(message = "Không được để trống tên sách !")
	@NotNull(message = "Không được để trống tên sách !")
	private String name;

	@NotBlank(message = "Không được để trống độc giả !")
	@NotNull(message = "Không được để trống độc giả !")
	private String author;

	private String img;

	@NotNull(message = "Không được để trống giá !")
	@DecimalMin(value = "0.0", message = "Số Lượng Phải Lớn Hơn 0")
	private float price;

	@NotNull(message = "Không được để trống số lượng !")
	@Min(value = 0, message = "Số Lượng Phải Lớn Hơn 0")
	private int amount;
	
	@NotBlank(message = "Không được để trống mô tả sách !")
	@NotNull(message = "Không được để trống mô tả sách !")
	private String detail;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category cate;
	
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	
	public Category getCate() {
		return cate;
	}

	public void setCate(Category cate) {
		this.cate = cate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String name, String author,Category cate, String img, float price, int amount,String detail) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.cate = cate;
		this.img = img;
		this.price = price;
		this.amount = amount;
		this.detail=detail;
	}

}
