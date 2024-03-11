package Study.Anonymous;

public class Task 
{
	public static void main(String[] args)
	{
		Fun obj= new Fun() {
			
			@Override
			public void DoTask3(int x) 
			{
				System.out.println(x);
			}
			
			@Override
			public String DoTask2() 
			{
				return "hello";
			}
			
			@Override
			public void DoTask1() 
			{
				System.out.println("In Task1");
			}
		};
		
		obj.DoTask1();
		System.out.println(obj.DoTask2());
		obj.DoTask3(50);
	}	
}

interface Fun
{
	void DoTask1();

	String DoTask2();
	
	void DoTask3(int x);
}
