package HW1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
1. Write a FLOW as follows
http://localhost:8080/AppHW/find   GET       [ HINT WRITE A SERVLET  S1  that is mapped to  url-pattern " find "  , add doGet ]
The above url should show a dropdown list of all productIds in the product table.
Add a show button below it.
when USER selects a product Id and clicks show button
go to   http://localhost:8080/AppHW/find  POST   [  HINT   add doPost to the SERVLET S1  created above   ]
this should show the id, name and cost of the selected id in 3 textfields. the id textfield should be readOnly. 
show a update button below it.
When USER changes the product name or cost or both and clicks the update button then
       go to http://localhost:8080/AppHW/update POST   [ HINT WRITE A SERVLET S2 that is mapped to url-pattern "update"  , add doPost  ]
this should update the table with new values and show output as Record updated .  
      show a link to the  http://localhost:8080/AppHW/find     below it.
*/
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	response.setContentType("text/html");
    	PrintWriter pw=response.getWriter();
    	pw.println("<html><body>");
    	pw.println("<form method='POST'");
    	pw.println("<b><h2>Select the Product ID from the Following : </h2><b>");
    	
    	pw.println("<lable for='number'> </lable>");
    	pw.println("<center><select name='number'>");
    	DAO obj = new DAO();
    	Connection con=obj.MyGetConnection();
    	ResultSet rs=obj.GetRows("select id from Product1");
    
    	int id;
    	try {
			while(rs.next())
			{
				id=rs.getInt(1);
				pw.println("<option>"+id+"</option>");
			}
	    	con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	pw.println("</select>");
    	pw.println("<br/><br/><input type='submit' value='Show Table'/> </center>");
    	pw.println("</form>");
    	pw.println("<br/><br/><center><a href='DeleteServlet' > Delete a Record </a></center>");
    	pw.println("</body><html>");
    	pw.close();
    	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String num=request.getParameter("number");
		int number=Integer.parseInt(num);
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		DAO obj= new DAO();
		pw.println("<html><body><center><table border='4'>");
		pw.println("<tr><th>ID</th><th>Product Name</th><th>Cost</th></tr>");
		ResultSet rs=obj.GetRows("select * from Product1 where id="+number);
		try {
			while(rs.next())
			{
				int No=rs.getInt(1);
				String name=rs.getString(2);
				int cost=rs.getInt(3);
				pw.println("<tr><td>"+No+"</td><td>"+name+"</td><td>"+cost+"</td></tr>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		pw.println("</table>");
		pw.println("<form action='Update' method='GET'> ");
		pw.println("<br/><br/><b>Select Any of the Following Option</b>");
		pw.println("<br/><br/><input type='radio' Name='Update' value='UpdateName' value='+number+'/> : Update the Name");
		pw.println("<br/><br/><input type='radio' Name='Update' value='UpdateCost'/> : Update the Cost ");
		pw.println("<br/><br/><input type='radio' Name='Update' value='UpdateBoth'/> : Update Name and Cost");
		pw.println("<br/><br/><input type='submit' value='Submit'/>");
		pw.println("</form>");
    	pw.println("<br/><br/><center><a href='ProductServlet' >Go to HomePage </a></center>");

		pw.println("</center></body></html>");
		pw.close();
		
	}

}
