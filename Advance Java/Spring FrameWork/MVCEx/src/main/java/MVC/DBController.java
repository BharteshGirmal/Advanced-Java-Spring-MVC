package MVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DBController
{
	@Autowired
	JdbcTemplate template;
	
	@GetMapping(value="/add")
	public String fun1(@RequestParam int pid, @RequestParam String pname, @RequestParam int cost)
	{
		template.update("insert into product1 values(?,?,?)",pid,pname,cost);
		return "Hello";
	}
}
