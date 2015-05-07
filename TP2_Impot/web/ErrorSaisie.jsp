<%-- 
    Document   : ErrorSaisie
    Created on : 7 mai 2015, 19:31:45
    Author     : zakaria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="alignment-adjust: central">Erreur de saisie</h1>
        <br>
        <br>
        <p style="alignment-adjust: central"> Vous devez saisir le <% out.print(request.getAttribute("erreur"));%></p>
        <br>
        <br>
        <FORM><INPUT Type="button" VALUE="Retour" onClick="history.go(-1);return true;"></FORM>
    </body>
</html>
