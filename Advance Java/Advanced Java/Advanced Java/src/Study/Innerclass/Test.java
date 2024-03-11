package Study.Innerclass;

public class Test
{
	public int data1=100;
	private int Common=200; // this is Property of Test
	
	public void Display()
	{
		//Outer class Implicitly creates the object of inner class
		System.out.println("Data 1: "+data1+"\n Data 2: "+new User().data2);
	}
	
	class User
	{
		private int data2=102;
		private int common=202;
		
		public void Show() {
			// inner class is directly or implicitly using the private property of outer class
			System.out.println("Using inner class Data 2: "+data2+"\ndata 1: "+data1);
			System.out.println("Commmon of outer class : "+Test.this.Common+"\n Common of inner class : "+this.common);
		}
	}// end of inner class User
	
	public static void main(String[] args) 
	{
		Test obj= new Test();
		User S=	obj.new User();
		
		S.Show();
		
	}// end of main

}// end of Outer class Test
