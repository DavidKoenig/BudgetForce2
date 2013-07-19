<%-- 
    Document   : index
    Created on : 03.06.2013, 21:45:53
    Author     : Soi Fon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="budgetforce.control.servlets.SessionLogin" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BudgetForce</title>
    </head>
    <body>
        
        <%
            if(session.getAttribute("loggedIn") == null)
            {%>
                <a href="register.jsp">Registrieren</a>
                <form method="post" action="login" name="loginForm">
                    Benutzername:<input type="text" name="username" id="username">
                    Passwort:<input type="password" name="password" id="password">
                    <input type="submit">
                </form>
            <%}
            else
            {
                SessionLogin sessionLogin = (SessionLogin)session.getAttribute("loggedIn");
                if(sessionLogin.loggedIn)
                {%>
                    Hallo <%= session.getAttribute("username") %><br>
                    <form method="post" action="logout" name="logoutForm">
                        <input type="submit" value="Logout">
                    </form>
                <%}
            }%>
            
            <form method="POST" action="api/outgoing/7/receipt" enctype="multipart/form-data" >
                File:
                <input type="file" name="file" id="file" /><br/>
                <input type="hidden" value="20" name="personID" id ="personID" />
                <input type="hidden" value="2" name="outgoingID" id ="outgoingID" />
                <input type="submit" value="Upload" name="upload" id="upload" />
            </form>
            
            
            <form method="POST" action="register" enctype="multipart/form-data" >
                <input type="submit" value="Test" name="upload" id="upload" />
            </form>          
                    

    </body>
</html>
