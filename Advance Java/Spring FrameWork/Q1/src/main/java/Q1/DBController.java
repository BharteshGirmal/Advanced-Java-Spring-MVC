package Q1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DBController
{
	@Autowired
	JdbcTemplate template;
	
	@GetMapping("/input")
	public String f1()
	{
		return "Input";
	}
	
	@GetMapping(value="/add")
	public String fun1(@RequestParam String fname, @RequestParam String lname, @RequestParam String address)
	{
		template.update("insert into user(firstname,lastname,address) values(?,?,?)",fname,lname,address);
		return "output";
	}
}
