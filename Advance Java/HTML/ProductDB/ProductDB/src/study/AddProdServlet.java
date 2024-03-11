package study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddProd")
public class AddProdServlet extends HttpServlet {
	

    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DAO dao = new DAO();
		String pid=request.getParameter("pid");
		String pname=request.getParameter("pname");
		String cost = request.getParameter("pcost");
		
		dao.addProduct(Integer.parseInt(pid), pname, Integer.parseInt(cost));
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		pw.println("<html><body>");
		pw.println("---product Added---");
		pw.println("<a href='Home.html'>Home</a>");
		
		
		pw.println("</body></html>");
		
		
	
		
	}

}

/*http://localhost:8080/Tier-3WebProject/AddProd*/
