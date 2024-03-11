package Beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo3 
{
	public static void main(String[] args) {

		ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");

		MessageBean bean = context.getBean("msg",MessageBean.class);

		System.out.println(bean.getMessage()+"Sender : "+bean.getSendername());
		System.out.println("City of Reciever : "+bean.getReceiverAddress().getCity());

		MessageBean bean2= context.getBean("msg2" ,MessageBean.class);

		System.out.println(bean2.getMessage()+"  Sender : "+bean2.getSendername());
		System.out.println("City of Reciever : "+bean2.getReceiverAddress().getCity());

		// Auto Wire example by type 
		MessageBean bean3= context.getBean("msg4" ,MessageBean.class);

		System.out.println(bean3.getMessage()+"  Sender : "+bean3.getSendername());
		System.out.println("City of Reciever : "+bean3.getReceiverAddress().getCity());

		// Auto Wire example by Name 
		MessageBean bean4= context.getBean("msg5" ,MessageBean.class);

		System.out.println(bean4.getMessage()+"  Sender : "+bean4.getSendername());
		System.out.println("City of Reciever : "+bean4.getReceiverAddress().getCity());
	}

}
