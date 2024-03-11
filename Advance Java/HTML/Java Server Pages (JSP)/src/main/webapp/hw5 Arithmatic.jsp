<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<!-- 5.  Write a calculator.jsp
		show a num1 : textfield
	        show a num2 : textfield
                   show a dropdown with operators ---- + ,- ,* , /
		show a calculate button
	when calculate button is clicked then action=output.jsp
	on output.jsp   show the result of the calculation 
		2  +  3  = 5 
         show a link to calculator.jsp  -->
<body>
<center>
<fieldset>
<form action='Calculate.jsp'>
<h1><b>Calculator</b></h1>
<br/>
<b>Select the Arithmatic Opration to Perform</b>
<br/>
<select name='dropdown'>
	<option value='add'>Addition</option>
	<option value='sub'>Subtraction</option>
	<option value='mul'>Multiplication</option>
	<option value='div'>Division</option>
	</select>
<br/>
<br/>
<lable for="num1">Enter the First Number:</lable>
<br/>
<br/>
<input type='text' name='num1'/>
<br/>
<br/>
<lable for="num2">Enter the Second Number:</lable>
<br/>
<br/>
<input type='text' name='num2'/>
<br/>
<br/>
<input type="submit" value='Calculate'/>
</form>
</fieldset>
</center>
</body>
</html>