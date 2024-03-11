package study.container;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import study.MyClass;
import study.anno.MySticker;

public class SimpleContainer {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		MyClass obj = new MyClass();
		
		Class cls = obj.getClass();
		Method[] methods = cls.getMethods();
		
		for(Method m: methods)
		{
			if(m.getName().equals("f1") ||m.getName().equals("f2") )
			{
				if(m.isAnnotationPresent(MySticker.class))
				{
					System.out.println(m.getName()+" was called on "+new Date());
				}
				m.invoke(obj);
			}
				
				
				
		}
		
		
		
		
		  

	}

}
