package Study.HW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO 
{
	public static Connection GetMyConnection()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String URL="jdbc:mysql://localhost:3306/db1";
			String UserName="root";
			String Password="Bhartesh@1008";
			con=DriverManager.getConnection(URL,UserName,Password);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return con;
	}

	public static void ShowDetails()
	{
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement Pstmt=null;
		con=GetMyConnection();
		
		try {
			Pstmt=con.prepareStatement("select * from Product1");
			rs=Pstmt.executeQuery();
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

	public static void UpdateName(String name, int id )
	{
		Connection con=GetMyConnection();
		PreparedStatement Pstmt=null;

		try {
			Pstmt=con.prepareStatement("update Product1 set name=? where id=?");
			Pstmt.setInt(2, id);
			Pstmt.setString(1, name);
			Pstmt.executeUpdate();
			System.out.println(".................... Record Updated Sucessfully ....................");

		} 
		catch (SQLException e)
		{
			System.out.println("Table Not Found in DataBase...............");
		}


	}

	public static void UpdateCost(int id , int cost)
	{
		Connection con=GetMyConnection();
		PreparedStatement Pstmt=null;

		try {
			Pstmt=con.prepareStatement("update Product1 set price=? where id=?");
			Pstmt.setInt(1, cost);
			Pstmt.setInt(2, id);
			Pstmt.executeUpdate();
			System.out.println(".................... Record Updated Sucessfully ....................");

		} 
		catch (SQLException e)
		{
			System.out.println("Table Not Found in DataBase...............");
		}

	}

	public static void UpdateBoth(String name , int cost,int id)
	{
		Connection con=GetMyConnection();
		PreparedStatement Pstmt=null;

		try {
			Pstmt=con.prepareStatement("update Product1 set name=? , price=? where id=?");
			Pstmt.setString(1, name);
			Pstmt.setInt(2, cost);
			Pstmt.setInt(3, id);
			Pstmt.executeUpdate();
			System.out.println(".................... Record Updated Sucessfully ....................");

		} 
		catch (SQLException e)
		{
			System.out.println("Table Not Found in DataBase...............");
		}

	}

	public static void DeleteByID(int id) 
	{
		Connection con=null;
		con=GetMyConnection();
		try {
			PreparedStatement Pstmt=con.prepareStatement("delete from Product1 where id=?");
			Pstmt.setInt(1, id);
			Pstmt.executeUpdate();
			System.out.println("................ Record Deleted ................");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public static void DeleteByCost(int cost) 
	{
		Connection con=null;
		con=GetMyConnection();
		try {
			PreparedStatement Pstmt=con.prepareStatement("delete from Product1 where price=?");
			Pstmt.setInt(1, cost);
			Pstmt.executeUpdate();
			System.out.println("................ Record Deleted ................");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void DeleteByName( String name) 
	{
		Connection con=null;
		con=GetMyConnection();
		try {
			PreparedStatement Pstmt=con.prepareStatement("delete from Product1 where name=?");
			Pstmt.setString(1, name);
			Pstmt.executeUpdate();
			System.out.println("................ Record Deleted ................");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void ShowDetailsByID(int id)
	{
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement Pstmt=null;
		con=GetMyConnection();
		try {
			Pstmt=con.prepareStatement("select * from product1 where id=?");
			Pstmt.setInt(1, id);
			rs=Pstmt.executeQuery();
			while(rs.next())
			{
				int id1=rs.getInt("id");
				String name1=rs.getString("name");
				int cost1=rs.getInt("price");

				System.out.println("ID : "+id1+"\nName : "+name1+"\nCost : "+cost1);
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}


	}
}
