package Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BookBean
{
	private String BookName;
	private double Price;
	
	@Autowired
	private PublisherBean publisher;
	
	public BookBean() 
	{
		setPrice(215.81);
		setBookName("Advanced Java");
		System.out.println();
		System.out.println("BookBean Constructor . . . ");
	}
	
	public BookBean(String bookName, double price)
	{
		super();
		System.out.println("BookBean Constructor of 2 Parameters is called ");
		BookName = bookName;
		Price = price;
	}

	//@Autowired // DI= Dependancy Injection 
	public BookBean(PublisherBean publisher) 
	{
		super();
		BookName="Advanced Java";
		Price=1255.16;
		this.publisher = publisher;
		System.out.println("BookBean Constructor with 1 Parameter PublisherBean");
	}

	
	
	public PublisherBean getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherBean publisher) {
		this.publisher = publisher;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}
	
	
}
