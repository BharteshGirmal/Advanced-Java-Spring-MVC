package Beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo6 
{
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");

		/*
		 * MessageBean bean= context.getBean("msg3", MessageBean.class); // giving the
		 * bean id
		 * 
		 * System.out.println("Message :  "+bean.getMessage()+"  SenderName: "+bean.
		 * getSendername()+"  City: "+bean.getReceiverAddress().getCity()
		 * +" State : "+bean.getReceiverAddress().getState());
		 */

		MessageBean bean2= context.getBean("msg5", MessageBean.class); // giving the bean id 

		System.out.println("Message :  "+bean2.getMessage()+"  SenderName: "+bean2.getSendername()+"  City: "+bean2.getReceiverAddress().getCity()
				+" State : "+bean2.getReceiverAddress().getState());
	}
}
