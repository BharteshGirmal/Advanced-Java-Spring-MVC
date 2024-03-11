<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hiie From JSP</h1>
	<!-- To include the java logic the following syntax is used  -->
	<!--  <%   %> ==> this syntax used  -->
	<% for(int i=0;i<20;i++) 
	{
		%>
		<br/><b><i>Hello JSP</i></b>
		<%
	}
	%>
</body>
</html>