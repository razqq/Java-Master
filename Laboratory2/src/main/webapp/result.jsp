<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Returned Words</title>
</head>
<body>
<h1> Returned Words </h1>
<%
    if (request.getAttribute("wordsReturned") != null) {
        Set<String> words = (HashSet<String>) request.getAttribute("wordsReturned");
%>

<ul>
    <%for (String word : words) { %>
    <li><%= word%>
    </li>
    <%}%>
</ul>
<%
} else {
%>

<h1>No words returned.</h1>

<% } %>
</body>
</html>