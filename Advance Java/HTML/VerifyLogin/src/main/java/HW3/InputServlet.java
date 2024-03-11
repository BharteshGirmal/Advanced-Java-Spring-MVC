package HW3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
2. Create a dynamic web project Login
add InputServlet - accept a uname and password from 	user
write a form action="verify"  method="post"
on submit the control should go to the VerifyServlet doPost method
in the doPost method check if uname is iet and password is 123 --- 
then show output login success else show output login failed.
*/
public class InputServlet extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<html><center><body style='border=5; border-width: 10px ;width:18cm;height:10cm;>");
		pw.println("<form action='Verify' method='POST'>");
		pw.println("<br/><br/>Enter the User Name : <input type='text' name='User'/>");
		pw.println("<br/><br/>Enter the Password : <input type='password' name='Pass'/>");
		pw.println("<br/><br/><input type='radio' name='Gender' value='male' /> Male");
		pw.println("<br/><br/><input type='radio' name='Gender'value='female' /> Female");
		pw.println("<br/><br/><input type='radio' name='Gender' value='other' /> Other");
		pw.println("<br/><br/><input type='submit' value='Verify Account'/>");
		pw.println("</form>");
		pw.println("</body>"
				+ "</center></html>");
		
		pw.close();
		
	}

}
