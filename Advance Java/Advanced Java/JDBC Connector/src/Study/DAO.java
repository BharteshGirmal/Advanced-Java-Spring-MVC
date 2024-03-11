package Study;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO // Data Access Object
{
	public Connection MyGetConnection()
	{
		Connection Con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/db1";
			String Uname="root";
			String Pass="Bhartesh@1008";
			Con= DriverManager.getConnection(url,Uname,Pass);
		}
		catch (ClassNotFoundException  | SQLException s) 
		{
			System.out.println("Connection Not Done ....");

		}
		return Con;
	}

	public ResultSet GetRows(String sql)
	{
		Connection con =MyGetConnection();
		ResultSet RS=null;
		Statement stmt=null;

		try {
			stmt=con.createStatement();
			RS=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return RS;
	}
	
	public void ShowResultSet(ResultSet rs)
	{
		try {
			while(rs.next())
			{
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int cost=rs.getInt("price");
				
				System.out.println("ID : "+id+"\nName : "+name+"\nCost : "+cost);
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void AddProduct(int id ,String name,int price)
	{
		Connection con=MyGetConnection();
		PreparedStatement Pstmt;
		try {
			Pstmt = con.prepareStatement("insert into Product1 values(?,?,?)");
		
		Pstmt.setInt(1, id);
		Pstmt.setString(2, name);
		Pstmt.setInt(3, price);
		Pstmt.executeUpdate();
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void UpdatCost(int price ,int id)
	 {
		Connection con=MyGetConnection();
		PreparedStatement Pstmt;
		try {
			Pstmt = con.prepareStatement("update  Product1 set price=? where id=?");
		
		Pstmt.setInt(2, id);
		Pstmt.setInt(1, price);
		Pstmt.executeUpdate();
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	
	public void GetStoredProcedure()
	{
		Connection con= MyGetConnection();
		try {
			CallableStatement cstmt=con.prepareCall("call hi()");
			ResultSet rs=cstmt.executeQuery();
			rs.next();
			String msg=rs.getString("Message");
			System.out.println("You got : "+msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void GetName()
	{
		Connection con= MyGetConnection();
		try {
			CallableStatement cstmt=con.prepareCall("call hi()");
			ResultSet rs=cstmt.executeQuery();
			rs.next();
			String msg=rs.getString("Message");
			System.out.println("You got : "+msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
