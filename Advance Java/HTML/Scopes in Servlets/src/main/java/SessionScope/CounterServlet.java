package SessionScope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet
{	int count=0;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		int Ucount;
		
		if(session.isNew())
		{
			Ucount=1;
			session.setAttribute("UserCounter",1);
			
		}
		else
		{
			Ucount=(Integer)session.getAttribute("UserCounter");
			Ucount++;
			session.setAttribute("UserCounter", Ucount);
			
		}

		PrintWriter pw =response.getWriter();
		count++;
		pw.println("The Total Hit count value = "+count);
		pw.println("The User count value = "+Ucount);
		pw.close();	}
}
