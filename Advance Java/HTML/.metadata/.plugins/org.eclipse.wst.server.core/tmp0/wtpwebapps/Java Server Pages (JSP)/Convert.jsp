<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Currency Converter</title>
</head>
<body>
<center>
<% float rupee=Float.parseFloat(request.getParameter("Rupee")); %>
<h2>&#8377; <%=rupee %>= &<%=rupee/78.125 %></h2>
<a href="hw6_Currency_Converter.jsp"> Go Back to Home Page</a>
</center>
</body>
</html>