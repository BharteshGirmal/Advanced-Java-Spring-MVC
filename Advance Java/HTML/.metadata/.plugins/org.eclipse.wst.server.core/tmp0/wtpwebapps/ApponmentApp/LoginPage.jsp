<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="AppoinmentApp.DAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<center>
<fieldset>
<form action="HomePage.jsp">
<h1><b><i>Appoinment</i></b></h1>
<h2></h2><br/><br/><b>Enter the Name : </b>
<br/><br/><input type="text" name='name' placeholder="type here"/>
<br/><br/><b>Enter the Password : </b>
<br/><br/><input type="password" name='pass' placeholder="type here"/>
<br/><br/><input type="submit" value='Submit'/></h2>
   
   <%if(request.getParameter("message")!=null)
   { 
    	  request.getParameter("message");
       }%>
</form>
</fieldset>
</center>
</body>
</html>