package RestControllers;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/primary")
public class MyRestController
{
	
	public MyRestController() {
		System.out.println("MyRestController Constructor is get called");
	}
	
	@GetMapping("/hello")
	public String hello()
	{          
		return "Helllo From Get Rest Controller";
	}
	
	@PostMapping("/postit")
	public String hello2()
	{          
		return "Helllo From Post Rest Controller";
	}
	
	@DeleteMapping("/hello")
	public String hello3()
	{          
		return "Helllo From Delete Rest Controller";
	}
	
	@PutMapping("/hello")
	public String hello4()
	{          
		return "Helllo From Put Rest Controller";
	}
	

	//Query Parameters Example
	@PutMapping("/square")
	public int hello5(@RequestParam int num)
	{          
		return num*num;
	}
	
	//Path Parameter Example
	@PostMapping("sum/{n1}/{n2}/{n3}")
	public int Cube(@PathVariable("n1") int x , @PathVariable("n2") int y, @PathVariable("n3") int z)
	{
		
		return (x+y+z);
	}
	
	@GetMapping("/welcome")
	public String welcome(@RequestBody User uname)
	{
		return "Welcome ... "+ uname.getUname() + "  City : "+uname.getCity();
	}
	
	@GetMapping("/getusers")
	public ArrayList<User> getlist()
	{
		ArrayList<User> list = new ArrayList<User>();
		User u1=new User();
		u1.setUname("Doremon");
		u1.setCity("Japaan");
		list.add(u1);
		User u2=new User();
		u2.setUname("Nobita");
		u2.setCity("China");
		list.add(u2);
		
		return list;
	}
	
	
}
