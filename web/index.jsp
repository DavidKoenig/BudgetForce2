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
        <a href="register.jsp">Registrieren</a>
        <%
            if(session.getAttribute("loggedIn") == null)
            {%>
                <form method="post" action="login" name="loginForm">
                    Benutzername:<input type="text" name="username" id="username">
                    Passwort:<input type="password" name="password" id="password">
                    <input type="submit">
                </form>
            <%
            }
            else
            {
                SessionLogin sessionLogin = (SessionLogin)session.getAttribute("loggedIn");
                if(sessionLogin.loggedIn)
                {
                %>
                    Hallo <% session.getAttribute("username"); %>
                <%                
                }
            }
            %>
    </body>
</html>