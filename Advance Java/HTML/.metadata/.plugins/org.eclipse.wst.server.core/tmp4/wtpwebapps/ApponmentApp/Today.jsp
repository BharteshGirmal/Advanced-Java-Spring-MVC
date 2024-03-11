<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="AppoinmentApp.DAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<table border="1">
        <% 
        DAO obj = new DAO();
        ResultSet rs =obj.GetRows("select * from Appoinment having DateofBirth = curdate() order by time");
        
        while(rs.next())
        {
       	        String uname = rs.getString(1);
				String date = rs.getString(2);
				String purpose = rs.getString(3);
				String reason = rs.getString(4);
				String time = rs.getString(5);		
		%>
				
				<tr>  
				       <td><%=uname %></td>
				       <td><%=date %></td>
				       <td><%=purpose %></td>
				       <td><%=reason %></td>
				       <td><%=time %></td>
				</tr>
				
        <% } %>
     
</table>  
</center> 
</body>
</html>