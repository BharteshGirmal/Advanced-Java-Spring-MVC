package Study.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Client 
{
		
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/db1";
		String Uname="root";
		String Pass="Bhartesh@1008";
		
		Connection Con= DriverManager.getConnection(url,Uname,Pass);
		System.out.println(Con);
		
		Statement st=Con.createStatement();
		String sql="insert into Product1 values(1,'pendDrive',300)";
		st.executeUpdate(sql);

		System.out.println("Record Inserted....");
	}

}
