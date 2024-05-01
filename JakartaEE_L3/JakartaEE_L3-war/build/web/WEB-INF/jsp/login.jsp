<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 17.04.2024
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        @font-face {
            font-family: "AdvertisingScriptBold";
            src: url("/advertisingscriptbold.eot");
            src: url("/advertisingscriptbold.eot?#iefix")format("embedded-opentype"),
            url("https://db.onlinewebfonts.com/t/7e4ecf6369503f3016079002af6825ff.woff2")format("woff2"),
            url("/advertisingscriptbold.woff")format("woff"),
            url("/advertisingscriptbold.ttf")format("truetype"),
            url("/advertisingscriptbold.svg#Advertising Script Bold")format("svg");
        }
    </style>
</head>
<body>
<div style="height: 100px; width: 100%; background-color: lightseagreen; color: white">
    <div style="height: 100px; width: min-content; margin: auto">
        <p style="font-family: AdvertisingScriptBold; font-size:72px">Meet</p>
    </div>
</div>
<div style="height: 10px; width: 164px; margin: auto; background-color:black">

</div>
<div style="width: 100%; height: min-content">
    <div style="width: 300px; height: min-content; margin-left: calc(50% - 218px); text-align: right">
        <form name="loginForm" method="post" action="loginpost" style="margin: auto">
            <div>Username: <input type="text" name="username"/><br/></div>
            <div>Password: <input type="password" name="password"/><br/></div>
            <div><input style="width: 164px" type="submit" value="Login" /></div>
        </form>
    </div>
</div>
</body>
</html>
