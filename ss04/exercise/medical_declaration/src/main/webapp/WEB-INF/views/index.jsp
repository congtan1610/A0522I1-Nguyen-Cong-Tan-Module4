<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12/25/2022
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<center><h2>TỜ KHAI Y TẾ</h2></center>
<center><h4>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
    DỊCH BÊNH TRUYỀN NHIỄM</h4></center>
<center><b style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị xử lý hình
    sự</b></center>
<form:form action="/save" method="post">
    <form:form modelAttribute="userInf">
        <table width="100%">
            <tr>
                <td colspan="3">
                    <form:label path="name">Họ tên (ghi chữ IN HOA)</form:label><br>
                    <form:input path="name" cssStyle="width: 100%"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="year">Năm sinh</form:label><br>
                    <form:select path="year" cssStyle="width: 100%">
                        <form:options items="${years}"></form:options>
                    </form:select>
                </td>
                <td>
                    <form:label path="gender">Giới tính</form:label><br>
                    <form:select path="gender" cssStyle="width: 100%">
                        <form:options items="${genders}"></form:options>
                    </form:select>
                </td>
                <td>
                    <form:label path="national">Quốc tịch</form:label><br>
                    <form:select path="national" cssStyle="width: 100%">
                        <form:options items="${nationals}"></form:options>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <form:label path="idCard">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</form:label><br>
                    <form:input path="idCard" cssStyle="width: 100%"/>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <form:label path="vehicle">Thông tin đi lại</form:label><br>
                    <form:radiobuttons path="vehicle" items="${vehicles}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="idVehicle">Số hiệu phương tiện</form:label><br>
                    <form:input path="idVehicle"  />
                </td>
                <td>
                    <form:label path="seats">Số ghế</form:label><br>
                    <form:input path="seats"  />
                </td>
                <td></td>
            </tr>
        </table>
    </form:form>
</form:form>
</body>
</html>
