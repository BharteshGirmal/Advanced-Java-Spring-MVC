package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController 
{
	public MyController() 
	{
		System.out.println("MyController is get called ...");
	}

	int count=0;
	@GetMapping("/Counter")
	public ModelAndView count(HttpServletRequest request, ModelAndView mv)
	{
		int ucount=0;
		HttpSession session=request.getSession();
		if(session.isNew())
		{
			ucount=1;
			session.setAttribute("ucount", ucount);
		}
		else
		{
			ucount=(Integer)session.getAttribute("ucount");
			ucount++;
			session.setAttribute("ucount", ucount);
		}
		mv.addObject("sessioncount",++count);
		mv.setViewName("counter");
		return mv;
	}
}
