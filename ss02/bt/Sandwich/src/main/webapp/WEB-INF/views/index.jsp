<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12/17/2022
  Time: 6:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1> Sandwich Condiments</h1>
  <form method="post" action="/save">
      <input type="checkbox" name="l" value="Lettuce"><label>Lettuce</label>
      <input type="checkbox" name="t" value="Tomato"><label>Tomato</label>
      <input type="checkbox" name="m" value="Mustard"><label>Mustard</label>
      <input type="checkbox" name="s" value="Sprouts"><label>Sprouts</label><br>
    <input type="submit" value="Save" name="/save">
  </form>
  <b>${l} </b>
  <b>${t} </b>
  <b>${m} </b>
  <b>${s} </b>
  </body>
</html>
