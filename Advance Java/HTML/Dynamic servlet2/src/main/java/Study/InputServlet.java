package Study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputServlet extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		pw.println("<center>");
		pw.println("<html><body style='border:10px;'>");
		pw.println("<form action='Second' method='GET' >");
		pw.println("Enter the Number :  <input type='number' name='num'/>");
		pw.println("<br/><br/>Enter the Range : <input type='number' name='range' />");
		pw.println("<br/><br/><input type='submit' value='Print Table'/>");
		pw.println("</form>");
		pw.println("</body></html>");
		pw.println("</center>");
		
		pw.close();
	}

}
