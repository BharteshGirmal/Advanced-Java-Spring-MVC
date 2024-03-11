<html>
      <style>
            body{
                 background-image:url('https://png.pngtree.com/background/20210712/original/pngtree-abstract-modern-neon-frame-background-picture-image_1178251.jpg');
                 background-repeat:no-repeat;
                 background-attachment:fixed;
                 background-size:cover;
                 color: rgb(36, 13, 4);
            }
            </style>
      <body>
            <form action="hw2Check">
            <center>
                  <h1 style="background-color: tomato;"><u>Login</u></h1>
                  <br/>
                  <br/>
                  <br/>
                  <fieldset style=" color: beige; border-width: 0.2cm;border-color: rgb(247, 120, 97);border-style: double; width: 7cm;height: 7cm;">
                              <h2>Enter the User Name</h2>
                             <br/><input type="text" name="uname"/>
                             <br/><h2>Enter the Password</h2>
                             <br/><input type="password" name="pass"/>
                              <br/><br/><input type="submit" value="Login"/>
                  </fieldset>
                  </center>
            </form>
             <center>
                  <%String str=(String)request.getAttribute("msg");
                  if(str!=null)
                  {%>
                  <h3><i><u><p style="color: red;"><%=str%></u></i></p></h3>
                  <%}%> 
             </center>
      </body>
</html>