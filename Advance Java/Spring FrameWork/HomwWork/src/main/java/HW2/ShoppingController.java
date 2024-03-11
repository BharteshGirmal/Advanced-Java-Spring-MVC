package HW2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingController 
{
	public ShoppingController() {
		System.out.println("ShoppingController Constructor is get called ");
	}
	
	@GetMapping("/addproduct")
	public String fun1()
	{
		
		return "Product";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/additem")
	public ModelAndView add(ModelAndView mv,HttpServletRequest request,@RequestParam String item)
	{
		HttpSession session=request.getSession();
		ArrayList<String> list =null;
		if(session.getAttribute("list") == null )
		{
			System.out.println("New Session ....");
			list=new ArrayList<String>();
			//taking the product names from the browser and add it in the list
			list.add(item);
			session.setAttribute("list", list);
		}
		else
		{
			list=(ArrayList<String>)session.getAttribute("list");
			list.add(item);
			session.setAttribute("list", list);
		}
		
		mv.addObject("list",list);
		mv.setViewName("Product");
		return mv;
	}
}
