<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String Oprator=request.getParameter("dropdown");
int num1=Integer.parseInt(request.getParameter("num1"));
int num2=Integer.parseInt(request.getParameter("num2"));

int res=0;
if(Oprator.equals("add"))
{
	res=num1+num2;
}
if(Oprator.equals("sub"))
{
	res=num1-num2;
}
if(Oprator.equals("mul"))
{
	res=num1*num2;
}
if(Oprator.equals("div"))
{
	res=num1/num2;
}
%>

<b> <%=num1 %> <%=Oprator %> <%=num2 %> = <%=res %></b>
</body>
</html>