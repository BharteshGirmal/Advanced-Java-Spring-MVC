<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="AppoinmentApp.DAO" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
</head>
<body>
<center>
<fieldset>
<form method="post">
<% 
String name=request.getParameter("name");
String pass=request.getParameter("pass");
if(name!=null && (name.equalsIgnoreCase("Bhartesh") 
		&& pass.equals("Bhartesh@123")))
{%>
	<h1>Home</h1>
	<br/><h2><br/>Enter Date : <input type="date" name="dob"/><br/>     
	<br/><br/>Enter Purpose : <input type="text" name="purpose" placeholder="type here"/><br/>     
	<br/><br/>Enter Reason :<br/>
	<br/>Officially : <input type="radio" name="reason" value="Officially"/>  
	<br/>Personal : <input type="radio" name="reason" value="Personal"/><br/> 
	<br/>Time : <input type="time" name="time"/><br/></pre>
	<br/><input type="submit" value="Submit"/><br/></h2>
<%}
else
{%>
	<jsp:include page="LoginPage.jsp">
	<jsp:param value="message" name="Incorrect Details"/>
	</jsp:include>
<%}
%>
</form>
</fieldset>

<%
		String date = request.getParameter("dob");
		String purpose = request.getParameter("purpose");
		String reason = request.getParameter("reason");
		String time = request.getParameter("time");
		DAO obj=new DAO();
		if(name!=null && date!=null && purpose!=null && reason!=null && time!=null)
		{
			obj.AddAppoinment(name, date, purpose, reason, time);
		}
%>
<br/><br/><a href="Title.jsp"><b>Show All Apoinments</b></a>
</center>
</body>
</html>