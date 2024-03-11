<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Two.jsp</h1>
<br/> Todays Date is <%=new Date() %>
<br/><b><%= request.getParameter("message") %></b>

</body>
</html>