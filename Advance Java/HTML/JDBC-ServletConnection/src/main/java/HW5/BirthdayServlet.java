package HW5;

import java.io.IOException;

/*
5.    create a table birthdays  having columns    id   first-name last-name   dob
	when user enters url http://localhost:8080/AppHW4/newbday  [HINT WRITE A SERVLET S6 mapped to url-pattern "newbday" , add doGet ]
		show a screen with text fields for fname lname and a date input field for don
		add a save submit button below
		when user enters values and clicks save button 
		go to http://localhost:8080/AppHW4/newbday  [HINT in S6  , add doPost ]
                this shoud insert the record in DB 
		and show a screen  that shows a table of reminders 
			fname lastname and dob for only those birthdays after today's date in the current year

 */
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.a.LocalDateTimeValueEncoder;


@WebServlet("/BirthdayServlet")
public class BirthdayServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();

		pw.println("<html><body style='border:'25px';border-style:'double'; width:12cm; height:8cm;'><center>");
		pw.println("<form method='POST'>");
		pw.println("<br/><br/><h1><b>Birthday Details</b></h1>");
		pw.println("<br/><br/><b>Enter the First Name</b>");
		pw.println("<br/><br/><input type='text' name='Fname'/>");
		pw.println("<br/><br/><b>Enter the Last Name</b>");
		pw.println("<br/><br/><input type='text' name='Lname'/>");
		pw.println("<br/><br/><b>Enter the BirthDate</b>");
		pw.println("<br/><br/><input type='Date' name='DOJ' value='Date Of Birth'/>");
		pw.println("<br/><br/><input type='Submit' name='save'/>");
		pw.println("</form>");
		pw.println("</center></body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String Fname=request.getParameter("Fname");
		String Lname=request.getParameter("Lname");
		String DOJ=request.getParameter("DOJ");

		DataAcessObject obj= new DataAcessObject();
		obj.AddBirthday(Fname, Lname, DOJ);
		LocalDate date=LocalDate.now();

		ResultSet rs= obj.GetRows("select FirstName , lastName , DateOfBirth , month(DateOfBirth) , day(DateOfBirth) from Birthday ");
		pw.println("<html><body>");
		try {
			while(rs.next())
			{
				String Firstname=rs.getString(1);
				String Lastname=rs.getString(2);
				String DOB=rs.getString(3);
				int Month=rs.getInt(4);
				int Day=rs.getInt(5);
				
				LocalDate today = null;
				if(Month>today.getMonthValue() )
				{
					pw.println("<br><br>"+Firstname+"&nbsp; "+Lastname+"&nbsp; DOB("+DOB+") BIRTHDAY is comming soon......");
				}
				else if (Month==today.getMonthValue() &&
						Day>today.getDayOfMonth() )
				{
					pw.println(" <br><br>"+Firstname+"&nbsp; "+Lastname+"&nbsp; DOB("+DOB+") BIRTHDAY is comming soon......");
				}
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		pw.println("<b><h1>Record Added in List</h1></b>");
		pw.println("</body></html>");
	}

}
