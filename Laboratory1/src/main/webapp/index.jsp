<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "First laboratory" %>
</h1>
<br/>
<form action="lab1-servlet" method="get">
    Word: <input name="word" value="anaare"> <br/>
    Size:  <input name="size" value="3"> <br/>
    <input type="submit" value="Send data">
</form>
</body>
</html>