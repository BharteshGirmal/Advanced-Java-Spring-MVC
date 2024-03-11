package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import study.beans.MessageBean;

public class Demo2 {

	public static void main(String[] args) {
		
	//SPRING CONTAINER Is initated --- it will read beans.xml
	//it will find bean info
	//it will create bean object
	//it set bean properties
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	MessageBean bean = (MessageBean)context.getBean("msg");
	System.out.println(bean.getMessage()+"  "+bean.getSenderName());	
		

	}

}
