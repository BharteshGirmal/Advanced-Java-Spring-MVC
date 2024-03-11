package study.jparest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"study.jparest.entity","study.jparest.repositary","study.controller"})
public class JpaRestEx1Application 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(JpaRestEx1Application.class, args);
	}
}
