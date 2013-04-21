package cs1635.group.booksharing;

public class BookData {
	long id;
	String isbn;
	String author;
	String title;
	String price;
	String subject;
	String seller;
	
	public BookData(long id, String isbn, String title, String author, String subject, String price, String seller) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.isbn = isbn;
		this.author = author;
		this.subject = subject;
		this.seller = seller;
	}
}
