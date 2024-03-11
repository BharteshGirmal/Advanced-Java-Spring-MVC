package RestAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/*1. Write a REST CONTROLLER having controller level mapping /maths

GET    /maths/factorial?num= give value  response = factorial of that number
GET   /maths/table/{ofnum}/{from}/{to}        response  =   coma separated table Ex table of 2 from 1 to 5  =  2,4,6,8,10
GET   /maths/isPrime/{num}     response =  The number 7 is prime    /  The number 8 is not prime*/


import org.springframework.web.bind.annotation.RestController;

@RestController
public class HW1Controller 
{
	public HW1Controller() 
	{
		System.out.println("Controller Constructor is get called ");
	}


	// Factorial .....................................
	@GetMapping("/factorial")
	public int Fact(@RequestParam int num)
	{
		int fact=1;
		for(int i=1;i<=num;i++)
		{
			fact=fact*i;
		}
		return fact;
	}

	// Table Printing ..................................
	@PostMapping("table/{num}/{from}/{to}")
	public String Table(@PathVariable("num") int num1 , @PathVariable("from") int from , @PathVariable("to") int to)
	{
		int table=0;
		String res="";
		for(int i=from;i<=to;i++)
		{
			table=num1*i;
			res=res+" ,"+table;
		}
		return res;
	}

	// Prime number ................................
	@GetMapping("prime/{n1}")
	public String Prime(@PathVariable("n1") int num)
	{
		boolean flag=true;
		if(num==0 || num==1)
		{
			flag=false;
		}
		if(num!=0 && num!=1)
		{
			for(int i=2;i<=num/2;i++)
			{
				if((num%i)==0)
				{
					flag=false;
				}
			}
		}
		if(flag==true)
		{
			return "number "+num+" is a prime number";
		}
		else
		{
			return "number "+num+" is not a prime number";
		}
	}
}
