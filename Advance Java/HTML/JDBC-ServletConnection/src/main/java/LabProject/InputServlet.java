package LabProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<html><body style='border=50px; border-width: 10px ;width:18cm;height:10cm;'> <center>");
		pw.println("<form method='POST'>");
		pw.println("<br/><br/>Enter the First Name : <input type='text' name='Fname'/>");
		pw.println("<br/><br/>Enter the Last Name : <input type='text' name='Lname'/>");
		pw.println("<br/><br/>Enter the User Name : <input type='text' name='User'/>");
		pw.println("<br/><br/>Enter the Password : <input type='password' name='Pass'/>");
		pw.println("<br/><br/>Select Gender");
		pw.println("<br/><br/><input type='radio' name='Gender' value='male' /> Male");
		pw.println("<br/><br/><input type='radio' name='Gender'value='female' /> Female");
		pw.println("<br/><br/><input type='radio' name='Gender' value='other' /> Other");
		pw.println("<br/><br/>Enter the Mobile Number : <input type='number' name='Mob'/>");
		
		pw.println("<br/><br/><input type='submit' value='Create Account' />");
		pw.println("</form>");
		pw.println("</center></body></html>");
		
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String Fname=req.getParameter("Fname");
		String Lname=req.getParameter("Lname");
		String Mob=req.getParameter("Mob");
		String uname=req.getParameter("User");
		String pass=req.getParameter("Pass");
		String gender=req.getParameter("Gender");
		String phone=req.getParameter("Mob");
		long mob=Integer.parseInt(phone);
		DAO obj= new DAO();
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		obj.AddUser(Fname, Lname, uname, pass, gender, mob);
		pw.println("<html><body>");
		pw.println("<h2><b>Account Created Sucessfully ...... </b></h2>");
		pw.println("</body></html>");
	}

}
