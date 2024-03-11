package MVC;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyWebController 
{
	public MyWebController()
	{
		System.out.println("MyswebController is called . . . ");
	}
	
	@RequestMapping(value="/Hello" , method = RequestMethod.GET)
	public String Fun1()
	{
		System.out.println("Request Mapping is called . . . ");
		return "Hello";
	}
	
	@GetMapping(value = "/welcome")
	public String fun2(@RequestParam ("Uname") String name)
	{
		System.out.println("Server Got the name : "+name);
		return "Hi";
	}
	
	@GetMapping(value="/Input")
	public String fun3()
	{
		return "Input";
	}
	
	@PostMapping(value="/showtables")
	public String fun4(Model model,@RequestParam int num)
	{
		ArrayList<String> list=GenerateTable.GetTable(num);
		model.addAttribute("List",list);
		return "Table";
	}
	
	@GetMapping(value="/showchar")
	public ModelAndView fun5(ModelAndView mv , @RequestParam String line)
	{
		ArrayList<String> list= new ArrayList<>();
		for(int i=0;i<line.length();i++)
		{
			list.add(" "+line.charAt(i));
		}
		mv.addObject("List",list);
		mv.setViewName("Table");
		return mv;
	}
}
