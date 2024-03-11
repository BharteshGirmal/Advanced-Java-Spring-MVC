package Part2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan("Controller")
@ImportResource({"classpath:beans.xml","classpath:config.xml"})
// to search the xml files in resources

public class Mvc2Application 
{

	public static void main(String[] args)
	{
		SpringApplication.run(Mvc2Application.class, args);
	}

}
