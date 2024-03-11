package SessionScope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session=request.getSession(false);
		if(session != null && session.getAttribute("uname")==null)
		{
			response.getWriter().append("Cannot Access without Login Name");
			return;
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<html><body bgcolour='black';><center>");
			pw.println("<form action='AntherServlet' method='POST'>");
			pw.println("<br /><h1>Welcome...  </h1>" +session.getAttribute("uname") );
			pw.println("<br /> <b>Enter the School Name</b>");
			pw.println("<br /><input type='text' name='School'/>");
			pw.println("<br /><input type='submit' value='Anther Page'/>");
			pw.println("<br /><a href='LogoutServlet'> Logout </a>");
			pw.println("</form>");
			pw.println("</center></body></html>");
			pw.close();
		}
	}

}
