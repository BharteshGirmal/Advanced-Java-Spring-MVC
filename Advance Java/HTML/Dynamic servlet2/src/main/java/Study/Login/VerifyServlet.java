package Study.Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerifyServlet
 */
@WebServlet("/VerifyServlet")
public class VerifyServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String User="IET";
		String PassWord="Iet@118";
		
		String Name=request.getParameter("User"); 
		String pass=request.getParameter("Pass");		
		
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");
		
		if(Name.equals(User) && pass.equals(PassWord))
		{
			pw.println("<b> Account Verified Sucessfully !!! </b>");
		}
		else
		{
			pw.println("<b> Invalid Account !!! </b>");
		}
		pw.println("</body></html>");
	}

}
