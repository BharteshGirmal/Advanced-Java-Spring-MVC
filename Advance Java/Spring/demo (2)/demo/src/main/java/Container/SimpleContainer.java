package Container;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import Anotation.MySticker;
import Study.MyClass;

public class SimpleContainer
{
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		MyClass obj= new MyClass();
		
		Class cls=obj.getClass();
		
		Method[] method=cls.getDeclaredMethods();
		
		for(Method m: method)
		{
			if(m.getName().equals("Fun1") || m.getName().equals("Fun2") )
			{
				if(m.isAnnotationPresent(MySticker.class))
				{
					System.out.println(m.getName()+" is called on Date : "+ new Date());
				}
				m.invoke(obj);
			}
			
		}
	}
}
