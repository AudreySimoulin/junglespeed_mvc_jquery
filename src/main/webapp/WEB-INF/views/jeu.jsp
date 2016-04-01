<%-- 
    Document   : jeu
    Created on : 31 mars 2016, 09:08:11
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JungleSpeed</title>
        <link href="<c:url value="/CSS/style1.css"></c:url>" rel="stylesheet" type="text/css"/>
        <script src="<c:url value="/JS/jquery-2.2.2.js"></c:url>" type="text/javascript"></script>
        <script src="<c:url value="/JS/partie.js"></c:url>" type="text/javascript"></script>
<!--        <script type="text/javascript">
                var refresh = function () {

                    $('#zoneCartes').load();
                }
                window.setTimeout(refresh, 1000);
        </script>-->
        </head>
        <body class="jeu" onload="">
            <div class="totem">
                <a href=""><img src="<c:url value="/Images/totem.png"></c:url>" alt=""/></a>
            </div>

            <div id="zoneCartes">
                <div class="joueurD">
                    Joueur : ${joueur0.nom} <br>
                Nombre de cartes : ${joueur0.nbCartes}
            </div>

            <div class="carteD" style="background-color: ${joueur0.couleur}">
            </div>

            <div class="joueurG">
                Joueur : ${joueur1.nom} <br/>
                Nombre de cartes : ${joueur1.nbCartes} 
            </div>

            <div class="carteG" style="background-color: ${joueur1.couleur}">
            </div>
        </div>
    </body>
</html>
