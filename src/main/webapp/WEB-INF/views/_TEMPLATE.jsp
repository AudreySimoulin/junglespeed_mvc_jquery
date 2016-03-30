<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="monApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Streaming</title>
        <link href="<c:url value="/CSS/style1.css"/>" rel="stylesheet" type="text/css"/>
        <script src="<c:url value="/JS/jquery-2.2.2.js"/>" type="text/javascript"></script>
        <script type="text/javascript">

            var urlAppli = '<c:url value="/"/>';

            function montreSablier() {
                $('.sablier').show();
            }

            function cacheSablier() {
                $('.sablier').hide();
            }

            function onLoad() {

                cacheSablier();

                $(document).ajaxSend(function () {
                    montreSablier();
                });

                $(document).ajaxError(function () {
                    cacheSablier();
                });

                $(document).ajaxSuccess(function () {
                    cacheSablier();
                });
            }

            function chargeContenu(route) {

                $(".content").load(urlAppli + route);
            }

        </script>
    </head>
    <body onload="onLoad();">
        <div class="sablier">
            <img src="<c:url value="/Images/sablier.gif"/>" alt=""/>
        </div>
        <div class="menu"> 
            <c:import url="_MENU.jsp" />
        </div>
        <div class="content"> 
            coucou
        </div>
        <div class="footer">
            <c:import url="_FOOTER.jsp"/>
        </div>
    </body>
</html>
