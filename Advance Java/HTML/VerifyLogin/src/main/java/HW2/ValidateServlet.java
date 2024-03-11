package HW2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
		String Name=request.getParameter("User"); 
		String pass=request.getParameter("Pass");		
		PrintWriter pw=response.getWriter();
		System.out.println("User Name : "+Name+"\nPassword : "+pass);
		
		String Capital=Name.substring(0, 1).toUpperCase()+Name.substring(1, Name.length()).toLowerCase();
		
		if(Name.equals("CDAC") && pass.equals("Iet@1234"))
		{
			pw.println(" Hello  "+Capital+" Welcome ........");
		}
		else
		{
			pw.println("Invalid Credentials");
		}
	
		pw.close();
	}

}
