package Study.VARARGS;

public class VarArgsEx
{

	public static void main(String[] args) 
	{
		sum(50);
		sum(10,20,30,40,50);
		Holidays("May",21,22,23);
	}
	
	static void sum(int ... Num) // ... VarArgs
	{
		int total=0;
		for (int i = 0; i < Num.length; i++) 
		{
			total+=Num[i];
		}
		System.out.println("Total : "+total);
	}
	
	static void Holidays(String Month,int ... days)
	{
		System.out.println("Holidays for the Month "+Month+" are");
		for(int day:days)
			System.out.println("Day : "+day);
	}

}
