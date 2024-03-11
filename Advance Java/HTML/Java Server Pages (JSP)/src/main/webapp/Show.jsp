<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String Name=request.getParameter("name"); %>
<%Name=Name.toUpperCase(); %>
<h2><b>My Name is <%=Name %></b></h2>
</body>
</html>