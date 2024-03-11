package study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Delete")
public class DeleteProdServlet extends HttpServlet {
	
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DAO dao = new DAO();
		String pid=request.getParameter("pid");
		
		dao.deleteProduct(Integer.parseInt(pid));
		
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		pw.println("<html><body>");
		pw.println("---Product Deleted---");
		pw.println("<a href='Home.html'>Home</a>");
		pw.println("</body></html>");
		pw.close();
		
	}

}
