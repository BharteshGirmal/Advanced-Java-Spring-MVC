package Study.Innerclass;

public class Test2 
{
	private int x=100;
	private static int y=200;
	
	
	static class inner // it does not get this of Outer class // Only Static Properties can be accessed
	{
		private int A=99;
		private static int B=99 ;
		
		public void Show()
		{
			System.out.println("X is not Available "+" y= "+y+" A="+A+" B="+B);
		}
	}
	
	public static void main(String[] args) {
		
		inner obj=new Test2.inner(); //OuterClassName.inner
		obj.Show();
	}

}
