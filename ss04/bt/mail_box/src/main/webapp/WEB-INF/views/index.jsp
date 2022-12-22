<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12/21/2022
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        select, button {
            border-radius: 5px;
        }

        button {
            background-color: white;
            margin-right: 10px;
            width: 70px;
        }
        button:hover{
            background-color: aqua;
        }
    </style>
</head>
<body>
<h1>Settings</h1>
<form:form action="/save" method="post" modelAttribute="boxMail">
    <table>
        <tr>
            <td><b>languages</b></td>
            <td><form:select path="language">
                <form:options items="${languages}"></form:options>
            </form:select></td>
        </tr>
        <tr>
            <td><b>page size</b></td>
            <td><form:select path="pageSize">
                <form:options items="${sizes}"></form:options>
            </form:select></td>
        </tr>
        <tr>
            <td><b>spams filter</b></td>
            <td>
                <form:checkbox path="spams" value="Enable"/>Enable spams filter
            </td>
        </tr>
        <tr>
            <td><b style="position: relative;top:-40px">Signature</b></td>
            <td>
                <form:textarea path="signature" rows="6" cols="20"/>
            </td>
        </tr>
        <tr>
            <td>
            </td>
            <td>
                <button type="submit">update</button>
                <button type="button" ><a href="/" style="text-decoration: none;color: black">cancle</a></button>
            </td>
        </tr>
    </table>
</form:form>
<b>${msg}</b>
</body>
</html>
