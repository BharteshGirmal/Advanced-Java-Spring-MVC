<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! int count=0; %> <!--  Golbal variable declaration -->
<%
count++;
int Ucount=0;
if(session.isNew())
{
	Ucount=1;
	session.setAttribute("Ucount", 1);
}
else
{
	Ucount=(Integer)session.getAttribute("Ucount");
	Ucount++;
	session.setAttribute("Usercount", Ucount);
}
%>
<br/><h2><b>The Total hit Count = <%=count %></b></h2>
<br/><h2><b>The Total User Count = <%=Ucount %></b></h2>
</body>
</html>