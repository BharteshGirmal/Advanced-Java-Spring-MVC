package Study.laymdaExpression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamEx 
{
	static ArrayList<String> AL=new ArrayList<String>();
	public static void main(String[] args)
	{
		AL.add("Blue");
		AL.add("Black");
		AL.add("Brown");
		AL.add("sky Blue");
		AL.add("Baby Pink");
		AL.add("Beauty Gold");
		AL.add("White");
		AL.add("voilet");
		AL.add("Yellow");
		
		AL.stream().forEach((element)->{System.out.println("This is "+element);});
		AL.stream().forEach((e)->{System.out.println(e.toUpperCase());});
		
		//Stream<String> FilterStream =AL.stream().filter((ele)->{if(ele.length()< 5) return true, return false});
		
		System.out.println("After Filtering ");
		AL.stream().filter((ele)->{if(ele.length() > 5) return true ; else return false;}).forEach((e)->{System.out.println("Filterd Colour is "+e);});
		
		Stream<String> str1=AL.stream();
		Stream<String> str2=str1.filter((ele)->{if(ele.length() > 5)return true;else return false;});
		str2.forEach((E)->{System.out.println("Anather Filter "+E);});
		
		MyForEach((ele2)->{System.out.println("My For Each "+ele2);});
		
		
	}
	
	static void MyForEach(Consumer<String> obj)
	{
		for(int i=0;i<AL.size();i++)
		{
			obj.accept(AL.get(i));
		}
	}

}
