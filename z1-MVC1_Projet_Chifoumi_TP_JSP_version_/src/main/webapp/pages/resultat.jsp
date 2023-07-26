<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String result = (String)request.getAttribute("resultat");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultat</title>
</head>
<body>
<h1>voici le resultat</h1>
<h2>
<%= result %>
</h2>

</body>
</html>