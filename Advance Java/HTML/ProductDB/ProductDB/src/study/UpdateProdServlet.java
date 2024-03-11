package study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Update")
public class UpdateProdServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		DAO dao = new DAO();
		String pid=request.getParameter("pid");
		String pname=request.getParameter("pname");
		String cost = request.getParameter("pcost");
		
		if(pname.equals("null") && cost.equals("0"))
		{
			
		}
	    if(pname.equals("null") && !cost.equals("0")) 
		{
			dao.updateCost(Integer.parseInt(pid), Integer.parseInt(cost));
		}
	    if(cost.equals("0") &&  !(pname.equals("null")) )
		{
			dao.updateName(Integer.parseInt(pid), pname);
		}
		if(!(pname.equals("null")) && !(cost.equals("0")) )
		{
			dao.updateNameAndCost(Integer.parseInt(pid), pname,Integer.parseInt(cost));
		}
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		pw.println("<html><body>");
		pw.println("---product Updated---");
		pw.println("<a href='Home.html'>Home</a>");
		
		
		pw.println("</body></html>");
		pw.close();
		
		
	}

}
