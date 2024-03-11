package RestAPI;

public class Book 
{
	private String bookname , author ;
	private int cost;

	public Book() 
	{
		System.out.println("Constructor of book class");
	}

	
	
	public Book(String bookname, String author, int cost) {
		super();
		this.bookname = bookname;
		this.author = author;
		this.cost = cost;
	}



	@Override
	public String toString() 
	{
		return "Book Name : "+bookname+"\nAuthor : "+author+"\nPrice : "+cost;
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	

}
