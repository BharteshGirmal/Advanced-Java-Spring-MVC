package HW4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW1.DAO;

/*
4.   when USER enters http://localhost:8080/AppHW3/total  [HINT WRITE A SERVLET S5 mapped to url-pattern "total , add doGet ]
		show a table of
			product name	   product cost
			Total   cost   : */

@WebServlet("/SumServlet")
public class SumServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw =response.getWriter();
		pw.println("<html><body><center>");
		pw.println("<form method='POST'");
		pw.println("<b><h2>Welcome...</h2></b>");
		pw.println("<br/><br/><input type='submit' value='Show Table'/>");
		pw.println("</form>");
		pw.println("</center></body></html>");
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw =response.getWriter();
		pw.println("<html><body><center>");
		pw.println("<table border='5'");
		pw.println("<tr><th>Product ID</th><th>Product Name</th><th>Product Cost</th></tr>");
		DAO obj = new DAO();
		ResultSet rs=obj.GetRows("select * from Product1");
		int sum=0;
		try {
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int cost=rs.getInt(3);
				sum=sum+rs.getInt(3);
				pw.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+cost+"</td></tr>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pw.println("</table>");
		pw.println("<b><h2>The Total Cost = "+sum+"</h2></b>");
		pw.println("</center></body></html>");

	}

}
