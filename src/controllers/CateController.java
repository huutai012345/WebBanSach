package controllers;

import java.util.List;

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

import entity.Category;
import models.CategoryModel;

@Transactional
@Controller
@RequestMapping("admin/category")
public class CateController {
	@Autowired
	SessionFactory factory;
	
	private CategoryModel cateModel;

	@RequestMapping("index")
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Category";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list = query.list();
		model.addAttribute("datas", list);
		return "admin/category/index";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute(new Category());
		return "admin/category/insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(ModelMap model,@Validated @ModelAttribute("category") Category cate,BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
			return "admin/user/insert";
		}
		
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(cate);
			t.commit();
			model.addAttribute("message", "Success");
		} catch (Exception e) {
			t.rollback();
			System.out.println(e);
			model.addAttribute("message", "Fail");
		} finally {
			session.close();
		}
		
		return "redirect:/admin/category/index.htm";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(ModelMap model, @PathVariable("id") int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Category u WHERE u.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Category> list = query.list();

		model.addAttribute("category", list.get(0));
		return "admin/category/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(ModelMap model, @Validated @ModelAttribute("category") Category cate, BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
			return "admin/category/update";
		}
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(cate);
			t.commit();
			model.addAttribute("message", "Success");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Fail");
		} finally {
			session.close();
		}
		
		return "redirect:/admin/category/index.htm";

	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable("id") int id) {
		this.cateModel=new CategoryModel(factory);
		
		if(this.cateModel.checkDeleteCate(id))
		{
			this.cateModel.deleteCate(id);
			return "Success";
		}
		
		return "Categoy can not delete";
	
	}
}
