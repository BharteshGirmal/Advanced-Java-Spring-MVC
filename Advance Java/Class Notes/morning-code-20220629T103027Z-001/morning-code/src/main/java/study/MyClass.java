package study;

import study.anno.MySticker;

@MySticker(value = "www",roll=23)
public class MyClass {
	
	//@MySticker(value="rrr",roll=23)
	public void f1()
	{
		System.out.println("f1");
		
	}
	
	//@MySticker(value="rrr",roll=23)
	public void f2()
	{
		System.out.println("f2");
	}

}
