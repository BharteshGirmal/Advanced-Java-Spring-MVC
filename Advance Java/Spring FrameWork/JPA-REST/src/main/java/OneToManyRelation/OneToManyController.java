package OneToManyRelation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneToManyController 
{	
	@Autowired
	StoryBookRepo brepo;

	@PostMapping("/addstory")
	public String AddStory()
	{
		StoryBook b= new StoryBook();
		b.setBookName("Rich Dad Poor Dad");
		b.setBookCost("500");
		b.setPublisherName("K&N Publications");
		
		List<Story> list= new ArrayList<Story>();
		Story s=new Story();
		s.setAuthor("Bhartesh");
		s.setStoryName("Tom and Jerry");
		s.setBook(b);
		list.add(s);
		
		Story s2=new Story();
		s2.setAuthor("ABCD");
		s2.setStoryName("Doremon");
		s2.setBook(b);
		list.add(s2);
		
		b.setStories(list);
		brepo.save(b);
		
		return ".................. Story added ..................";
	}
	
	@GetMapping("/show")
	public String GetStories()
	{
		StoryBook s = brepo.findById(11).get();
		return s.getBookName()+"  : "+s.getStories().get(0).getStoryName()+ " , "+s.getStories().get(1).getStoryName();
	}
}
