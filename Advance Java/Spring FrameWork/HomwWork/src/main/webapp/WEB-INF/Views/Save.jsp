<%@page import="java.util.*" %>

<html>
      <body>
            <center>
                  <fieldset>
                  <h1 style="background-color: aquamarine;">Item saved</h1>
                  </fieldset>

                  <% ArrayList<String> list=(ArrayList<String>)request.getAttribute("list"); 
                       if(list!=null)
                       { for(String al:list)
                        {%>
                              <li><%=al %></li>      
                              
                        <%} }
                        %>
                       <br/><br/><a href="Product.jsp"> <h3> Back to Home </h3></a>
            </center>
      </body>
</html>