<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12/16/2022
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Translate</h1>
  <form method="get" action="/home">
    <table>
      <tr>
        <td> <input type="text" value="English" disabled="disabled"></td>
        <td><input type="text" name="english" value="${english}"></td>
      </tr>
      <tr>
        <td><input type="text" value="Vietnamese" disabled="disabled"></td>
        <td><input type="text" name="vietnamese" value="${vietnamese}" disabled="disabled"></td>
      </tr>
      <tr><td><input type="submit" value="Translate" name="/home"></td></tr>
    </table>
  </body>
</html>
