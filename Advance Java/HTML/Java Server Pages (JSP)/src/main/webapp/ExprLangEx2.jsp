<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome ${param.data}</h2>
<h2>Welcome <%=request.getParameter("data") %></h2>
<h2>Session Scope Level data : ${ sessionScope.Number }</h2>
<h2>Page Level data : ${ pageScope.Numbers }</h2>
<h2>Request Scope data : ${ requestScope.year }</h2>
<h2>Session Scope Level data : ${ sessionScope.message }</h2>
<h2>Application Scope Level data : ${ applicationScope.App }</h2>
</body>
</html>