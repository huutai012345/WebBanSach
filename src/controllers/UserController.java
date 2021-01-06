package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Order;
import entity.User;
import entity.UserForm;
import models.OrderModel;
import models.UserModel;

@Transactional
@Controller
@RequestMapping("admin/user")
public class UserController {
	@Autowired
	SessionFactory factory;
	private String name;
	private UserModel userModel; 
	private OrderModel orderModel; 

	@RequestMapping("index")
	public String index(ModelMap model,HttpServletRequest request) {
		HttpSession session1=request.getSession();
		this.name=(String) session1.getAttribute("name");
				
		Session session = factory.getCurrentSession();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		model.addAttribute("datas", list);
		model.addAttribute("name", this.name);
		return "admin/user/index";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute(new UserForm());
		model.addAttribute("name", this.name);
		return "admin/user/insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(ModelMap model,@Validated @ModelAttribute("userForm") UserForm userForm,BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
			return "admin/user/insert";
		}
		
		if(!userForm.getConfirmPassword().equals(userForm.getUser().getPassword()))
		{
			errors.rejectValue("confirmPassword","userForm", "Confirm password not match");
			return "admin/user/insert";
		}
		
		User user=userForm.getUser();
		this.userModel=new UserModel(factory);
		this.orderModel=new OrderModel(factory);
		
		this.userModel.insert(user);
		this.orderModel.insertOrder(new Order(user));
		
		return "redirect:/admin/user/index.htm";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(ModelMap model, @PathVariable("id") int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM User u WHERE u.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();

		model.addAttribute("user", list.get(0));
		return "admin/user/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(ModelMap model, @Validated @ModelAttribute("user") User user, BindingResult errors) {
		
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
			return "admin/user/update";
		}
		if(user.getPassword()==null || user.getPassword().equals(""))
		{
			model.addAttribute("message", "Vui lòng nhập password !");
			return "admin/user/update";
		}
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(user);
			t.commit();
			model.addAttribute("message", "Success");
		} catch (Exception e) {
			t.rollback();
			System.out.println(e);
			model.addAttribute("message", "Fail");
		} finally {
			session.close();
		}
		
		return "redirect:/admin/user/index.htm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable("id") int id) {
		this.userModel=new UserModel(factory);
		this.orderModel=new OrderModel(factory);
		
		if(this.userModel.checkDeleteUser(id))
		{
			this.orderModel.deleteOrderByUser(id);
			this.userModel.delete(id);
			return "Success";
		}
		return "User can not delete";
	}
}
