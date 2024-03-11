package Study.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionEx 
{

	public static void main(String[] args) throws ClassNotFoundException
	{
		// 3 ways to class Class Object 
		//1. ==> if you know the class name while writting the code 
		Class C1= String.class;
		//2. ==>if you Dont know the class name while writting the code
		Class C2=Class.forName("java.lang.String");
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the class Name");
		Class C4=Class.forName(sc.next());
	
		//3. ==>when you have object of class but dont know the class name
		String s= new String("Hello");
		Class C3=s.getClass();
		
		Thread s1= new Thread();
		Class C5=s1.getClass(); 
		
		// to know the Fields of class 
		
		Field[] fields =C4.getDeclaredFields();
		for(Field f:fields)
			System.out.println(f.getName()+" , "+f.getType());
		
		// to know the Methods of class 
		
				Method[] method =C4.getDeclaredMethods();
				for(Method m:method)
					System.out.println(m.getName()+" , "+m.getReturnType());
				
		// getting the MetaData
		System.out.println(C1.getName());
		System.out.println(C2.getName());
		System.out.println(C3.getName());
		System.out.println(C4.getName());
	}

}
