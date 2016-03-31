<%-- 
    Document   : listeParties
    Created on : 30 mars 2016, 14:42:41
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<table>
    <tr>
        <td>Partie</td>
        <td>Joueur en attente</td>
    </tr>
    <c:forEach items="${mesParties}" var="maPartie">
        <tr>
            <td>${maPartie.id}</td>
            <td>
                <c:forEach items="${maPartie.joueurs}" var="joueur">
                    ${joueur.nom} <br/> 
                </c:forEach>
            </td>
            <td><a href="<c:url value="/rejoindrePartieEcran/${maPartie.id}"></c:url>"><input type="button" value=">>Rejoindre<<"/></a></td>
        </tr>   
    </c:forEach>
</table>

