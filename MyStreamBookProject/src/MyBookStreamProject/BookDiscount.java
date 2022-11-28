package MyBookStreamProject;

/**
 *
 * @author vic
 * date: 21/11/2022
 * purpose: Book Discount Class
 *
 */
public class BookDiscount {

	private Book book;
	private double discount;
	
	public BookDiscount() {
		
	}

	public BookDiscount(Book book, double discount) {
		super();
		this.book = book;
		this.discount = discount;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "BookDiscount [book=" + book + ", discount=" + discount + "]";
	}
}
