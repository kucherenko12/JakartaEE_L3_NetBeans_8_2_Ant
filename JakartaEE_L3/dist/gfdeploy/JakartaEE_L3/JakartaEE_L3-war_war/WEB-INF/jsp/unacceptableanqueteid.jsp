<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 21.05.2023
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Not logged in</title>
    <style>
        body
        {
            background-color: lightseagreen;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        .div-2
        {
            height: 60px;
            width: 150px;
            margin: left;
            color: black;
            background-color: white;
            border: 5px solid white;
        }
        a{color: black;}
    </style>
</head>
<body>
<div class="div-2">
    <p>unacceptable anquete id<br/><a href="${pageContext.request.contextPath}/">search anquetes</a></p>
</div>
</body>
</html>
