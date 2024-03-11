<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Currency Converter</title>
</head>
<!-- 6.  write a currencyconvertor.jsp
			show a num1: textfield  rupee symbol
			convert button
		when convert button is clicked action=result.jsp
		on result.jsp show output as 
			100 rupee symbol   = 1.28 $
         show a link to currencyconvertor.jsp -->
<body>
<center>
<fieldset>
<form action='Convert.jsp'>
<h2>Enter the Currency</h2>
<br/>
<br/>
<b>&#8377</b>
<input type="number" name='Rupee'/>
<br/>
<br/>
<input type="submit" value='Covert'/>
</form>
</fieldset>
</center>
</body>
</html>