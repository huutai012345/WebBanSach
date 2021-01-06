package controllers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Category;
import entity.Order;
import entity.OrderDetail;
import models.BookModel;
import models.OrderModel;

@Transactional
@Controller
@RequestMapping("admin/order-detail")
public class OrderDetailController {
	@Autowired
	SessionFactory factory;
	private OrderModel orderModel;
	private BookModel bookModel;

	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public String index(ModelMap model, @PathVariable("id") int id) {
		this.orderModel=new OrderModel(factory);
		
		Order order=this.orderModel.get(id);
		List<OrderDetail> list=this.orderModel.getOrderDetail(id);
		
		
		model.addAttribute("datas", list);
		model.addAttribute("id", id);
		model.addAttribute("status", order.getStatus());
		return "admin/order-detail/index";
	}
	
	@RequestMapping(value = "/insert", params="cate", method = RequestMethod.GET)
	public String insert(ModelMap model, @RequestParam("cate") int id) {
		this.orderModel=new OrderModel(factory);
		Order order=this.orderModel.get(id);
		model.addAttribute(new OrderDetail(order));
		return "admin/order-detail/insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @Validated @ModelAttribute("orderDetail") OrderDetail orderDetail,BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
			return "admin/order-detail/insert";
		}
		
		this.bookModel=new BookModel(factory);
		this.orderModel=new OrderModel(factory);
		
		
		int numBook= this.bookModel.getBook(orderDetail.getBook().getId()).getAmount();
		if(numBook<orderDetail.getAmount())
		{
			model.addAttribute("message", "Không Đủ Số Lượng Vật Tư !");
			return "admin/order-detail/insert";
		}
		
		this.bookModel.updateAmountBook(orderDetail.getBook().getId(), - orderDetail.getAmount());
		
		if(this.orderModel.checkExistOrderDetail(orderDetail.getBook().getId(), orderDetail.getOrder().getId()))
		{
			this.orderModel.insertOrderDetail(orderDetail);
		}
		else
		{
			this.orderModel.updateAmount1(orderDetail.getBook().getId(), orderDetail.getOrder().getId(),orderDetail.getAmount());
		}
		
		return "redirect:/admin/order-detail/index/"+orderDetail.getOrder().getId()+".htm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable("id") int id) {
		
		try {
			this.orderModel=new OrderModel(factory);
			this.bookModel=new BookModel(factory);
			OrderDetail orderDetail=this.orderModel.getOrderDetail1(id);
			
			this.orderModel.deleteOrderDetail(id);
			this.bookModel.updateAmountBook(orderDetail.getBook().getId(), orderDetail.getAmount());
		} catch (Exception e) {
			model.addAttribute("message", e);
		}
		
		return "Success";
	}
	
	@ModelAttribute("books")
	public List<Category> getAllCate()
	{
		Session session=factory.getCurrentSession();
		String hql="FROM Book";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list=query.list();
		return list;	
	}
}
