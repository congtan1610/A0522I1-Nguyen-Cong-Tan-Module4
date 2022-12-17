<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12/17/2022
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form method="get" action="/cal">
    <input type="text" name="a" value="${a}">
    <input type="text" name="b" value="${b}"><br><br>
    <input type="submit" name="cal" value="Addition">
    <input type="submit" name="cal" value="Subtraction">
    <input type="submit" name="cal" value="Multiplication">
    <input type="submit" name="cal" value="Division">
  </form>
  <b>Result ${mes} : ${result}</b>
  </body>
</html>
