package Configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import Beans.AddressBean;
import Beans.MessageBean;

@Configuration
public class MyjavaConfig 
{
	@Bean(value="msg" )
	@Scope(value="prototype")
	//@Lazy
	public MessageBean GetMessageBean()
	{
		MessageBean bean= new MessageBean();
		bean.setMessage("This is from Java Configration");
		bean.setSendername("Doremon");
		bean.setReceiverAddress(GetAddress());
		return bean;
	}
	
	@Bean(value="msg2" )
	public MessageBean GetMessageBean2()
	{
		MessageBean bean= new MessageBean("This is from Java Config","Nobita",GetAddress());
		bean.setMessage("This is from Java Configration");
		return bean;
	}
	@Bean(value="Addr" )
	public AddressBean GetAddress()
	{
		AddressBean bean=new AddressBean();
		bean.setCity("Pune");
		bean.setState("MH");
		bean.setCountry("INDIA");
		bean.setLocation("KATRAJ");
		bean.setPin("14563");
		return bean;
	}
}
