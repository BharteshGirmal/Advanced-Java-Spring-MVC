<%@page import="java.util.Random"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date</title>
</head>
<body>
<br/>
<br/>
<h1>Todays Date is : <%=new Date() %> </h1>
<br/>
<br/>
<br/><h2><b>A Random Number  = <%=new Random().nextInt(100) %></b></h2>
</body>
</html>