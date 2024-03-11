package HW2;

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

import HW1.DAO;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
    	PrintWriter pw=response.getWriter();
    	pw.println("<html><body>");
    	pw.println("<form method='POST'");
    	pw.println("<b><h2>Select the Product ID To Delete the Record from Following : </h2><b>");
    	
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
    	pw.println("<br/><br/><input type='submit' value='Delete Record'/> </center>");
    	pw.println("</form>");
    	pw.println("</body><html>");
    	pw.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DAO obj=new DAO();
		String i=request.getParameter("number");
		int id=Integer.parseInt(i);
		DAO.DeleteByID(id);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");
		pw.println("<b><h2>---Record Deleted---</h2></b>");

		pw.println("<br/><center><a href='ProductServlet'>Go to HomePage</a></center>");
		pw.println("</body></html>");
		pw.close();
	}

}
