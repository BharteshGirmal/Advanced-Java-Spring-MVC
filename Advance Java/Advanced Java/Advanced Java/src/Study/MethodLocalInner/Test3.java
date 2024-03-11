package Study.MethodLocalInner;

public class Test3
{
	int alpha=88;
	public void Method1()
	{
		final int x=100;
		int y=200;
		
		// inner class
		class LocalClass
		{
			int z=99;
			public void Show()
			{
				System.out.println("Z= "+z+" X= "+x+" y= "+y+" alpha= "+alpha);
			}
		}// end of localclass 
	}
	
	public static void main(String[] args) 
	{	
	
	}// end of main
}
