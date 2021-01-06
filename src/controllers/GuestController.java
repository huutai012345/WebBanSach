package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Order;
import entity.User;
import entity.UserForm;
import library.Mail;
import models.OrderModel;
import models.UserModel;;

@Transactional
@Controller
public class GuestController {
	@Autowired
	SessionFactory factory;
	
	private UserModel userModel;
	private OrderModel orderModel;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(ModelMap model) {
		model.addAttribute(new UserForm());
		return "client/register";
	}
	
	@Autowired
	JavaMailSender mailer;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(ModelMap model, @Validated @ModelAttribute("userForm") UserForm userForm,
			BindingResult errors) {
		
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
			return "client/register";
		}

		if (!userForm.getConfirmPassword().equals(userForm.getUser().getPassword())) {
			errors.rejectValue("confirmPassword", "userForm", "Confirm password not match");
			return "client/register";
		}

		User user = userForm.getUser();
		user.setRole("guest");
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(user);
			t.commit();
			model.addAttribute("message", "Success");
		} catch (Exception e) {
			t.rollback();
			System.out.println(e);
			model.addAttribute("message", "Fail");
		} finally {
			session.close();
		}
		
		this.orderModel=new OrderModel(factory);
		this.orderModel.insertOrder(new Order(user));
		
		Mail mail= new Mail(mailer);
		mail.send(user.getEmail(),"","Register Success");

		return "redirect:/login.htm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		if (email == null) {
			return "client/login";

		}
		return "redirect:/index.htm";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ModelMap model, @RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest request) {
		Session session = factory.getCurrentSession();
		String hql = "FROM User u WHERE u.email = :email AND u.password=:password";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("password", password);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		if (list.isEmpty()) {
			model.addAttribute("message", "Login Fail: account or password is incorrect");
			return "client/login";
		}

		HttpSession session1 = request.getSession();
		session1.setAttribute("email", list.get(0).getEmail());
		session1.setAttribute("name", list.get(0).getName());
		session1.setAttribute("id", list.get(0).getId());
		session1.setAttribute("role", list.get(0).getRole());

		String url = "/index.htm";
		if (session1.getAttribute("url") != null) {
			url = (String) session1.getAttribute("url");
		}
		return "redirect:" + url;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.removeAttribute("email");
		session.removeAttribute("name");
		session.removeAttribute("id");
		session.removeAttribute("url");

		return "redirect:/index.htm";
	}

	@RequestMapping(value = "/my-account", method = RequestMethod.GET)
	public String myAccount(HttpServletRequest request, ModelMap model) {
		this.userModel = new UserModel(factory);
		HttpSession session = request.getSession();

		int idUser = (int) session.getAttribute("id");
		User user = this.userModel.get(idUser);

		model.addAttribute("user", user);
		return "client/my-account";
	}

	@RequestMapping(value = "/my-account", params = "btnUpdate", method = RequestMethod.POST)
	public String myAccount(ModelMap model, @Validated @ModelAttribute("user") User user, BindingResult errors) {
		if (errors.hasErrors()) {
			System.out.print(errors);
			return "client/error404";
		}

		this.userModel = new UserModel(factory);
		if (this.userModel.updateUser(user)) {
			return "client/my-account";
		}

		return "client/error404";
	}

	@RequestMapping(value = "/my-account", params = "btnChangePassword", method = RequestMethod.POST)
	public String changePassword(ModelMap model) {
		return "client/change-password";
	}

	@RequestMapping(value = "/change-password", params = "btnConfirm", method = RequestMethod.POST)
	public String changePassword(HttpServletRequest request, ModelMap model, @RequestParam("password") String password,
			@RequestParam("newPassword") String newPassword, @RequestParam("newCPassword") String newCPassword) {

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		if (newPassword != "" && newPassword.equals(newCPassword)) {
			this.userModel = new UserModel(factory);
			if (this.userModel.login(email, password) != null) {
				this.userModel.updatePasswordUser(email, newPassword);
				return "client/login";
			} else {
				model.addAttribute("message", "Passsword Incorrect");
				return "client/change-password";
			}
		}

		model.addAttribute("message", "Passsword Not Match");
		return "client/change-password";
	}

	@RequestMapping(value = "/change-password", params = "btnCancel", method = RequestMethod.POST)
	public String changePassword() {
		return "redirect:/my-account.htm";
	}

	@RequestMapping(value = "/send-email", method = RequestMethod.GET)
	public String sendEmail(ModelMap model) {
		return "client/email";
	}
	
	
	@RequestMapping(value = "/send-email", method = RequestMethod.POST)
	public String sendForgotPassword(ModelMap model, @RequestParam("email") String email)
	{	
		String html = "<a href='http://localhost:8080/DoAnCuoiKi/update-password.htm?email="+email+"'>Click me</a>";
		
		Mail mail=new Mail(mailer);
		mail.send(email, html, "Forgot Password");
		
		return "client/success2";
	}
	
	@RequestMapping(value = "/update-password", params = "email", method = RequestMethod.GET)
	public String updatePassword(ModelMap model,@RequestParam("email") String email) {
		this.userModel = new UserModel(factory);
		
		if (this.userModel.findByEmail(email) == null) {
			return "client/error404";
		}
		
		model.addAttribute("email", email);
		return "client/forgot-password";
	}

	@RequestMapping(value = "/update-password/{email}", params = "btnConfirm", method = RequestMethod.POST)
	public String forgetPassword(ModelMap model, @PathVariable("email") String email,
			@RequestParam("password") String password, @RequestParam("cPassword") String cPassword) {

		if (password != "" && cPassword.equals(cPassword)) {
			this.userModel = new UserModel(factory);
			User user = this.userModel.findByEmail(email);
			if (user == null) {
				return "client/error404";
			}

			this.userModel.updatePasswordUser(email, password);
			return "client/login";
		}

		model.addAttribute("message", "Password not math");
		return "client/forgot-password";
	}

	@RequestMapping(value = "/forgot-password/{id}", params = "btnCancel", method = RequestMethod.POST)
	public String forgetPassword(ModelMap model, @PathVariable("id") String email) {
		return "redirect:/index.htm";
	}
}
