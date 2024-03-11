package Beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo5 
{
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		
		context.scan("Beans" , "some.other");
		
		context.refresh();
		
		BookBean bean=context.getBean(BookBean.class);
		
		System.out.println(bean.getBookName()+"    "+bean.getPrice()+" Publisher : "+bean.getPublisher().getName());
	}

}
