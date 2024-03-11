package Study;

import Anotation.MySticker;

@MySticker(value="SpringbootTool" , num=100)
public class MyClass
{
	@MySticker(value="Anoation" , num=200)
	public void Fun1()
	{
		System.out.println("Function 1");
	}
	
	@MySticker(value="Anoation" , num=200)
	public void Fun2()
	{
		System.out.println("Function 2");
	}
}
