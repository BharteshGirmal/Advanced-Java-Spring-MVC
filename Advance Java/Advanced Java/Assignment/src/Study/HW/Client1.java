/*
1. Write a Java client that gives following Menu
	Do it using study.hw.DAO + PrepareStatement 
	Write main class as study.hw.Client3

	1. update name of a given id
	2. update cost of given id
	3. update both name and cost of given id
	4. delete a record of given
	5. show only the info of row of given id
	6. quit*/


package Study.HW;
import java.util.Scanner;

public class Client1 
{
	static String name=null;
	static int id;
	static int cost;
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		int choice=0;

		do
		{
			System.out.println("Select the Following Query"
					+ "\n1.update name of a given id"
					+ "\n2.update cost of given id"
					+ "\n3.update both name and cost of given id"
					+ "\n4.delete a record of given Value"
					+ "\n5.show only the info of row of given id"
					+ "\n6.Show All Details"
					+ "\n0.Exit"
					+ "\nEnter Your choice");
			choice=sc.nextInt();

			switch(choice)
			{
			case 1:
				System.out.println("Enter the Name to Update");
				name=sc.next();
				System.out.println("Enter the Id");
				id=sc.nextInt();
				DAO.UpdateName(name, id);
				break;
			case 2:
				System.out.println("Enter the Id");
				id=sc.nextInt();
				System.out.println("Enter the Cost to Update");
				cost=sc.nextInt();
				DAO.UpdateCost(cost, id);
				break;
			case 3:
				System.out.println("Enter the Name to Update");
				name=sc.next();
				System.out.println("Enter the cost to Update");
				cost=sc.nextInt();
				System.out.println("Enter the Id");
				id=sc.nextInt();
				DAO.UpdateBoth(name, cost, id);
				break;
			case 4:
				int ch=0;
				System.out.println("Select the following Refrence to delete the Record"
						+ "\n1.Name"
						+ "\n2.Cost"
						+ "\n3.id"
						+ "\nEnter your choice");
				ch=sc.nextInt();
				switch(ch)
				{
				case 1:
					System.out.println("Enter the Name");
					name=sc.next();
					DAO.DeleteByName(name);
					break;
				case 2:
					System.out.println("Enter the Cost");
					cost=sc.nextInt();
					DAO.DeleteByCost(cost);
					break;
				case 3:
					System.out.println("Enter the id");
					id=sc.nextInt();
					DAO.DeleteByID(id);
					break;
				default:
					System.out.println("Invalid Choice......");
					break;
				}
				break;
			case 5:
				System.out.println("Enter the id show the details ");
				id=sc.nextInt();
				DAO.ShowDetailsByID(id);
				break;
			case 6:
				DAO.ShowDetails();
				break;
			case 0:
				System.exit(0);
				break;
			default :
				System.out.println(".......... Invalid choice ..........");
				break;
			}

		}while(true);
	}
}
