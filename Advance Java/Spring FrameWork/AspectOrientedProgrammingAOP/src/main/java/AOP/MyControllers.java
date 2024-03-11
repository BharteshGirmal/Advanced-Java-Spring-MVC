package AOP;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyControllers 
{
	@GetMapping("/hello")
	public String f1()
	{
		return "............................. Hello .............................";
	}
}
