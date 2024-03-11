package RestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"restControllers","RestAPI"})
public class RestProjecthw2Application {

	public static void main(String[] args) {
		SpringApplication.run(RestProjecthw2Application.class, args);
	}

}
