package Beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo2
{
	public static void main(String[] args) 
	{
		// Spring container is initiated -----> 
		//it reads the beans.xml and 
		//find the bean information
		// it will create the bean object
		// it sets the bean Property
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");

		// MessageBean bean=(MessageBean) context.getBean("msg");

		// anther method doint need to typecast
		MessageBean bean1=context.getBean("msg",MessageBean.class);

		System.out.println(bean1.getMessage()+"\n"+bean1.getSendername());

		MessageBean bean2=context.getBean("msg",MessageBean.class);

		System.out.println(bean2.getMessage()+"\n"+bean2.getSendername());
		
		bean1.setSendername("INDIA");
		System.out.println("After Changing the bean1");
		System.out.println(bean1.getMessage()+"\n"+bean1.getSendername());
		System.out.println(bean2.getMessage()+"\n"+bean2.getSendername());
		
		
		// Multiton pattern of instantiation
	}

}
