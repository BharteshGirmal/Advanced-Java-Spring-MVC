<html>
<%@page import="java.util.*" %>
      <body>
            <ul>
                  <% ArrayList<String> List = (ArrayList<String>)request.getAttribute("List"); 
                        for(String s : List)
                        {%>
                              <li><%=s %></li>
                        <%}
                        
                        %>
            </ul>
      </body>
</html>