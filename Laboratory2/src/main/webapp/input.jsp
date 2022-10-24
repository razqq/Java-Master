<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Input</title>
</head>
<body>
<h1><%= "Input files" %>
</h1>
<br/>
<form action="captcha" method="GET">
    Word: <input name="word" value="anaare"> <br/>
    Size:  <input name="size" value="3"> <br/>
    Category: <input name="category" value="test"> <br/>
    <input type="submit" value="Send data">
</form>
</body>
</html>