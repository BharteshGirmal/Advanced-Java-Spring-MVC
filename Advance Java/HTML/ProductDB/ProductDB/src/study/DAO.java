package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	
	private Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = null;
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","MANKindia@11");
		
		} 
		catch (SQLException e) 
		{
			System.out.println("Cannot establish connection "+ e);
		}
		return con;
	}
	
	public ResultSet getRows(String sql)
	{
		ResultSet rs = null;
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void view()
	{
		ResultSet rs = getRows("select * from product1");
		try {
			while(rs.next())
			{
				System.out.print(rs.getInt("id")+", ");
				System.out.print(rs.getString(2)+", ");
				System.out.print(rs.getInt("cost"));
				System.out.println();
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addProduct(int id, String name, int cost)
	{
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		try 
		{
			pstmt = con.prepareStatement("insert into product1 values(?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, cost);
			pstmt.executeUpdate();
			
				con.close();
				pstmt.close();
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateCost(int id, int cost)
	{
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("update product1 set cost = ? where id = ?");
			pstmt.setInt(2, id);
			pstmt.setInt(1, cost);
			pstmt.executeUpdate();
			con.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateName(int id, String name)
	{
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("update product1 set name = ? where id = ?");
			pstmt.setInt(2, id);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			con.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateNameAndCost(int id, String name, int cost)
	{
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("update product1 set name = ?, cost = ? where id = ?");
			pstmt.setInt(3, id);
			pstmt.setString(1, name);
			pstmt.setInt(2, cost);
			pstmt.executeUpdate();
			con.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(int id)
	{
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("delete from product1 where id = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			con.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showProduct(int id)
	{
		ResultSet rs = getRows("select * from product1 where id = "+id);
		try 
		{
			rs.next();
			System.out.print(rs.getInt("id")+", ");
			System.out.print(rs.getString(2)+", ");
			System.out.print(rs.getInt("cost"));
			System.out.println();
			rs.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public ResultSet getRows_new(String sql)
	{
		Connection con = getConnection();
		ResultSet rs = null;
		Statement stmt=null;
		try {
			stmt = con.createStatement();
			rs =stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

}
