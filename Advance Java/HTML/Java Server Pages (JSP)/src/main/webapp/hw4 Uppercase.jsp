<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<!-- 4.  Write a JSP input.jsp that shows a textfield and a submit button ok 
	when the user enters a string in the textfield and clicks OK  
	then the  action="show.jsp " 
  	in show.jsp show the string in uppercase -->
<body>
<form action="Show.jsp">
<center>
<h2>Uppercase</h2>
<br/>
<b>Enter Your Full Name</b>
<br/><input type="text" name='name'/>
<br><input type="submit" value='Submit'/>
</center>
</form>
</body>
</html>