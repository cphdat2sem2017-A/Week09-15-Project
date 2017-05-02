<%-- 
    Document   : updatePart
    Created on : 01-05-2017, 18:08:25
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
        <h1>Update part</h1>
        <form action= "FrontControllerNewer" method="POST">
            Part no.:<input type="text" name="pno" value="" />
            QOH: <input type="text" name="qoh" value="" />
            <input type="submit" value="Update part" />
            <input type="hidden" name="cmd" value="update-part" />
        </form>
    </body>
</html>
