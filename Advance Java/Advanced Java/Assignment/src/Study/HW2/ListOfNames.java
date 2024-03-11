/*
2.  Write a Java client that fetches all names of the products
	add all the names in an ArrayList 
	show the size of the arrayList 
	Ask the user to enter a name
		print whether the name is in the ArrayList or 		not*/

package Study.HW2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ListOfNames
{

	public static void main(String[] args) throws SQLException {
		
		Scanner sc= new Scanner(System.in);
		ArrayList<String> List= new ArrayList<String>();
		Connection Con=DataAcessObject.GetMyConnectIon();
		ResultSet rs=DataAcessObject.GetRows("select name from Product1");
		
		while(rs.next())
		{
			List.add((rs.getString(1)));
		}
		
		System.out.println("The Size of ArrayList : "+List.size());
		System.out.println(List);
		
		System.out.println("Enter the Product Name");
		String Name=sc.next();
		if(List.contains(Name))
		{
			System.out.println("The Product is Present in the ArrayList ");
		}
		else
		{
			System.out.println("The Product is Not Present in the ArrayList");
		}
		
		sc.close();
		Con.close();
		rs.close();
	}
}

class DataAcessObject
{
	public static Connection GetMyConnectIon()
	{
		Connection Con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/db1";
		String Uname="root";
		String Pass="Bhartesh@1008";
		try {
			Con=DriverManager.getConnection(url,Uname,Pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Con;
	}

	public static ResultSet GetRows(String Sql)
	{
		Connection con= GetMyConnectIon();
		ResultSet rs=null;
		Statement stmt=null;
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(Sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rs;
	}
}
