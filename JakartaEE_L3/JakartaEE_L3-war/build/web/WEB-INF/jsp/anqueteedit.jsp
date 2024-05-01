<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 14.04.2024
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit anquete</title>
</head>
<body>
    <form name="AnqueteEditForm" method="get" action="anquetesearch" style="margin: auto"><br>
      Name: <input style="width: 1000px" type="text" name="name"/><br>
      Age: <input style="width: 1000px" type="text" name="age"/><br>
      Shortinfo: <input style="width: 1000px" type="text" name="shortinfo"/><br>
      Gender: <select name="gender" id="gender"><br>
          <option value="MALE">MALE</option>
          <option value="FEMALE">FEMALE</option>
      </select><br>
      Keywords: <input style="width: 1000px" type="text" name="tags"/><br>
    <input style="width: 164px" type="submit" value="Change"/>
  </form>
</body>
</html>
