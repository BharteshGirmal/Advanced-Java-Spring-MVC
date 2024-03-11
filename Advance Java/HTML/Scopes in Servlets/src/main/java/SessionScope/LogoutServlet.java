package SessionScope;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session=request.getSession(false);
		if(session == null)
		{
			response.getWriter().append("Illegal Acess ...");
		}
		else
		{
			Enumeration<String> Enum=session.getAttributeNames();
			while(Enum.hasMoreElements())
			{
				String attribute=Enum.nextElement();
				session.removeAttribute(attribute);
			}
			session.invalidate();
			response.sendRedirect("LoginServlet");
		}
		
	}
}
