package Appoinment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Beans.AccountBean;

public class HW3Application 
{
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("Bean");
		context.refresh();
		
		AccountBean bean1=context.getBean(AccountBean.class);
		bean1.setAcctNo(123454);
		bean1.setAcctBal(54154);
		System.out.println("Bean1 : Account No : "+bean1.getAcctNo()+"  Account Balance : "+bean1.getAcctBal());
		
		AccountBean bean2=context.getBean(AccountBean.class);
		bean2.setAcctNo(3518854);
		bean2.setAcctBal(15464);
		System.out.println("Bean2 : Account No : "+bean2.getAcctNo()+"  Account Balance : "+bean2.getAcctBal());
		
	}
}
