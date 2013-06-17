<%-- 
    Document   : register
    Created on : 03.06.2013, 21:48:47
    Author     : Soi Fon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrieren</title>
    </head>
    <body>
        <form name="registrationForm" method="post" action="register">
            <table>
                <tr>
                    <td>Benutzername:*</td>
                    <td><input type="text" name="username" id="username"></td>
                </tr>
                <tr>
                    <td>Passwort:*</td>
                    <td><input type="password" name="password1" id="password1"></td>
                </tr>
                <tr>
                    <td>Wdh. Passwort:*</td>
                    <td><input type="password" name="password2" id="password2"></td>
                </tr>
                <tr>
                    <td>Sicherheitsfrage:*</td>
                    <td><input type="text" name="securityQuestion" id="securityQuestion"></td>
                </tr>
                <tr>
                    <td>Vorname:*</td>
                    <td><input type="text" name="firstName" id="firstName"></td>
                </tr>
                <tr>
                    <td>Nachname:*</td>
                    <td><input type="text" name="lastName" id="lastName"></td>
                </tr>
                <th><input type="submit"></th>
            </table>     
        </form>
    </body>
</html>
