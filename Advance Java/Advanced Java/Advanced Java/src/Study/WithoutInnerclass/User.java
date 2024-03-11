package Study.WithoutInnerclass;

public class User
{
	private int data2=50;
	Test1 obj=new Test1();
	public void Show()
	{
		System.out.println("data2: "+data2+"\ndata1: "+obj.getData());
	}
	
	public static void main(String[] args) {
		
		User obj= new User();
		obj.Show();
	}

}

class Test1
{
	private int data1=100;
	public int getData()
	{
		return data1;
	}
}
