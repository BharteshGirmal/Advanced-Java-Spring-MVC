package study;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import study.jdbc.DAO;
@WebServlet("/newbday")
public class NewDay extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");
		pw.println("<form method ='post'>");
		pw.println("<br><br>Enter First Name<input type='text'placeholder='first Name' name=fname />");
		pw.println("<br><br>Enter Last Name<input type='text'placeholder='last Name' name=lname />");
		pw.println("<br><br>Selet Birthdate : <input type='date'name=dob />");
		pw.println("<br><br><input type='submit' value='ADD' />");
		pw.println("</form></body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String dob=request.getParameter("dob");
		DAO dao = new DAO();

		dao.addBirthday(lname, fname, dob);
		LocalDate today =LocalDate.now();
		ResultSet rs = dao.getRows("select fname,lname,dob,month(dob),day(dob) from birthdays");
				pw.println("<html><body>");
				try {
					while(rs.next())
					{
						String name1 =rs.getString(1);
						String name2 =rs.getString(2);
						String dob1=rs.getString(3);
						int month=rs.getInt(4);
						int day=rs.getInt(5);
						{
							if(month>today.getMonthValue() )
							{
								pw.println("<br><br>"+name1+"&nbsp; "+name2+"&nbsp; DOB("+dob1+") BIRTHDAY is comming soon......");
							}
							else if (month==today.getMonthValue() &&
									day>today.getDayOfMonth() )
							{
								pw.println(" <br><br>"+name1+"&nbsp; "+name2+"&nbsp; DOB("+dob1+") BIRTHDAY is comming soon......");
							}
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				pw.println("</body></html>");
	}
}