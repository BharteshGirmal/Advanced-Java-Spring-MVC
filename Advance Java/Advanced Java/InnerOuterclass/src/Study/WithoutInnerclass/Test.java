package Study.WithoutInnerclass;

public class Test // outer class 
{
	private int data1=100; 
	
	class User
	{
		private int data2=200;
	
		public void show()
		{
			System.out.println("Data1: "+data1+"\nData2: "+data2);
			// inner class  method is directly using the private property of the outer class
		}
	}// end of user class
		
	public static void main(String[] args)
	{
		Test obj= new Test();
		User X=obj.new User(); // obj.new User() ===> this.
		X.show();
		
	}
}// end of test class 

