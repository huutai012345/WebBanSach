package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.User;
import library.Mail;
import entity.Book;
import entity.Order;
import entity.OrderDetail;
import models.BookModel;
import models.CategoryModel;
import models.OrderModel;
import models.UserModel;

@Transactional
@Controller
public class ClientController {
	@Autowired
	SessionFactory factory;
	
	private UserModel userModel;
	private BookModel bookModel;
	private CategoryModel cateModel;
	private OrderModel orderModel;

	@RequestMapping("index")
	public String home(ModelMap model) {
		this.bookModel = new BookModel(factory);
		this.cateModel = new CategoryModel(factory);
		model.addAttribute("newBooks", bookModel.getNewBook(4));
		model.addAttribute("sellers", bookModel.getBooks(8));

		return "client/index";
	}
	
	@RequestMapping("shop")
	public String shop(ModelMap model) {
		this.bookModel = new BookModel(factory);
		this.cateModel = new CategoryModel(factory);
		
		List<Book> books=bookModel.getAllBook();
		model.addAttribute("datas", books);
		model.addAttribute("cates", cateModel.getCate());
		model.addAttribute("cates1", cateModel.getListCountCate());
		model.addAttribute("total",books.size());
		return "client/shop";
	}
	
	@RequestMapping(value="shop",params="page")
	public String shop(ModelMap model,@RequestParam("page") int page) {
		this.bookModel = new BookModel(factory);
		this.cateModel = new CategoryModel(factory);
		
		int start=(page-1)*9;
		Long count=this.bookModel.getCountBook();
		Long numPage=count/9;
		if(count%9!=0)
		{	
			numPage++;
		}
		
		long end = start + 9;
		if(count<start+9)
		{
			end = count;
		}
		
		List<Book> books=bookModel.getListBookByPage(start);
		model.addAttribute("datas", books);
		model.addAttribute("cates", cateModel.getCate());
		model.addAttribute("cates1", cateModel.getListCountCate());
		model.addAttribute("total",count);
		model.addAttribute("sumBook",count);
		model.addAttribute("page",numPage);
		model.addAttribute("start",start+1);
		model.addAttribute("end",end);
		return "client/shop";
	}
	
	@RequestMapping(value="shop/{id}",params="page")
	public String bookByCate(ModelMap model,@PathVariable("id") int id,@RequestParam("page") int page) {
		this.bookModel = new BookModel(factory);
		this.cateModel = new CategoryModel(factory);
		
		int start=(page-1)*9;
		Long count=this.bookModel.getCountBookByCate(id);
		Long sumBook=this.bookModel.getCountBook();
		Long numPage=count/9;
		if(count%9!=0)
		{	
			numPage++;
		}
		
		long end = start + 9;
		if(count<start+9)
		{
			end = count;
		}
		
		List<Book> books=bookModel.getBookByCate(id, start);
		model.addAttribute("datas", books);
		model.addAttribute("cates", cateModel.getCate());
		model.addAttribute("cates1", cateModel.getListCountCate());
		model.addAttribute("total",count);
		model.addAttribute("sumBook",sumBook);
		model.addAttribute("page",numPage);
		model.addAttribute("start",start+1);
		model.addAttribute("end",end);
		return "client/shop";
	}
	
	@RequestMapping(value="shop",params="search")
	public String search(ModelMap model,@RequestParam("search") String search) {
		this.bookModel = new BookModel(factory);
		this.cateModel = new CategoryModel(factory);
		
		int page=1;
		int start=(page-1)*9;
		Long count=this.bookModel.getCountBookBySearch(search);
		Long numPage=count/9;
		if(count%9!=0)
		{	
			numPage++;
		}
		
		long end = start + 9;
		if(count<start+9)
		{
			end = count;
		}
		
		List<Book> books=bookModel.search(search,start);
		model.addAttribute("datas", books);
		model.addAttribute("cates", cateModel.getCate());
		model.addAttribute("cates1", cateModel.getListCountCate());
		model.addAttribute("total",count);
		model.addAttribute("sumBook",count);
		model.addAttribute("page",numPage);
		model.addAttribute("start",start+1);
		model.addAttribute("end",end);
		model.addAttribute("search",search);
		return "client/shop";
	}
	
	@RequestMapping(value="shop/{id}",params="search")
	public String searchCate(ModelMap model,@PathVariable("id") int id,@RequestParam("search") String search) {
		this.bookModel = new BookModel(factory);
		this.cateModel = new CategoryModel(factory);
		
		int page=1;
		int start=(page-1)*9;
		Long count=this.bookModel.getCountBookBySearchCate(search, id);
		Long numPage=count/9;
		if(count%9!=0)
		{	
			numPage++;
		}
		
		long end = start + 9;
		if(count<start+9)
		{
			end = count;
		}
		
		List<Book> books=bookModel.searchByCate(id, search,start);
		model.addAttribute("datas", books);
		model.addAttribute("cates", cateModel.getCate());
		model.addAttribute("cates1", cateModel.getListCountCate());
		model.addAttribute("total",count);
		model.addAttribute("sumBook",count);
		model.addAttribute("page",numPage);
		model.addAttribute("start",start+1);
		model.addAttribute("end",end);
		model.addAttribute("search",search);
		return "client/shop";
	}
	
	@RequestMapping("single-product/{id}")
	public String singleProduct(ModelMap model,@PathVariable("id") int id) {
		this.bookModel = new BookModel(factory);
		this.cateModel = new CategoryModel(factory);
		
		List<Book> books=bookModel.getAllBook();
		model.addAttribute("books", books);
		model.addAttribute("cates", cateModel.getCate());
		model.addAttribute("cates1", cateModel.getListCountCate());
		model.addAttribute("book", bookModel.getBook(id));
		return "client/single-product";
	}
	
	@ResponseBody
	@RequestMapping(value="update-product/{id}",params="amount", method = RequestMethod.GET)	
	public String updateAmountProduct(HttpServletRequest request,ModelMap model,@PathVariable("id") int id,@RequestParam("amount") int amount) {
		this.orderModel=new OrderModel(factory);
		this.bookModel=new BookModel(factory);
		HttpSession session=request.getSession();
		
		int idUser=(int)session.getAttribute("id");
		int orderId=this.orderModel.getOrderByUser(idUser).getId();
		OrderDetail orderDetail=this.orderModel.getOrderDetail1(id,orderId);
		Book book=this.bookModel.getBook(id);
		
		if(amount - orderDetail.getAmount()> book.getAmount())
		{
			return "Not enough quantity";
		}
		
		this.bookModel.updateAmountBook(id, orderDetail.getAmount()-amount);
		this.orderModel.updateAmount(id, orderId, amount);
		
		double total = this.orderModel.getTotalOrder(idUser);
		List<OrderDetail> listOrderDetail = this.orderModel.getOrderDetailByUser(idUser);
		
		model.addAttribute("datas", listOrderDetail);
		model.addAttribute("total", total);
		
		return "success";
	}
	
	@RequestMapping("cart")
	public String cart(HttpServletRequest request,ModelMap model) {
		this.orderModel=new OrderModel(factory);
		
		HttpSession session=request.getSession();
		int idUser=(int)session.getAttribute("id");
		int idOrder=this.orderModel.getOrderByUser(idUser).getId();
		
		List<OrderDetail> orderDetail = this.orderModel.getOrderDetailByUser(idUser);
		double total = this.orderModel.getTotalOrder(idOrder);
		
		model.addAttribute("datas", orderDetail);
		model.addAttribute("total", total);
		return "client/cart";
	}
	
	@RequestMapping("history")
	public String history(HttpServletRequest request,ModelMap model) {
		this.orderModel=new OrderModel(factory);
		
		HttpSession session=request.getSession();
		int idUser=(int)session.getAttribute("id");
		
		List<OrderDetail> orderDetail = this.orderModel.getOrderDetailHistoryByUser(idUser);
		
		model.addAttribute("datas", orderDetail);
		return "client/history";
	}
	
	@ResponseBody
	@RequestMapping(value="add-cart/{id}",params="amount", method = RequestMethod.GET)
	public String addCart(HttpServletRequest request, ModelMap model,@PathVariable("id") int bookId,@RequestParam("amount") int amount) {
		this.orderModel=new OrderModel(factory);
		this.bookModel=new BookModel(factory);
		
		HttpSession session=request.getSession();
		Book book=this.bookModel.getBook(bookId);
		int idUser=(int)session.getAttribute("id");
		Order order = orderModel.getOrderByUser(idUser);
		if(book.getAmount()<amount)
		{
			return "Not enough quantity";
		}
		
		if(this.orderModel.checkExistOrderDetail(bookId, order.getId()))
		{
			OrderDetail orderDetail =new OrderDetail(amount, order, book);
			this.orderModel.insertOrderDetail(orderDetail);
		}
		else
		{
			this.orderModel.updateAmount1(bookId, order.getId(), amount);
		}
		this.bookModel.updateAmountBook(bookId, -amount);
		
		return "success";
	}
	
	@RequestMapping(value="cart/delete/{id}",params={"book","num"},method = RequestMethod.GET)	
	public String deleteCart(HttpServletRequest request,ModelMap model,@PathVariable("id") int id,@RequestParam("num") int num,@RequestParam("book") int bookId) {
		this.orderModel=new OrderModel(factory);
		this.bookModel=new BookModel(factory);
		
		if(this.orderModel.deleteOrderDetail(id))
		{	
			this.bookModel.updateAmountBook(bookId, num);
			
			HttpSession session=request.getSession();
			
			int idUser=(int)session.getAttribute("id");
			double total = this.orderModel.getTotalOrder(idUser);
			List<OrderDetail> orderDetail = this.orderModel.getOrderDetailByUser(idUser);
			
			model.addAttribute("datas", orderDetail);
			model.addAttribute("total", total);
			
			return "client/cart";
		}	
		
		return "client/error404";
	}
	
	@ResponseBody
	@RequestMapping(value="buy-now/{id}",params="amount", method = RequestMethod.GET)
	public String buyNow(HttpServletRequest request,ModelMap model,@PathVariable("id") int bookId,@RequestParam("amount") int amount) {
		this.orderModel=new OrderModel(factory);
		this.bookModel=new BookModel(factory);
		
		HttpSession session=request.getSession();
		Book book=this.bookModel.getBook(bookId);
		int idUser=(int)session.getAttribute("id");
		Order order = orderModel.getOrderByUser(idUser);
		if(book.getAmount()<amount)
		{
			return "Not enough quantity";
		}
		
		if(this.orderModel.checkExistOrderDetail(bookId, order.getId()))
		{
			OrderDetail orderDetail =new OrderDetail(amount, order, book);
			this.orderModel.insertOrderDetail(orderDetail);
		}
		else
		{
			this.orderModel.updateAmount1(bookId, order.getId(),amount);
		}
		this.bookModel.updateAmountBook(bookId, -amount);
		
		return "1";
	}
	
	@RequestMapping("checkout")
	public String checkout(HttpServletRequest request,ModelMap model) {
		this.orderModel=new OrderModel(factory);
		
		HttpSession session=request.getSession();
		int idUser=(int)session.getAttribute("id");
		int idOrder=this.orderModel.getOrderByUser(idUser).getId();
		
		List<OrderDetail> orderDetail = this.orderModel.getOrderDetailByUser(idUser);
		double total = this.orderModel.getTotalOrder(idOrder);
		
		if(orderDetail.isEmpty())
		{
			return "client/error404";
		}
		else
		{
			model.addAttribute("datas", orderDetail);
			model.addAttribute("totalOrder", total);
			model.addAttribute("total", total+30000);
			return "client/checkout";
		}
		
	}
	
	@Autowired
	JavaMailSender mailer;
	
	@RequestMapping("checkedout")
	public String checkedOut(HttpServletRequest request,ModelMap model) {
		this.orderModel=new OrderModel(factory);
		this.userModel= new UserModel(factory);
		
		HttpSession session=request.getSession();
		int idUser=(int)session.getAttribute("id");
		String email=(String)session.getAttribute("email");
		int idOrder=orderModel.getOrderByUser(idUser).getId();
		User user = this.userModel.get(idUser);
		
		if(this.orderModel.updateStatusOrder(idOrder)){
			this.orderModel.insertOrder(new Order(user));
		
			Mail mail= new Mail(mailer);
			mail.send(email, "", "Order Success");
			
			return "client/success";
		}
		
		return "client/index";
		
	}
	
	@RequestMapping("ordered")
	public String ordered(ModelMap model) {
		return "client/success";
	}
	
	@RequestMapping("about")
	public String abount(ModelMap model) {
		return "client/about";
	}
}
