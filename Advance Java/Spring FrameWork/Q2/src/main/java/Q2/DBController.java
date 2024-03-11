package Q2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path ="/product" )
public class DBController 
{

	@Autowired
	JdbcTemplate template;

	@PostMapping("/add")
	public String Addbook2(@RequestParam String productname ,@RequestParam int productrating)
	{
		if(productrating>0 && productrating<=10)
		{
			template.update("insert into Product values(?,?) ",productname,productrating);
			return "Record Inserted .....";
		}
		else
			return "Rating is more than 10...";
	}


	@GetMapping("/getall") // on the browser side 
	public List<Product> getall(Model model)
	{	
		List<Product> list=template.query("select * from Product",(rs,rownum)->{return new Product(rs.getString(1),rs.getInt(2));});
		model.addAttribute("list",list);
		return list;
	}
}
