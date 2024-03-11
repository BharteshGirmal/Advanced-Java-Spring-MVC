package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class DemoApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Connection Con=null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/db1";
		String Uname="root";
		String Pass="Bhartesh@1008";
		Con= DriverManager.getConnection(url,Uname,Pass);

		Statement st=Con.createStatement();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the Product id");
		int pid=sc.nextInt();
		System.out.println("Enter the Product Name");
		String pname=sc.next();
		System.out.println("Enter the Cost of Product");
		int cost=sc.nextInt();
		String sql="insert into Product1 values("+pid+",'"+pname+"',"+cost+")";
		st.executeUpdate(sql);
		System.out.println("Record Inserted....");
	}

}
