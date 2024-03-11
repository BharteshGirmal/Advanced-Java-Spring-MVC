package Study.Anonymous;

public class Task 
{
	public static void main(String[] args)
	{
		I1 obj= new I1() 
		{
			@Override
			public void DoTask2(int x)
			{
				System.out.println(x);	
			}

			@Override
			public void DoTask1()
			{
				System.out.println("In Task1");	
			}

			@Override
			public String DoTask3()
			{
				return "Hiie";	
			}
		} ;
		
		obj.DoTask1();
		System.out.println(obj.DoTask3());
		obj.DoTask2(20);
	}
}

interface I1
{
	void DoTask1();

	void DoTask2(int x);
	
	String DoTask3();
}
