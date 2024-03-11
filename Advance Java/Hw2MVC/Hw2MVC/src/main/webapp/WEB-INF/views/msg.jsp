<html>
    
    <%@page import="java.util.*" %>
<body>

    <h1>saved</h1>

    <% ArrayList<String> al =(ArrayList<String>) request.getAttribute("arr");

        for(String s : al)
        {  %>
            <h1> <%=s %> </h1>
    <%}

    %>

</body>
</html>
