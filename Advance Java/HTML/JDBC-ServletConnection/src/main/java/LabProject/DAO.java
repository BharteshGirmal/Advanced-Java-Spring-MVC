package LabProject;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class DAO 
{
	public static Connection MyGetConnection()
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

	public void AddUser(String fname,String lname,String uname,String pass,String gender,long mob)
	{
		Connection con=MyGetConnection();
		PreparedStatement Pstmt;
		try {
			Pstmt = con.prepareStatement("insert into VerifyLogin values(?,?,?,?,?,?)");

			Pstmt.setString(1, fname);
			Pstmt.setString(2, lname);
			Pstmt.setString(3, uname);
			Pstmt.setString(4, pass);
			Pstmt.setString(5, gender);
			Pstmt.setLong(6, mob);
			Pstmt.executeUpdate();
			System.out.println("Record Inserted");
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet GetRows(String sql)
	{
		Connection con =MyGetConnection();
		ResultSet RS=null;
		java.sql.Statement stmt=null;

		try {
			stmt=con.createStatement();
			RS=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return RS;
	}

	public static void UpdateName(String name, int id )
	{
		Connection con=MyGetConnection();
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
		Connection con=MyGetConnection();
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
		Connection con=MyGetConnection();
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
		con=MyGetConnection();
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



}
