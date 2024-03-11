package SessionScope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AntherServlet")
public class AntherServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		HttpSession session=request.getSession();
		if(session == null)
		{
			response.getWriter().append("Cannot Access the Page Without Login");
			return;
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<html><body><center>");
			pw.println("<a href='LogoutServlet'> Logout </a>");
			pw.println("<br/><form action='YetAntherServlet' method='POST'>");
			pw.println("<br/><h1>Welcome ....   </h1>"+session.getAttribute("uname"));
			pw.println("<br/><input type='submit' value='YetAntherPage'/>");
			pw.println("</form>");
			pw.println("</center></body></html>");
			pw.close();
		}
	}

}
