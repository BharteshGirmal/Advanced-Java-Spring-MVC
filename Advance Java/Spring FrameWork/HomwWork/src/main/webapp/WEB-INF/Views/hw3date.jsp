<html>
      <%@page import="java.util.List"%>
     <%@page import="Bean.BirthdayDO"%>
      <body>
            <style>
                  body{
                       background-image:url('https://img.freepik.com/free-photo/happy-birthday-with-red-balloons-golden-confetti_280388-1096.jpg');
                       background-repeat:no-repeat;
                       background-attachment:fixed;
                       background-size:cover;
                  }
                  </style>
            <center>
                  <fieldset>
                  <h1 style="color: red;background-color: beige;"><i><u>BirthDate With Name</u></i></h1><br/><br/><br/><br/>
                  </fieldset>
                  <fieldset>
                        <%List<BirthdayDO> list = (List<BirthdayDO>)request.getAttribute("list");
            
                              for(BirthdayDO s : list)
                              { %>
                                      <h2><i> <%= s %> </i></h2>
                              <% } %>
                  </fieldset>
            </center>
      </body>
</html>