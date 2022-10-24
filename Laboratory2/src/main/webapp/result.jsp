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
    String wordd ="no input";
    if (request.getAttribute("word") != null) {
        wordd = (String) request.getAttribute("word");
    }
    String size = "nu input";
    if (request.getAttribute("size") != null) {
        size = (String) request.getAttribute("word");
    }
    if (request.getAttribute("wordsReturned") != null) {
        Set<String> words = (HashSet<String>) request.getAttribute("wordsReturned");
%>

<h2><%=wordd%></h2>
<h2><%=size%></h2>
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