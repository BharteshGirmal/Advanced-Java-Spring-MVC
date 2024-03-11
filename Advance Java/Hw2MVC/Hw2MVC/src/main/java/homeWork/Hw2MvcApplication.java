package homeWork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"controllers","classes"})
public class Hw2MvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hw2MvcApplication.class, args);
	}

}
