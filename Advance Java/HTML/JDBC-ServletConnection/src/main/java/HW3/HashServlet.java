package HW3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW1.DAO;

/*
3.  Create a database table  ----- Users
Primary key  Username   ,  password , date 
U insert values in the table from mysql client 

 http://localhost:8080/AppHW2/login  GET  [HINT WRITE A SERVLET S4 that is mapped to url-pattern "login"  , add doGet  ]

this should show the uname password login screen
when USER enters the details and clicks login go to
http://localhost:8080/AppHW2/login  POST    [HINT in S4, add doPost  ]
in the doPost method Use the HashMap to verify if credentials are correct . 
If Correct show output as welcome user else show output as Invalid user.

ADD  the init method to the Servlet  as follows ---
	In the init method  -----
    Fire a select query DAO  that fetches all records of Users table .
    Create a HashMap<String String>  in the servlet  class as a property.	  
    add all unames and passwords to the hashmap
*/
@WebServlet("/HashServlet")
public class HashServlet extends HttpServlet 
{
	HashMap<String, String> HashList= new HashMap<String,String>();
	// to Get and store the Username and Password in HashSet
	
	// Calling Init Method
	@Override
	public void init() throws ServletException 
	{
		DAO obj= new DAO();
		ResultSet rs= obj.GetRows("select * from LoginTable");
		
		try {
			while(rs.next())
			{
				String Uname=rs.getString(1);
				String Pass=rs.getString(2);
				HashList.put(Uname, Pass);
				// Records are added in the HashMap 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<html><center><body style='border=20px;border-width=20px; border-style:double; width:12cm ; height:6cm'>");
		pw.println("<form method='POST'>");
		pw.println("<h2>Enter the Details</h2>");
		pw.println("<b>Enter the User Name</b>");
		pw.println("<br/><br><input type='text' name='Username'/>");
		pw.println("<br/><br><b>Enter the User Password</b>");
		pw.println("<br/><br><input type='password' name='Password'/>");
		pw.println("<br/><br><input type='Submit' name='Verify Account'/>");
		pw.println("</form>");
		pw.println("</body></center></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String Name=request.getParameter("Username");
		String Pass=request.getParameter("Password");
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.println("<html><body>");
		pw.println("<center>");
		if(HashList.containsKey(Name))
		{
			if(Pass.equals(HashList.get(Name)))
			{
				pw.println("<b><h2>Welcome ...!  "+Name+" </h2></b>");
			}
			else
			{
				pw.println("<b><h2>Invalid User Name or Password</h2></b>");

			}
			
		}
		pw.println("</center>");
		pw.println("</body></html>");
		pw.close();
		
		
	}

}
