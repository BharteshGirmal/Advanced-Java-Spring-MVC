package HW3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
		String Name=request.getParameter("User"); 
		String pass=request.getParameter("Pass");		
		String Gender=request.getParameter("Gender");
		PrintWriter pw=response.getWriter();
		System.out.println("User Name : "+Name+"\nPassword : "+pass+"\nGender : "+Gender);
		
		String Capital=Name.substring(0, 1).toUpperCase()+Name.substring(1, Name.length()).toLowerCase();
		
		String OutName="";
		if(Gender.equals("male"))
		{
			OutName=" Welcome Mr. "+Capital ;
		}
		if(Gender.equals("female"))
		{
			OutName=" Welcome Mis. "+Capital ;
		}
		
		if(Name.equals("IET") && pass.equals("Iet@1234"))
		{
			pw.println("Welcome !!! "+OutName);
		}
		else
		{
			pw.println("Invalid Credentials");
		}
	
		pw.close();
	}

}
