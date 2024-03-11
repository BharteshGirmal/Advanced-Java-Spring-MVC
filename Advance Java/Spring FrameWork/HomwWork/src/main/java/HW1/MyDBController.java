package HW1;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Bean.BirthdayDO;

@Controller
public class MyDBController 
{
	@Autowired
	JdbcTemplate template;

	public MyDBController()
	{
		System.out.println("myDbController is get called ");
	}

	// HW1 .............
	@RequestMapping(value="/hw1Input", method = RequestMethod.GET)
	public String fun1()
	{
		return "hw1Input";
	}

	@GetMapping(value="/addbirthday")
	public String fun1(Model model, @RequestParam String fname, @RequestParam String sname, @RequestParam String dob)
	{
		template.update("insert into Birthday(Firstname,Surname,DateOfBirth) values(?,?,?)",fname,sname,dob);
		List<BirthdayDO> list = template.query("select id from Birthday where Firstname='"+fname+"' and Surname='"+sname+"'",(rs,rownum)->{ return new BirthdayDO(rs.getInt(1));});
		System.out.println(list);
		model.addAttribute("list",list);
		return "hw1Output";
	}

	//HW2 ...................
	@GetMapping(value = "/hw2Login")
	public String Login()
	{
		return "hw2Login";
	}

	@GetMapping(value = "/hw2Check")
	public String Check(Model request, HttpServletRequest req)
	{
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		if(uname!=null && uname.equals("Bhartesh")&& pass!=null && pass.equals("1234"))
		{
			return "hw2Check";
		}
		else
		{
			request.addAttribute("msg", "Invalid Username Or Password");
			return "hw2Login";
		}
	}

	//HW3 .................
	@GetMapping("/birthdate")
	public String date()
	{
		return "hw3search";
	}
	
	@GetMapping("/date")
	public String search(Model model , @RequestParam String dob1,@RequestParam String dob2)
	{
		List<BirthdayDO> list=template.query("select Firstname ,Surname,DateOfBirth from Birthday where DateOfBirth between '"+dob1+"' and '"+dob2+"' ", (rs,rownum)->{ return new BirthdayDO(rs.getString(1),rs.getString(2),rs.getString(3));});
		model.addAttribute("list",list);
		return "hw3date";
	}
}

