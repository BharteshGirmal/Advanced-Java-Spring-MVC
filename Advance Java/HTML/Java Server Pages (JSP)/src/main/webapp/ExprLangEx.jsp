<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expression Launguage (EL)</title>
</head>
<body>
	<form action='ExprLangEx2.jsp'>
		<br />
		<h2>
			<b>Enter the Data</b>
		</h2>
		<br />
		<input type="text" name='data' /> <br />
		<br />
		<input type="submit" value='Submit' />
	</form>
	
	<% 
	List<Integer> nums=Arrays.asList(10,20,30,40,50,60,70,80,90);
	pageContext.setAttribute("Numbers", nums);
	session.setAttribute("Number", nums);
	request.setAttribute("Year", 2022);
	session.setAttribute("message", "Hello from Session Scope");
	application.setAttribute("App", "Hello from Application Scope");
%>
${ pageScope.Numbers }
</body>
</html>
