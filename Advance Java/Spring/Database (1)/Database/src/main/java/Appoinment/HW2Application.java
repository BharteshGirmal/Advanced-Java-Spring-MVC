package Appoinment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Beans.AccountBean;
import Beans.AddressBean;
import Beans.PersonBean;

public class HW2Application 
{
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();

		PersonBean bean1 = context.getBean("person",PersonBean.class);
		
		System.out.println(bean1.getName()+" "+bean1.getAge());
		
		AddressBean bean2 = context.getBean("addr",AddressBean.class);
		
		System.out.println(bean2.getCity()+" "+bean2.getPin());
	}
}
