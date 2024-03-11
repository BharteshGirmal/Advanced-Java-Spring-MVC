package Study.Anonymous;

public class ThreadEx
{
	public static void main(String[] args) {
	
	Runnable Task1=new Runnable()
	{
		@Override
		public void run() 
		{
			for(int i=0;i<10;i++)
				System.out.println("Hello");	
		}
	};
	
	// First Thread
	
	new Thread(Task1).start();
	
	// Second thread
	
	new Thread(new Runnable() {
		
		@Override
		public void run() {
			for(int i=0;i<20;i++)
				System.out.println("Hii");
			
		}
	}).start();
	
	}
}
