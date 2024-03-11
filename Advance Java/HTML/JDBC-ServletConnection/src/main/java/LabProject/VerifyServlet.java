package LabProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Verify")
public class VerifyServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.println("<center><html><body>");
		pw.println("<form method='POST'>");
		pw.println("Enter the User Name : <input type='text' name='User'/>");
		pw.println("<br/><br/>Enter the Password : <input type='password' name='Pass'/>");
		pw.println("<br/><br/><input type='submit' value='Verify Account'/>");
		pw.println("</form>");
		pw.println("</body></html></center>");

		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
		String Name=request.getParameter("User"); 
		String pass=request.getParameter("Pass");		
		PrintWriter pw=response.getWriter();
		DAO obj= new DAO();
		pw.println("<html><body>");	
		String User;
		String pwd;
		ResultSet rs= obj.GetRows("select * from VerifyLogin");
		try {
			while(rs.next())
			{
				User = rs.getString(3);
				pwd =rs.getString(4);
				if(Name.equals(User) && pass.equals(pwd))
				{
					pw.println("<h1>.............!!! Welcome !!!............. <h1>");
				}
				else
				{
					pw.println("Invalid Credentials");
				}
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pw.println("</body></html>");
		pw.close();
	}

}
