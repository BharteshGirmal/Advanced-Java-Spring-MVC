package LabProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomePage")
public class HomePage extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<center><html><body style=' border=50px; border-width=100px; border-style:double; width:12cm; height:6cm;'> <center>");
		pw.println("<h1><center>Welcome</center></h1>");
		
		pw.println("<br/><br/><a href='InputServlet' >SignUp</a>");
		pw.println("<br/><br/><a href='Verify'>SignIn</a>");
		
		pw.println("</center></body></html><center>");
	}

}
