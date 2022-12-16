<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12/16/2022
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Cerrency</h1>
<form method="get" action="/">
    <table>
        <tr>
            <td> <input type="text" value="USD" disabled="disabled"></td>
            <td><input type="text" name="u" value="${u}"></td>
        </tr>
        <tr>
            <td><input type="text" value="VND" disabled="disabled"></td>
            <td><input type="text" name="v" value="${v}" disabled="disabled"></td>
        </tr>
        <tr><td><input type="submit" value="Converse" name="/"></td></tr>
    </table>
</form>
</body>
</html>
