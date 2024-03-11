package JDBCConnection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddProductServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.println("<html><center><body>");
		pw.println("<form method='POST'>");
		pw.println("<br/><br/>Enter the ID : <input type='text' name='id'/>");
		pw.println("<br/><br/>Enter the Product : <input type='text' name='product'/>");
		pw.println("<br/><br/>Enter the Cost : <input type='text' name='cost'/>");
		pw.println("<br/><br/><input type='submit' value='Add Product'/>");
		pw.println("</form>");
		pw.println("</body></center><html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id=request.getParameter("id");
		String product=request.getParameter("product");
		String cost=request.getParameter("cost");
		
		DAO Obj=new DAO(); // Data Access Object to connect the Database 
		Obj.AddProduct(Integer.parseInt(id), product, Integer.parseInt(cost));
		
		 response.setContentType("text/html"); PrintWriter pw=response.getWriter();
		 pw.println("<html><body>"); 
		 pw.println("<b><h1> The Product is Added in Database Sucessfully ...!</h1></b>");
		 pw.println("<center>"
		 		+ "<form action='Show' method='GET' border='2'>"
		 		+ "<b>"
		 		+ "<input type='submit' value='Show Tables'/>"
		 		+ "</b>"
		 		+ "</form>"
		 		+ "</center>");
		 pw.println("</body></html>");
		 
	
	}

}
