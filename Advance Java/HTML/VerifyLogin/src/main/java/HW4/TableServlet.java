package HW4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
Q4.Create a dynamic webp project that has a servlet StringServlet
this should show a table to the user 
having two columns 
    serial number   folder-names
show 200 rows 
	serial number should start from 1 to 200
	foldernames should be from A1 ,B1,C1,D1,E1....upto Z1 , then A2,B2,C2.....Z2......*/

@WebServlet("/TableServlet")
public class TableServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.println("<html><body>");
		pw.println("<table border=3>");
		pw.println("<h2><tr><th> Serial Number</th><th>Folder Names</th></tr></h2>");
		
		// initializing the Variables
		char ch=0;
		int x=1;
		int y=1;
		for(int i=1;i<=200;i++)
		{
			int num=(65%65)+65+(y-1);
			ch=(char) num; // down casting 
			
			pw.println("<tr><td><center>"+i+"</center></td><center><td>"+ch+""+x+"</center></td></tr>");
			if(i==(26*x))
			{
				x++;
				y=0;
			}
			y++;
		}
		pw.println("</table>");
		pw.println("</body></html>");
	}

}
