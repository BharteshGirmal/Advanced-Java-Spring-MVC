package HW1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String Name=request.getParameter("Update");
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<html><body><center>");
		pw.println("<form method='POST'>");

	
		if(Name.equals("UpdateName"))
		{
			pw.println("<br/><br/><b>Enter the name to Update<b/>");
			pw.println("<br/><input type='text' name='Pname'/>");
			pw.println("<br/><br/><b>Enter the ID<b/>");
			pw.println("<br/><input type='number' name='ID'/>");
			pw.println("<br/><br/><input type='submit' value='Update Name'/>");
		}
		if(Name.equals("UpdateCost"))
		{
			pw.println("<br/><br/><b>Enter the Cost to Update<b/>");
			pw.println("<br/><input type='number' name='Pcost'/>");
			pw.println("<br/><br/><b>Enter the ID<b/>");
			pw.println("<br/><input type='number' name='ID'/>");
			pw.println("<br/><input type='submit' value='Update Cost'/>");

		}
		if(Name.equals("UpdateBoth"))
		{
			pw.println("<br/><br/><b>Enter the name to Update<b/>");
			pw.println("<br/><input type='text' name='Pname'/>");
			pw.println("<br/><br/><b>Enter the Cost to Update<b/>");
			pw.println("<br/><input type='number' name='Pcost'/>");
			pw.println("<br/><br/><b>Enter the ID<b/>");
			pw.println("<br/><input type='number' name='ID'/>");
			pw.println("<br/><input type='submit' value='Update Both'/>");

		}
		
		pw.println("</form>");
		pw.println("<br/><center><a href='ProductServlet'>Go to HomePage</a></center>");

		pw.println("</center></body><html>");
		pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String PName=request.getParameter("Update");	

		String i=request.getParameter("ID");
		int id=Integer.parseInt(i);
		
		String Name=request.getParameter("Pname");
		String Cost=request.getParameter("Pcost");
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.println("<html><body>");
		
		if(PName.equals("UpdateName"))
		{
			DAO.UpdateName(Name, id);
			pw.println("<b>Record is Updated</b>");
		}
		if(PName.equals("UpdateCost"))
		{
			DAO.UpdateCost(id, Integer.parseInt(Cost));
			pw.println("<b>Record is Updated</b>");
		}
		if(PName.equals("UpdateBoth"))
		{
			DAO.UpdateBoth(Name, Integer.parseInt(Cost), id);
			pw.println("<b>Record is Updated</b>");
		}
		pw.println("<br/><center><a href='ProductServlet'>Go to HomePage</a></center>");

		pw.println("</body></html>");
			
	}

}
