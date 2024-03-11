package HW;

public class Book 
{
	private String bookname , author ;
	private double price;

	public Book() 
	{
		System.out.println("Constructor of book class");
	}

	@Override
	public String toString() 
	{
		return "Book Name : "+bookname+"\nAuthor : "+author+"\nPrice : "+price;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
