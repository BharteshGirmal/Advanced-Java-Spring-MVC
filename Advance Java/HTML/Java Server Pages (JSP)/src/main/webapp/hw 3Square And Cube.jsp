<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<!-- 3. Write a jsp  that prints an html table having three columns
		number   square  cube
          show the squares and cubes of all numbers between 1 to 100 -->
<body>
<center>
<table border='5'>
<tr><th>Number</th><th>Square Of Number</th><th>Cube of Number</th></tr>
<% for(int i=1;i<=100;i++){ %>
<tr>
<td><%=i %></td><td><%=i*i %></td><td><%=i*i*i %></td>
</tr>
<%} %>
</table>
</center>
</body>
</html>