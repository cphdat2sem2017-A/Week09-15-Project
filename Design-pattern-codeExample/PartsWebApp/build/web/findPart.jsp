<%-- 
    Document   : findPart
    Created on : 01-05-2017, 21:29:47
    Author     : TM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part Page</title>
    </head>
    <body>
        <h1>Search for part!</h1>
        <form action= "FrontControllerNewer" method="POST">
            Part no.:<input type="text" name="pno" value="" />           
            <input type="submit" value="Search part" />
            <input type="hidden" name="cmd" value="get-part" />
        </form>
    </body>
    </body>
</html>
