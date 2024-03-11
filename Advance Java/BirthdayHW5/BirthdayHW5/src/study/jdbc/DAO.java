package study.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DAO {

	public Connection myGetconnection()	
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/db11"; //Protocol : dbvendor://IP:portname/database
			String uname="root";
			String pwd="prathamesh@13";



			con=DriverManager.getConnection(url,uname,pwd);
		}catch(ClassNotFoundException | SQLException e)
		{
			System.out.println("the connection could not be made"+e);
		}
		return con;	
	}
	public ResultSet getRows(String sql)
	{
		Connection con=myGetconnection();
		ResultSet rs=null;
		Statement stmt;
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}
	public void showResultset(ResultSet rs)
	{
		try {
			while(rs.next())
			{
				int pid=rs.getInt("id");
				String pName=rs.getString("name");
				int cost=rs.getInt(3);
				System.out.println("row: "+pid+","+pName+","+cost);
			}
			
			
		}catch(SQLException e)
		{
			System.out.println("problem showing resultset"+e);
		}
	}
	public void addProduct(int id,String name,int cost) 
	{
		try {
		//get connection
		Connection con=myGetconnection();
		PreparedStatement pstmt=con.prepareStatement("insert into product values(?,?,?)");
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, cost);
		pstmt.executeUpdate();
		con.close();
		
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void updateCost(int id,int cost)
	{
		Connection con=myGetconnection();
		try {
			PreparedStatement pstmt=con.prepareStatement("update product set cost=? where id=? ");
			
			pstmt.setInt(1, cost);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void callHiStoredProc() {
		
		Connection con=myGetconnection();
		try {
			CallableStatement cstmt=con.prepareCall("call hi()");
			ResultSet rs=cstmt.executeQuery();
			rs.next();
			String msg=rs.getString("message");
			System.out.println("you got" +msg);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void callgetNameProc(int id) {
		Connection con=myGetconnection();
		try {
			CallableStatement cstmt=con.prepareCall("{call getName(?,?)}");
			cstmt.registerOutParameter(2, Types.VARCHAR);
			
			cstmt.setInt(1, id);
			cstmt.execute();
			String msg=cstmt.getString(2);
			System.out.println("you got" +msg);
		
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void deleteProduct(int id)
	{
		Connection con = myGetconnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("delete from product where id = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			con.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addBirthday(String lname,String fname,String date)
	{
		Connection con=myGetconnection();
		try {
			PreparedStatement pstmt=con.prepareStatement("Insert into birthdays values(?,?,?) ");
			
			pstmt.setString(1,fname);
			pstmt.setString(2, lname);
			pstmt.setString(3, date);
			pstmt.executeUpdate();
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
}//dao closing

