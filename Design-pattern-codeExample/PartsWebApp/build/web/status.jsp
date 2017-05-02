<%-- 
    Document   : statud
    Created on : 01-05-2017, 21:11:08
    Author     : TM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "part" class="model.Part" scope = "request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Status Page</title>
    </head>
    <body>
        <h1>Status Page!</h1>
        <% if (request.getAttribute("part") != null) {%>
        <i>      <%= request.getAttribute("part")%></i>
        <% }%>        
        <br>    
         <b> Part once more: <jsp:getProperty name = "part" property="pno"/> </b>
    </body>
</html>
