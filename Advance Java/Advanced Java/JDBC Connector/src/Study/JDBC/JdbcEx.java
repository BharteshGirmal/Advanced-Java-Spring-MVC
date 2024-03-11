package Study.JDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcEx 
{
	public static void main(String[] args) {

		Connection Connect=null;
		Statement Stmt=null;
		ResultSet set=null;
		PreparedStatement Pstmt=null;
		BufferedReader B= new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1" , "root","Bhartesh@1008");
			if(Connect !=null)
			{
				System.out.println(Connect);
				System.out.println("Connection sucessfull.......................");
				Stmt=Connect.createStatement();
				// Read Query
				set=Stmt.executeQuery("select * from Product1");
				while(set.next())
				{
					System.out.println("ID : "+set.getInt(1));
					System.out.println("Name : "+set.getNString(2));
					System.out.println("Cost : "+set.getInt(3));
				}
				
				// Update Query
				Pstmt=Connect.prepareStatement("update Product1 set name=? where id=?");
				System.out.println("Enter the Roll number to Modify");
				int roll=Integer.parseInt(B.readLine());
				System.out.println("Enter the name to set ");
				String name=B.readLine();
				Pstmt.setInt(2, roll);
				Pstmt.setString(1, name);
				Pstmt.executeUpdate();
				System.out.println("Record Updated .....................");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}

}
