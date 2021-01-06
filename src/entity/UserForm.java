package entity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class UserForm {
	@Valid
	private User user;
	
	@NotBlank(message = "Không được để trống confirm password !")
	@NotNull(message = "Không được để trống confirm password !")
	private String confirmPassword;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public UserForm() {
		// TODO Auto-generated constructor stub
	}
}
