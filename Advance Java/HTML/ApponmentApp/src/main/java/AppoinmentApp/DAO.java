package AppoinmentApp;

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
			String url="jdbc:mysql://localhost:3306/db2";
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


	public void AddAppoinment(String uname,String DateofBirth ,String purpose ,String reason, String time )
	{
		Connection con=MyGetConnection();
		if(uname!=null && DateofBirth!=null && purpose!=null && reason!=null && time!=null) 
		{
			PreparedStatement Pstmt;
			try {
				Pstmt = con.prepareStatement("insert into Appoinment values(?,?,?,?,?)");

				Pstmt.setString(1,uname );
				Pstmt.setString(2, DateofBirth);
				Pstmt.setString(3,purpose);
				Pstmt.setString(4,reason );
				Pstmt.setString(5,time);
				Pstmt.executeUpdate();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
