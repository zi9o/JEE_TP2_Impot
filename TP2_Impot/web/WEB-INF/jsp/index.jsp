<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <form action="MyControleur" method="get">
            Veuillez entrer les informations suivantes :<br>
            <table>
                <tr>
                    <td>
                        Nom : 
                    </td>
                    <td>
                        <input type="text" name="Nom">
                    </td>
                </tr>
                <tr>
                    <td>
                        Prénom : 
                    </td>
                    <td>
                        <input type="text" name="Prenom">
                    </td>
                </tr>
                <tr>
                    <td>
                        Nombre d'enfants : 
                    </td>
                    <td>
                        <input type="text" name="NbEnfant">
                    </td>
                </tr>
                <tr>
                    <td>
                        Salaire : 
                    </td>
                    <td>
                        <input type="text" name="Salaire">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="radio" name="marie" value="Marie" checked>Marié
                    </td>
                    <td>
                        <input type="radio" name="marie" value="Celibataire">Célibataire
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Envoyer"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
