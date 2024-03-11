<%@page import="java.util.*" %>
<html>
      <body>
            <fieldset style=" background-color:  coral;">
                  <center>
                        <h1>The Product Details are </h1>
                  </center>
            </fieldset>
            <table border="6">
                  <tr><th>Product Name </th><th>Product Rating</th></tr>
                  <tr>
                        <td>
                              <% ArrayList<String> list=(ArrayList<String>)request.getAttribute("list"); 
                                    if(list!=null )
                                    { for(String al:list)
                                     {%>
                                           <li><%=al %></li>      
                                           
                                     <%} }
                                     %>
                        </td>
                  </tr>
            </table>
      </body>
</html>