package Part3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"Controllers","RestControllers","HW"})
public class ThymeleafApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(ThymeleafApplication.class, args);
	}

}
