package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.User;

@Transactional
@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("index")
	public String index(ModelMap model) {
		
		return "admin/index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String email= (String)session.getAttribute("email");
		
		if( email == null )
		{
			return "admin/login";
			
		}
		return "redirect:/admin/index.htm";
	
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ModelMap model, @RequestParam("email") String email,@RequestParam("password") String password,HttpServletRequest request) {
		
		Session session = factory.getCurrentSession();
		String hql = "FROM User u WHERE u.email = :email AND u.password=:password";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("password", password);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		if(list.isEmpty())
		{
			model.addAttribute("message","Login Fail: account or password is incorrect");
			return "admin/login";
		}
		
		if(!list.get(0).getRole().equals("admin"))
		{
			model.addAttribute("message","Login Fail: account unauthorized");
			return "admin/login";
		}
		
		HttpSession session1=request.getSession();
		session1.setAttribute("email", email);
		session1.setAttribute("role", list.get(0).getRole());
		session1.setAttribute("name", list.get(0).getName());
		session1.setAttribute("id", list.get(0).getId());
		return "redirect:/admin/index.htm";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("email");
		session.removeAttribute("name");
		session.removeAttribute("id");
		session.removeAttribute("url");
		
		return "redirect:/admin/login.htm";
	}
	
}
