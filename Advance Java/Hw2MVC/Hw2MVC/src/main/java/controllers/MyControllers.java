package controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyControllers {

	
	public MyControllers()
	{
		System.out.println("Controller from controllers package");
	}
	
	@GetMapping("/inputitem")
	public String getInput()
	{
		return "firstPage";
	}
	
	
	@SuppressWarnings("unchecked")
	@PostMapping("/save")
	public ModelAndView getSave(ModelAndView mv,HttpServletRequest request, @RequestParam("product") String str)
	{
		
		System.out.println(""+str);
		
		ArrayList<String> al=new ArrayList<String>();
		HttpSession session = request.getSession();
		
		if(session.isNew())
		{
			System.out.println("i m here in if");
			al.add(str);
			session.setAttribute("arr", al);
		}
		else
		{
			System.out.println("i m here in else");
			al = (ArrayList<String>) session.getAttribute("arr");
			al.add(str);
			session.setAttribute("arr", al);
		}
		
		mv.addObject("arr",al);
		mv.setViewName("msg");
		return mv;
	}
	
	
}
