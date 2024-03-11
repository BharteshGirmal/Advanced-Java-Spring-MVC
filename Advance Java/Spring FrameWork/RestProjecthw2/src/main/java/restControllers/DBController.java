package restControllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import RestAPI.Book;
@CrossOrigin
@RestController
@RequestMapping(path ="/book" )
public class DBController 
{
	
	@Autowired
	JdbcTemplate template;
	
	public DBController() 
	{
		System.out.println("Rest Controller Constructor is get Called ... ");
	}
	
	//1. GET  /book/getAll      show JSON array of all books in the DB table book
	@GetMapping("/getAll")
	public List<Book> getall()
	{	
		List<Book> list=template.query("select * from Book",(rs,rownum)->{return new Book(rs.getString(1),rs.getString(2),rs.getInt(3));});
		return list;
	}
	
	//2.  GET   /book/get/{bookname}      show JSON array of all books having name given by bookName
	@GetMapping("get/{Bookname}")
	public List<Book> Bookname(@PathVariable("Bookname") String name)
	{
		List<Book> BL=template.query("select * from Book where bookname='"+name+"'",(rs,rownum)->{return new Book(rs.getString(1),rs.getString(2),rs.getInt(3));});
		return BL;
	}
	
	//3. GET  /book/allAuthors     show coma separated list of all the authors in the db table 
	@GetMapping("/Allauthors")
	public List<String> getAuthors()
	{
		List<String> list=new ArrayList<String>();
		ArrayList<Book> AL=(ArrayList<Book>)getall();
		for(Book  book : AL)
		{
			list.add(book.getAuthor());
		}
		return list;
	}
	
	
	//4. POST  /book/add     Pass the book Info as RequestBody and  INSERT row in DB
	@PostMapping("add/{name}/{author}/{cost}")
	public String Addbook(@PathVariable("name") String bname ,@PathVariable("author") String bauthor,@PathVariable("cost")int bcost )
	{
		template.update("insert into Book values(?,?,?) ",bname,bauthor,bcost);
		return "Record Inserted";
	}
	
	@PostMapping("/addbybody")
	public String Addbook2(@RequestBody Book user )
	{
		template.update("insert into Book values(?,?,?) ",user.getBookname(),user.getAuthor(),user.getCost());
		return "Record Inserted";
	}
	
	//5. PUT    /book/changename/{bookName}    update bookName to new name
	@PutMapping("/changename/{}")
	public String updatename(@PathVariable String bookname)
	{
		template.update("update table Book set bookname='"+bookname+"' where author=");
		return "Record Updated ... ";
	}
	
	//6. PUT    /book/changename/{oldbookName}/{newbookName}    update oldbookName to new name in DB
	@PutMapping("changename/{oldbbokname}/{newbookname}")
	public String changename(@PathVariable("oldbookname") String oldbookname , @PathVariable("newbookname") String newbookname)
	{
		template.update("update table Book set bookname='"+newbookname+"' where bookname='"+oldbookname+"'");
		return "Record Updated ...........";
	}
	
	//7.PUT    /book/changecost/{bookName/bookCost}    update bookCost for all books with book name  in DB
	@PutMapping("chanagecost/{bookname}/{bookcost}")
	public String changecost(@PathVariable("bookname") String bookname , @PathVariable("bookcost") int cost)
	{
		template.update("update table Book set cost='"+cost+"' where bookname='"+bookname+"'");
		return "cost Updated sucessfully ..............";
	}
	
	//8. DELETE   /book/deletebyname/{bookName}    delete all books with given name from the DB
	@DeleteMapping("deletebyname/{bookname}")
	public String DeleteBookname(@PathVariable String bookname)
	{
		template.update("delete from table Book where bookname='"+bookname+"'");

		return "Record Deleted .........";
	}
	
}
