package Study.JDBC.HW.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Client 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Scanner sc= new Scanner(System.in);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/db1";
		System.out.println("Enter the MySQL User Name");
		String Name=sc.next();
		System.out.println("Enter the Password");
		String Password=sc.next();
		
		Connection Connect=DriverManager.getConnection(url,Name,Password);
		System.out.println("Connection Sucessfull "+Connect);
		
		Statement stm=Connect.createStatement();
	
		int choice=0;
		do
		{
			System.out.println("Database Queries"
					+ "\n1.Insert into the table"
					+ "\n2.Update a Record from table"
					+ "\n3.Delete a Record From table"
					+ "\n4.Exit"
					+ "\nEnter Your choice");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the id");
				int id=sc.nextInt();
				System.out.println("Enter the Name");
				String name=sc.next();
				System.out.println("Enter the Cost");
				int cost=sc.nextInt();
				
				String sql="insert into Product1 values("+id+",'"+name+"',"+cost+")";
				stm.execute(sql);
				System.out.println("Record Inserted ...............");
				break;
			case 2: 
				System.out.println("Enter the ProductId Which you want to Update");
				int id1=sc.nextInt();
				System.out.println("Enter the New Name to Update with");
				String name2=sc.next();
				
				String sql2="update Product1 set name='"+name2+"' where id="+id1+"";
				stm.execute(sql2);
				System.out.println("Record Updated Sucessfully ......................");
				break;
			case 3: 
				System.out.println("Enter the Product id to delete the Record");
				int id3=sc.nextInt();
				
				String sql3="delete from Product1 where id="+id3+"";
				stm.execute(sql3);
				System.out.println("Record Deleted Sucessfully ...................");
				break;
			case 4: 
				System.exit(0);
				break;
			default :
				System.out.println("Invalid Choice");
				break;
			}
			
			
		}while(true);
	}

}

