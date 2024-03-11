package Study.laymdaExpression;

public class LaymdaEx
{

	public static void main(String[] args)
	{
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				while(true)
				{
					System.out.println("Hello");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Thread T1= new Thread(r1);
		T1.start();

		Runnable r2 = ()-> {
			while(true)
			{
				System.out.println("Hiee");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Thread T2= new Thread(r2);
		T2.start();

	}

}
