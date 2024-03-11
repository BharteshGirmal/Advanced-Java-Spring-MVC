

/*4. create account table as discussed in class
	try out the JDBCTxExample as discussed in class
 */


package Study.HW4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Account 
{
	public static void main(String[] args) throws SQLException
	{
		Connection con=DataAcessObject.ConnectToServer();
		PreparedStatement Pstmt=con.prepareStatement("update account set Balance=? where AccNo=?");
		try 
	
		{
			con.setAutoCommit(false);
			Pstmt.setInt(1, 5555);
			Pstmt.setString(2, "A");
			if(Pstmt.executeUpdate() == 0)
			{
				throw new SQLException();
			}
			System.out.println("First Query Suceed ...........");
			//succeeds but not committed 

			Pstmt.setInt(1, 4545);
			Pstmt.setString(2, "D"); // Wrong Account no to Fail the Query.
			 //if account number is wrong then it will change the record but should not commit the record.
			if(Pstmt.executeUpdate() == 0)
			{
				throw new SQLException();
			}
			System.out.println("Second Query Suceed ...........");
			System.out.println("Sucessed And Comitted ................");
			con.commit();
		}
		catch (SQLException e)
		{
			System.out.println("Failed to Execute hence Rollback");
			con.rollback();
		}

	} // end of main

}// end of class 


 class DataAcessObject
{
	public static Connection ConnectToServer()
	{
		Connection con=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/db1";
			String Name="root";
			String Password="Bhartesh@1008";
			con=DriverManager.getConnection(url,Name,Password);
			System.out.println(".................... Connection Sucessfull ....................");
		}
		catch
		(ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Credentials Doesn't Matches");
		}

		return con;

	}// end of connectToServer
}// end of class



