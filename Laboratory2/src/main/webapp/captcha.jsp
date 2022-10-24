<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String captchaImage = "";
    if (request.getAttribute("captchaImage") != null) {
        captchaImage = request.getAttribute("captchaImage").toString();
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Captcha</title>
</head>
<body>
<h1>Captcha</h1>
<img src="data:image/png;base64,<%=captchaImage%>"/>
<form action="lab2-servlet" method="POST">
    Circles count: <input name="circlesGuessed" value="0"> <br/>
    <input type="submit" value="Send data">
</form>
</body>