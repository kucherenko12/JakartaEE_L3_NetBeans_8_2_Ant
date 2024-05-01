<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 14.04.2024
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.anquete.name}</title>
</head>
<body>
    <h1>${requestScope.anquete.name}</h1>
    <p>${requestScope.anquete.age} years</p>
    <p>${requestScope.anquete.shortinfo}</p>
    <p>${requestScope.anquete.keywordsstring}</p>
    <p>${requestScope.anquete.genderstring}</p>
</body>
</html>
