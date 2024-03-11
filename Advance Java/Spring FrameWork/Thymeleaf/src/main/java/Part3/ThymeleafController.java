package Part3;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


public class ThymeleafController 
{	
		public ThymeleafController() 
		{
			System.out.println("theyemleafController is get called");
		}
		
		@GetMapping("/thyeleaf")
		public String  Thyemleaf(Model m, @RequestParam String name)
		{
			if(name.equals("Bhartesh"))
			return "First.html";
			else
				m.addAttribute("name",name);
				return "Second.html";
		}
		
		@GetMapping("/showchar")
		public ModelAndView F5(ModelAndView mv, @RequestParam String line)
		{
			ArrayList<String> List =new ArrayList<>();
			for(int i=0;i<line.length();i++)
			{
				List.add(" "+line.charAt(i));
			}
			mv.addObject("list",List);
			mv.setViewName("Testchar.html");
			return mv; 
		}
		
	

}
