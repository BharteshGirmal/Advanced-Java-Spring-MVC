package Appoinment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Beans.ProductBean;

public class HW1Application 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		ProductBean bean1 = context.getBean("msg",ProductBean.class);

		System.out.println(bean1.getName()+" "+bean1.getDescription()+" "+bean1.getCost());

		ProductBean bean2 = context.getBean("msg",ProductBean.class);
		bean2.setCost(1000);
		System.out.println(bean2.getName()+" "+bean2.getDescription()+" "+bean2.getCost());
	}

}
