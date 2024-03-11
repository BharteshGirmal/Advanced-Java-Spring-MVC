package Controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DBController implements ApplicationContextAware
{
	public DBController()
	{
		System.out.println("DBController Constructor is get called ...");
	}
	
	@GetMapping("/add")
	public String fun1(@RequestParam int id , @RequestParam String name, @RequestParam int cost)
	{
		JdbcTemplate template= context.getBean(JdbcTemplate.class);
		template.update("insert into product1 values(  ?,?,?)",id,name,cost);
		return "hello";
	}
	
	ApplicationContext context;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		context=applicationContext;
	}
}
