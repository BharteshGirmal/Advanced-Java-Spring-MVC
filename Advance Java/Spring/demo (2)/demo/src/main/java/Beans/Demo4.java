package Beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Configration.MyjavaConfig;

public class Demo4 
{
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext( MyjavaConfig.class ) ;
		MessageBean bean= context.getBean("msg2" ,MessageBean.class);

		System.out.println(bean.getMessage()+"  Sender : "+bean.getSendername());
		System.out.println("City of Reciever : "+bean.getReceiverAddress().getCity());

		MessageBean bean2= context.getBean("msg3" ,MessageBean.class);

		System.out.println(bean2.getMessage()+"  Sender : "+bean2.getSendername());
		System.out.println("City of Reciever : "+bean2.getReceiverAddress().getCity());

	}

}
