package OneToManyRelation;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class StoryBook 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int bookid ;
	@Column
	private String bookName;
	@Column
	private String bookCost;
	@Column
	private String publisherName;
	
	@OneToMany(mappedBy = "book" , cascade = CascadeType.ALL)
	private List<Story> stories;
	
	public List<Story> getStories() {
		return stories;
	}
	
	public void setStories(List<Story> stories) {
		this.stories = stories;
	}
	
	public StoryBook() {
		// TODO Auto-generated constructor stub
	}

	public StoryBook(int id, String bookName, String bookCost, String publisherName) {
		super();
		this.bookid = id;
		this.bookName = bookName;
		this.bookCost = bookCost;
		this.publisherName = publisherName;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookCost() {
		return bookCost;
	}

	public void setBookCost(String bookCost) {
		this.bookCost = bookCost;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	
}
