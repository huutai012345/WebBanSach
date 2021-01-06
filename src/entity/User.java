package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue
	private int id;

	@NotBlank(message = "Không được để trống tên !")
	@NotNull(message = "Không được để trống tên !")
	private String name;

	@NotBlank(message = "Không được để trống email !")
	private String email;

	@NotBlank(message = "Không được để trống địa chỉ !")
	@NotNull(message = "Không được để trống địa chỉ !")
	private String address;
	
	@NotBlank(message = "Không được để trống SĐT !")
	@NotNull(message = "Không được để trống SĐT !")
	private String phone;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Không được để trống ngày sinh !")
	private Date birthday;
	
	private String password;

	private boolean sex;

	private String role;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User() {
	}

	public User(int id, String name, String email, String address,String phone, Date birthday, String password, boolean sex,
			String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.phone=phone;
		this.password = password;
		this.sex = sex;
		this.role = role;
	}

}
