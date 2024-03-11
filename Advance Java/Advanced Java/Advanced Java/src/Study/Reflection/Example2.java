package Study.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Example2 
{

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException, InstantiationException, NoSuchMethodException, SecurityException, InvocationTargetException {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the class Name");
		Class<?> c1= Class.forName(sc.next());
		System.out.println("The class "+c1.getName());
		
		//Object obj =c1.newInstance();
		Field[] Properties=c1.getDeclaredFields();
		
		Constructor<?> ctor=c1.getDeclaredConstructor(null);// Parameterless Constructor
		Object obj1= ctor.newInstance();
		
		Constructor<?> ctor2=c1.getDeclaredConstructor(String.class,int.class);// Parameterized Constructor
		Object obj2= ctor2.newInstance("NewYearCelebration",100);
		
		for(Field Property:Properties)
		{
			Property.setAccessible(true);
			//System.out.println(Property.getName() +" : "+Property.get(obj)); 
			System.out.println(Property.getName() +" : "+Property.get(obj1));
			System.out.println(Property.getName() +" : "+Property.get(obj2)); 
		}
		
		//System.out.println("Enter the method name to call ");
		//Method C2= C2.getDeclaredAnnotations(sc.next());
		
		
	}
}

class SocialEvent
{
	private String EventName;
	private int NoOfPeople;
	
	public SocialEvent()
	{
		EventName="Birthday party";
		NoOfPeople=19;
	}
	
	public SocialEvent(String eventName, int noOfPeople)
	{
		super();
		EventName =eventName;
		NoOfPeople = noOfPeople;
	}
	
	
	@Override
	public String toString() 
	{
		return "Event Name : "+EventName+"\n No of Peoples : "+NoOfPeople;
	}
	
	
}
