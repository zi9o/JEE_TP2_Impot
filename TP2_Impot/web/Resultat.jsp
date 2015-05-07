<%-- 
    Document   : Resultat
    Created on : 7 mai 2015, 20:44:05
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
        <div style="alignment-adjust: central">
            <p>Votre Impot est : <% out.print( request.getAttribute("Impot")); %></p>
        </div>
    </body>
</html>
