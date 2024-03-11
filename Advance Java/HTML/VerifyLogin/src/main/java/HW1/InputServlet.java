package HW1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*1. Create a dynamic web project as discussed in class
input and  second  servlets
accept num , range and from-num  value from user
output -table printed from-num to range for num*/

public class InputServlet extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		pw.println("<center>");
		pw.println("<html><body style='border:10px;'>");
		pw.println("<form action='TableCheck' method='GET' >");
		pw.println("Enter the Number :  <input type='number' name='num'/>");
		pw.println("<br/><br/>Enter the Range <br/>From : <input type='number' name='range' />");
		pw.println("<br/><br/>To : <input type='number' name='end'/>");
		pw.println("<br/><br/><input type='submit' value='Print Table'/>");
		pw.println("</form>");
		pw.println("</body></html>");
		pw.println("</center>");
		
		pw.close(); 
	}

}
