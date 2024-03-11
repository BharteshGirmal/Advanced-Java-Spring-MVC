package HW1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
1. Write a flow as follows using Spring MVC
url = input  ==> show input page that accepts name , surname 
and dob and button-save [ the table birthday_tracker generates an Id automatically ]
    action = save  ==> save values in a table  and 
    show the ID generated for the newly inserted record*/
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("HW2")
public class HW1Application 
{

	public static void main(String[] args) {
		SpringApplication.run(HW1Application.class, args);
	}

}
