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
      <input type="checkbox" name="lettuce" value="Lettuce"><label>Lettuce</label>
      <input type="checkbox" name="tomato" value="Tomato"><label>Tomato</label>
      <input type="checkbox" name="mustard" value="Mustard"><label>Mustard</label>
          <input type="checkbox" name="sprouts" value="Sprouts"><label>Sprouts</label><br>
    <input type="submit" value="Save" name="/save">
  </form>
  <b>${lettuce} </b>
  <b>${tomato} </b>
  <b>${mustard} </b>
  <b>${sprouts} </b>
  </body>
</html>
