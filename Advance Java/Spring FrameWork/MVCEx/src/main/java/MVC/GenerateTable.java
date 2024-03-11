package MVC;

import java.util.ArrayList;
import java.util.Iterator;

public class GenerateTable
{
	public static ArrayList<String> GetTable(int n)
	{
		ArrayList<String> list = new ArrayList<>();
		for (int i = 1; i <=10; i++) 
		{
			String s=n+"*"+i+" = "+n*i;
			list.add(s);
		}
		return list;
	}
}
