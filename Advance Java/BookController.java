package study.HW;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/bookcont")
public class BookController 
{	
	@Autowired
	JdbcTemplate template;
	
	
		
		@GetMapping("/show")
		public List<Book> getDetails()
		{

			List<Book> list=template.query("select * from book",(rs,rownum)->{
				return new Book(rs.getString(1),rs.getString(2),rs.getDouble(3));
			});

			return list;

		}
		
		@GetMapping("/show/{name}")
		public List<Book> getBooknames(@PathVariable String name)
		{

			List<Book> list=template.query("select * from book where bname='"+name+"'",(rs,rownum)->{
				return new Book(rs.getString(1),rs.getString(2),rs.getDouble(3));
			});

			return list;

		}
		
		@GetMapping("/author")
		public List<String> getauthornames()
		{
				List<String> str=new ArrayList<String>();
				ArrayList<Book> al = (ArrayList<Book>) getDetails();
				for (Book book : al)
				{
					str.add(book.getAuthor());
				}
				return str;

		}
		
		@PostMapping("add/{name}/{auth}/{price}")
		public String f(@PathVariable("name") String bname,@PathVariable("auth") String author,@PathVariable("price") int cost)
		{	
			template.update("insert into book values(?,?,?)",bname,author,cost);
			return "inserted";
		}

		
	
	/*
	 * @GetMapping("/book") public ArrayList<Book> book() { ArrayList<Book> al=new
	 * ArrayList<Book>();
	 * 
	 * kBook b= new Boo();
	 * b.setBookName("SPRING FRAMEWORK WITH JAVA-A PRACTICAL APPROACH");
	 * b.setAuthor("B. Mohamed Ibrahim"); b.setCost(350.00);
	 * 
	 * Book b1= new Book(); b1.setBookName("Head First Java");
	 * b1.setAuthor("Kathy Sierra, Bert Bates"); b1.setCost(755.80);
	 * 
	 * al.add(b); al.add(b1); return al;
	 * 
	 * }
	 */
}
