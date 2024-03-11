package Study.Login;

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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<center><html><body>");
		pw.println("<form action='Check' method='POST'>");
		pw.println("Enter the User Name : <input type='text' name='User'/>");
		pw.println("<br/><br/>Enter the Password : <input type='text' name='Pass'/>");
		pw.println("<br/><br/><input type='submit' value='Verify Account'/>");
		pw.println("</form>");
		pw.println("</body></html></center>");
		
		pw.close();
		
	}

}
