package Study.laymdaExpression;

public class LaymdaEx2
{

	public static void main(String[] args) {
		
		fun1 obj1=()-> { System.out.println("Test T1"); };
		fun2 obj2=(p1,p2)-> {System.out.println("The values "+"\np1= "+p1+"\ny= "+p2);};
		
		obj1.m1();
		obj2.m2(true, 102);
		obj2.m2(false, 1055);
		
		//Student stud= obj3.process(25);
		//System.out.println(stud);
		
		test(obj1); // first way to call
		test(()->{System.out.println("Anather way to print using Laymbda Expression");}); // 2nd way to call
	}
	
	public static void test(fun1 obj)
	{
		obj.m1();
	}
}

@FunctionalInterface // to use the laymbda expresion it should have exactly one functional interface
interface fun1
{
	void m1();
}

interface fun2
{
	void m2(boolean x, int y);
}

/*interface fun3
{
	Student process(int x);
}*/