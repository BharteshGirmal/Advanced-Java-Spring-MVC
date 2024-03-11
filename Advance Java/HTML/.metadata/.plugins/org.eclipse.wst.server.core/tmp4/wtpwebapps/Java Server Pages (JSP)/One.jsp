<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>One.jsp</h1>
<jsp:include page="Two.jsp">
<jsp:param value="All is Well" name="message"/>
</jsp:include>
</body>
</html>