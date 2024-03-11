package Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import Beans.AddressBean;
import Beans.PersonBean;

@Configuration
public class MyJavaConfig 
{
	@Bean(value="person")
	@Scope(value="prototype")
	public PersonBean getPerson()
	{
		PersonBean bean = new PersonBean();
		bean.setName("Bhartesh");
		bean.setAge(24);
		bean.setReciveAddress(getAddress());
		
		return bean;
	}
	
	@Bean(value="addr")
	public AddressBean getAddress()
	{
		AddressBean bean = new AddressBean();
		bean.setCity("Kolhapur");
		bean.setPin(123456);
		return bean;
	}
}
