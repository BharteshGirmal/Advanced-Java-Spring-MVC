package AOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AspectOrientedProgrammingAopApplication 
{

	public static void main(String[] args)
	{
		ConfigurableApplicationContext ctx =   SpringApplication.run(MyAspects.class, args);

		//caller
		AccountBean bean = ctx.getBean(AccountBean.class);

		System.out.println("the balance is  "+bean.getBalance());

		bean.Withdraw(1500);

		bean.Withdraw(2500);

	}

	@Bean
	public AccountBean f1()
	{
		AccountBean b = new AccountBean();
		b.setAccNo(123);
		b.setBalance(10000);
		return b;
	}
}


