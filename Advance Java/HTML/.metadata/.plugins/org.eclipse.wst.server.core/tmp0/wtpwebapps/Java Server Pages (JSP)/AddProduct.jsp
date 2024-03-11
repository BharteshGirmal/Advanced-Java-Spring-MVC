<%@ page isErrorPage="false" errorPage="Error.jsp"%>
<%@ page import="Study.DAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Product to Database</title>
</head>
<body>
<%@ include file="LOGO.jsp" %>
<center>
<fieldset>
<form >
<br/> Enter the ID : <br/><input type='number' name='id'/>
<br/><br/> Enter the Product : <br/><input type='text' name='product'/>
<br/><br/> Enter the Cost : <br/><input type='number' name='cost'/>
<br/><br/> <input type='submit' value='Submit'/>
</form>
</fieldset>


<%
	String id=request.getParameter("id");
	String product=request.getParameter("product");
	String cost=request.getParameter("cost");
	
	
	if(id!=null)
	{
		int pid=Integer.parseInt(id);
		int pcost=Integer.parseInt(cost);
		DAO obj=new DAO(); 
		obj.AddProduct(pid, product, pcost);
	}
%>
</center>
</body>
</html>