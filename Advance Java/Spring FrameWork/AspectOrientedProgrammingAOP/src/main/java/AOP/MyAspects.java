package AOP;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Component
public class MyAspects 
{

	//@Pointcut("execution(void study.aop.beans.AccountBean.withdraw(..))")
	public void thismethod() {}
	
	//@Pointcut("execution(* study.aop.beans.*.*(..))")
	public void thatmethod() {}
	
	//@Pointcut("execution(* study.aop.controllers.MyController.f1())")
	public void ctrlmethod() {}
	
	
	//@Before("ctrlmethod()")
	public void doSmthing()
	{
		System.out.println("REQUEST COMING TO F1....");
	}
	
	
	//@Before("thismethod()")
	public void doThis()
	{
		System.out.println("WARNING  YOUR ACCOUNT HAS A WITHDRAWAL REQUEST ----");
	}
	
	
	//@Before("thatmethod()")
	public void doThat()
	{
		System.out.println("NOTIFICATION  -YOUR ACCOUNT IS ACCESSED ....");
	}
	
	//@After("thismethod()")
	public void doThisAlso()
	{
		System.out.println("THANKS FOR BANKING WITH US..");
	}
	
	
	//@Around("thismethod()") //ProceedingJoinPoint jp
	public Object always()
	{
		Object obj=null;
		System.out.println("Your function starts now.."); //LOGGING  
		
		//check for authentication
		//synchronized(this) {
		try {
			//transactioion.begin();
			//obj = jp.proceed();  //calling the function  !!!
			//commit transaction
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("Your function ends here...");
		return obj;
	}
}
