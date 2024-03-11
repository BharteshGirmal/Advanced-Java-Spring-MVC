package RequestScopeData;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Serv2")
public class Serv2 extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int count=(Integer)request.getAttribute("counter");
		// down casting and auto unboxing 
		response.getWriter().append("Serv2 Got Counter As"+count); 
		
		/*
		 * ServletContext sc= super.getServletContext(); RequestDispatcher rd=
		 * sc.getRequestDispatcher("/Serv3"); count++; request.setAttribute("counter",
		 * count); rd.forward(request, response);
		 * response.getWriter().append("Returning From Serv1");
		 */
	}

}
