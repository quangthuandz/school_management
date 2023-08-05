<%-- 
    Document   : Login
    Created on : Mar 6, 2023, 8:22:33 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css">
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
    </head>
    <body>
        <%
            String error="";
            if(request.getAttribute("error")!= null){
                error = (String)request.getAttribute("error");
            }
            
            String val="";
            if(request.getAttribute("val")!= null){
                val = (String)request.getAttribute("val");
            }
        %>
        
        <div class="box">
            <div class="container">
                <div class="header">
                    <header>EOS ADMIN</header>
                </div>
                <form action="login" method="post">
                    <div class="input-field">
                        <input type="text" class="input" name="username" placeholder="Username"/>
                    </div>

                    <div class="input-field">
                        <input type="password" class="input" name="password" placeholder="Password" />
                    </div>
                    
                    <div>
                        <h4 style="color: red"><%=error%></h4>
                        <h4 style="color: red"><%=val%></h4>
                    </div>
                    <div class="input-field">
                        <input type="submit" class="submit" name="submit" value="Login"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
