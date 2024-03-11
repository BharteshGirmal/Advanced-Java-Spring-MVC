<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Write a JSP that prints a table of 2 upto 1000 -->
<h1>Table of 2</h1>
<br/>
<% for(int i=1;i<=1000;i++)
	{
	%>
	<br/><b> <i>2 * <%=i %> => <%=2*i %></i> </b>
	<% 
	}%>

</body>
</html>