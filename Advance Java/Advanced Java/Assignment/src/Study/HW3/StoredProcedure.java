
/*
3.  Write the getName stored procedure with IN and OUT parameter as discussed in class .
	call the procedure through JAVA as discussed in class*/

package Study.HW3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcedure 
{
	public static void main(String[] args) {
		ResultSet rs=DAO.GetRows("select * from Product1");
		DAO.ShowResultSet(rs);
		
		// show all the record from the table that table have cost less than 600
		ResultSet rs2=DAO.GetRows("select * from product1 where price < 600");
		DAO.ShowResultSet(rs2);
		
		DAO.CallProcedureHi();
	}

}

class DAO
{
	public static Connection GetConnection() 
	{
		Connection Con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/db1";
			String Uname="root";
			String Pass="Bhartesh@1008";
			Con = DriverManager.getConnection(url,Uname,Pass);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Con;
	}
	
	public static void CallProcedureHi()
	{
		Connection con=GetConnection();
		try {
			CallableStatement Cmt=con.prepareCall("call hi()");
			ResultSet rs=Cmt.executeQuery();
			rs.next();
			String msg=rs.getString("message");
			System.out.println("You Got "+msg+" Message");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static ResultSet GetRows(String sql)
	{
		Connection con=GetConnection();
		ResultSet rs=null;
		try {
			Statement stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}
	
	public static void ShowResultSet(ResultSet rs)
	{
		try {
			while(rs.next())
			{
				int Pid=rs.getInt("id");
				String Name=rs.getString("name");
				int price=rs.getInt("price");
				System.out.println("ID : "+Pid+"\nName : "+Name+"\nPrice : "+price);
				System.out.println("--------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
