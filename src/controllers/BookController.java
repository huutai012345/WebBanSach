package controllers;

import java.util.List;

import javax.servlet.ServletContext;

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
import org.springframework.web.multipart.MultipartFile;

import entity.Book;
import entity.BookForm;
import entity.Category;
import library.UploadImg;
import models.BookModel;

@Transactional
@Controller
@RequestMapping("admin/book")
public class BookController {
	@Autowired
	SessionFactory factory;
	private BookModel bookModel; 
	
	@RequestMapping("index")
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Book";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Book> list = query.list();
		model.addAttribute("datas", list);
		return "admin/book/index";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute(new BookForm());
		return "admin/book/insert";
	}
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(ModelMap model,@Validated @ModelAttribute("bookForm") BookForm bookForm,BindingResult errors) {
		if (errors.hasErrors()) {
			return "admin/book/insert";
		}
		
		MultipartFile img=bookForm.getImg();
		UploadImg upload=new UploadImg(img);
		if(!upload.check())
		{
			model.addAttribute("message", "Format Fail Or File Is empty !");
			return "admin/book/insert";
		}
		
		try {
			this.bookModel =new BookModel(factory);
			bookForm.getBook().setImg(upload.update());
			this.bookModel.insert(bookForm.getBook());
		}
		catch(Exception e)
		{
			model.addAttribute("message", e);
			return "admin/book/insert";
		}
		
		return "redirect:/admin/book/index.htm";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(ModelMap model, @PathVariable("id") int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Book u WHERE u.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Book> list = query.list();

		model.addAttribute("bookForm", new BookForm(list.get(0)));
		return "admin/book/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(ModelMap model, @Validated @ModelAttribute("bookForm") BookForm bookForm, BindingResult errors) {
		if (errors.hasErrors()) {
			return "admin/book/update";
		}
		
		try {
			MultipartFile img=bookForm.getImg();
			UploadImg upload=new UploadImg(img);
			if(!upload.check())
			{
				this.bookModel=new BookModel(factory);
				bookForm.getBook().setImg(this.bookModel.getBook(bookForm.getBook().getId()).getImg());
			}
			else
				bookForm.getBook().setImg(upload.update());
			
			this.bookModel =new BookModel(factory);
			this.bookModel.update(bookForm.getBook());
		}
		catch(Exception e)
		{
			model.addAttribute("message", e);
			return "admin/book/update";
		}
		
		return "redirect:/admin/book/index.htm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable("id") int id) {
		
		this.bookModel=new BookModel(factory);
		if(this.bookModel.checkDeleteBook(id))
		{
			Session session = factory.openSession();
			String hql = "DELETE FROM Book WHERE id = :id";
			
			Transaction t = session.beginTransaction();
			try {
				Query query = session.createQuery(hql);
				query.setParameter("id", id).executeUpdate();
				
				t.commit();
				model.addAttribute("message", "Success");
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Fail");
			} finally {
				session.close();
				
			}
			
			return "Success";
		}
		
		return "Book can not delete";
	}
	
	@ModelAttribute("cates")
	public List<Category> getAllCate()
	{
		Session session=factory.getCurrentSession();
		String hql="FROM Category";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list=query.list();
		return list;	
	}
	
}
