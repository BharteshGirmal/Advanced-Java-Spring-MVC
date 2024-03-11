package JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class DAO 
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
	

}
