package RequestScopeData;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Serv1")
public class Serv1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int count=0;
		count++;
		
		response.getWriter().append("Serv1 Has Count : "+count++);
		//ServletContext sc= super.getServletContext();
		// Getting the Existing Servlet  Object 
		//RequestDispatcher rd= sc.getRequestDispatcher("/Serv2");
		//Request Dispatcher 
		//request.setAttribute("counter", count); // setting the Attribute name and value of attribute
		// count is a object of integer it is get Up casted to Integer auto boxing
		//rd.forward(request, response);
		// forwards the response of itermediate servlet to last Servlet 
		
		//rd.include(request, response);
		//response.getWriter().append("Returning From Serv1");
	}

}
