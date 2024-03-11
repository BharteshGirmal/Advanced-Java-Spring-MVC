package JDBCConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowServlet extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DAO obj= new DAO();
		ResultSet rs=obj.GetRows("select * from Product1");
		PrintWriter pw=response.getWriter();

		pw.println("<table border=2>");
		pw.println("<h2><tr><th>ID</th>"
				+ "<th>Product Name</th>"
				+ "<th>Cost</th></tr></h2>");
		try {
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int cost=rs.getInt(3);
				pw.println("<tr><td><center>"+id+"<center></td>"
						+ "<td><center>"+name+"</center></td>"
						+ "<td><center>"+cost+"</center></td></tr>");

			}
			pw.println("</table>");
			pw.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
