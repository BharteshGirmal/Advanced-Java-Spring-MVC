<%@page import="java.util.*" %>
<html>
      <style>
            body{
                  background-image:url('https://img.freepik.com/free-vector/abstract-banner-background-with-red-shapes_1361-3348.jpg?w=2000');
                  background-repeat:no-repeat;
                  background-attachment:fixed;
                  background-size:cover;
                  color: beige;
             }
      </style>

<center>
      <body style="border: 0.1cm; border-style: groove;">
            <form action="/additem">
            <center>
            <h1><u>Shopping Item</u></h1>
            <h2>Enter the Product Name  :  </h2>
            <input type="text" name="item"/>
            <br/><br/><input type="submit" value="Add Product"/>      
            </center>
            </form>
            <br/> 
            <center>
                  <fieldset>
                  <h1 style="background-color: rgba(69, 255, 140, 0.979); color: rgb(210, 0, 0);">Item saved</h1>
                  </fieldset>

                  <% ArrayList<String> list=(ArrayList<String>)request.getAttribute("list"); 
                       if(list!=null )
                       { for(String al:list)
                        {%>
                              <li><%=al %></li>      
                              
                        <%} }
                        %>
            </center>     
      </body>
</center>
</html>