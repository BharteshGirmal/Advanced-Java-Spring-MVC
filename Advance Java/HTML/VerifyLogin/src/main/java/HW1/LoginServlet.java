package HW1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//1. setting http response header to content type 
		response.setContentType("text/html");
		
		String num = request.getParameter("num");
		int N =Integer.parseInt(num);
		
		String start = request.getParameter("range");
		int S =Integer.parseInt(start);
		
		String end = request.getParameter("end");
		int E =Integer.parseInt(end);
		
		// 2. Connecting Printwriter to response body
		PrintWriter pw=response.getWriter();
		
		pw.println("<html><body>");
		for(int i = S; i <= E; i++)
		{
			String str= N+" * "+i+" = "+N*i;
			pw.println("<br />"+str);
		}
		pw.println("</body></html>");

		pw.close();
	}

}
