<%-- 
    Document   : ajout_joueur
    Created on : 30 mars 2016, 16:17:23
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JungleSpeed</title>
    </head>
    <body>
        <form:form modelAttribute="joueur" action="" method="post">
            Pseudo : <form:input path="nom"/>
            <form:hidden path="id"/>
            <form:hidden path="partie.id"/>
            <form:hidden path="nbCartes"/>
            <input type="submit"/>
        </form:form>
    </body>
</html>
