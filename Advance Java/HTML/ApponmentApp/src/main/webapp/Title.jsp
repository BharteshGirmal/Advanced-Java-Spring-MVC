<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="AppoinmentApp.DAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Title</title>
</head>
<body>
<center>
<fieldset>
<h1><b>Appoinmen Table</b></h1>
<br/>
<br/>
<table border="6">
<tr><th>User Name</th><th>Date</th><th>Purpose</th><th>Reason</th><th>Time</th></tr>
<%
DAO obj=new DAO();
ResultSet rs=obj.GetRows("select * from Appoinment");
while(rs.next())
{
	    String uname = rs.getString("Username");
		String date = rs.getString("DateOfBirth");
		String purpose = rs.getString("purpose");
		String reason = rs.getString("reason");
		String time = rs.getString("time"); %>
		<tr>  
		       <td><%=uname %></td>
		       <td><%=date %></td>
		       <td><%=purpose %></td>
		       <td><%=reason %></td>
		       <td><%=time %></td>
		</tr>
 <% } %>
<a href="Today.jsp">Go To Today's Appointment </a>
</table>
</fieldset>
</center>
</body>
</html>