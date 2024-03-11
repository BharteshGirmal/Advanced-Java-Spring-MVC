package SessionScope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<html><body><center>");
		pw.println("<form method='POST'>");
		pw.println("<br/><br/>Enter the User Name : <input type='text' name='name'/>");
		pw.println("<br/><br/>Enter the Password : <input type='password' name='pass'/>");
		pw.println("<br/><br/><input type='submit' value='Next Page' />");
		pw.println("</form>");
		pw.println("</center></body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uname=request.getParameter("name");
		String pass=request.getParameter("pass");
		
		HttpSession session=request.getSession();
		if(session.isNew()) //if the session is new 
		{
			session.setAttribute("uname", uname);
			// setting the attribute for the new session 
			RequestDispatcher rd=super.getServletContext().getRequestDispatcher("/HomeServlet");
			// the request is sent to home servlet
			rd.forward(request, response);
		}
	}

}
