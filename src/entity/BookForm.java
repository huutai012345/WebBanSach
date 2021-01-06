package entity;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

public class BookForm {
	@Valid
	private Book book;
	
	private MultipartFile img;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}
	
	public BookForm(Book book) {
		this.book=book;
	}
	
	public BookForm() {
	}
}
