<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 14.04.2024
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>AnqueteSearch</title>
    <style>
      #customers {
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
      }

      #customers td, #customers th {
        border: 1px solid #ddd;
        padding: 8px;
      }

      #customers tr:nth-child(even){background-color: #f2f2f2;}

      #customers tr:hover {background-color: #ddd;}

      #customers th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: lightseagreen;
        color: white;
      }
    </style>
  </head>
  <body>
    <a href="logoutpost">Log out</a>
    <br>
    <a href="anqueteedit">Edit anquete</a>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <p>AnqueteSearch</p>
    <form name="AnqueteSearchForm" method="get" action="anquetesearch" style="margin: auto">
      Tags: <input style="width: 1000px" type="text" name="tags"/>
      <input style="width: 164px" type="submit" value="Search"/>
    </form>

    <table id="customers">
      <thead>
      <tr class="tbb">
        <th class="tbb">Name</th>
        <th class="tbb">Age</th>
        <th class="tbb">Short info</th>
        <th class="tbb">Keywords</th>
        <th class="tbb">Gender</th>
      </tr>
      </thead>

      <c:if test="${not empty requestScope.anquetes}">
        <tbody>
        <c:forEach items="${requestScope.anquetes}" var="anquete">
          <tr class="tbb">
            <td class="tbb"><a href="${pageContext.request.contextPath}/anquete?id=${anquete.id}">${anquete.name}</a></td>
            <td class="tbb">${anquete.age}</td>
            <td class="tbb">${anquete.shortinfo}</td>
            <td class="tbb">${anquete.keywordsstring}</td>
            <c:choose>
              <c:when test="${anquete.genderstring == 'MALE'}">
                <td class="tbb" style="color: blue">${anquete.genderstring}</td>
              </c:when>
              <c:when test="${anquete.genderstring == 'FEMALE'}">
                <td class="tbb" style="color: deeppink">${anquete.genderstring}</td>
              </c:when>
            </c:choose>
          </tr>
        </c:forEach>
        </tbody>
      </c:if>
    </table>
    <c:if test="${empty requestScope.anquetes}"><p>requestScope.anquetes IS EMPTY</p></c:if>

  </body>
</html>
