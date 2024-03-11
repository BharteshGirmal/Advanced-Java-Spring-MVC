
<html>
      <%@page import="java.util.List"%>
     <%@page import="Bean.BirthdayDO"%>
     <style>
      body{
           background-image:url('https://png.pngtree.com/thumb_back/fh260/background/20210915/pngtree-geometric-pattern-white-gold-minimalist-creative-background-image_879782.jpg');
           background-repeat:no-repeat;
           background-attachment:fixed;
           background-size:cover;
      }
      </style>
      <body>
            <center>
                  <h1>Record Inserted in Database</h1>
                  <br/>
                  <%List<BirthdayDO> list =(List<BirthdayDO>)request.getAttribute("list");
                        for(BirthdayDO s : list)
                        { %>
                                 <h2 style="color: rgb(223, 74, 37);">Your Record ID : <%= s %></h2>
                        <% } %>
            </center>
      </body>
</html>