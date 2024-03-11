package com.example.demo;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DemoApplication {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Load the driver class from jar to RAM 
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		String url = "jdbc:mysql://localhost:3306/ietmar22";
		String uname ="root";
		String pwd = "123456789";
		
		Connection con = DriverManager.getConnection(url, uname, pwd);

		Statement stmt = con.createStatement();
		
		  Scanner sc = new Scanner(System.in); 
		  System.out.println("enter id"); 
		  int id=sc.nextInt(); 
		  System.out.println("enter product"); 
		  String name =sc.next();
		  System.out.println("enter cost"); 
		  int cost = sc.nextInt();
		  
		  String sql = "insert into product values("+id+",'"+name+"',"+cost+")";
		 	
		stmt.executeUpdate(sql);
		//System.out.println("record inserted");
		
		}
}
