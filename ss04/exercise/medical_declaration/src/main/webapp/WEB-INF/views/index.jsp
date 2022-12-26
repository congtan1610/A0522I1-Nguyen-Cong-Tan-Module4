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
    <title>Medical Declaration</title>
    <style>
        * {
            border-spacing: 0px;
        }

        a {
            text-decoration: none;
            color: white;
        }

        button {
            border-radius: 5px;
            background-color: lawngreen;
            border: none;
            height: 30px;
        }

        .front tr td {
            width: 30%;
            border: darkgrey 1px solid;
        }

        .fronta tr td {
            width: 72%;
            border: darkgrey 1px solid;
        }

        .front tr th {
            border: darkgrey 1px solid;
            width: 6%;
        }

        .fronta tr th {
            border: darkgrey 1px solid;
            width: 6%;
        }
    </style>
</head>
<body>
<center><h2>TỜ KHAI Y TẾ</h2></center>
<center><h4>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
    DỊCH BÊNH TRUYỀN NHIỄM</h4></center>
<center><b style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị xử lý hình
    sự</b></center>
<form:form action="/save" method="post" autocomplete="true">
    <form:form modelAttribute="userInf">
        <table width="100%">
            <tr>
                <td colspan="6">
                    <form:label path="name">Họ tên (ghi chữ IN HOA)</form:label><br>
                    <form:input path="name" cssStyle="width: 100%"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:label path="year">Năm sinh</form:label><br>
                    <form:select path="year" cssStyle="width: 100%">
                        <form:options items="${years}"></form:options>
                    </form:select>
                </td>
                <td colspan="2">
                    <form:label path="gender">Giới tính</form:label><br>
                    <form:select path="gender" cssStyle="width: 100%">
                        <form:options items="${genders}"></form:options>
                    </form:select>
                </td>
                <td colspan="2">
                    <form:label path="national">Quốc tịch</form:label><br>
                    <form:select path="national" cssStyle="width: 100%">
                        <form:options items="${nationals}"></form:options>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="6">
                    <form:label
                            path="idCard">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</form:label><br>
                    <form:input path="idCard" cssStyle="width: 100%"/>
                </td>
            </tr>
            <tr>
                <td colspan="6">
                    <form:label path="vehicle">Thông tin đi lại</form:label><br>
                    <form:radiobuttons path="vehicle" items="${vehicles}"/>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <form:label path="idVehicle">Số hiệu phương tiện</form:label><br>
                    <form:input path="idVehicle" cssStyle="width: 100%"/>
                </td>
                <td colspan="3">
                    <form:label path="seats">Số ghế</form:label><br>
                    <form:input path="seats" cssStyle="width: 100%"/>
                </td>
            </tr>
            <tr>
                <td colspan="3"><form:label path="departureDay">Ngày khởi hành</form:label></td>
                <td colspan="3"><form:label path="closingDay">Ngày kết thúc</form:label></td>
            </tr>
            <tr>
                <td>
                    <form:select path="departureDay.day" cssStyle="width: 100%">
                        <form:options items="${days}"></form:options>
                    </form:select>
                </td>
                <td>
                    <form:select path="departureDay.month" cssStyle="width: 100%">
                        <form:options items="${months}"></form:options>
                    </form:select>
                </td>
                <td>
                    <form:select path="departureDay.year" cssStyle="width: 100%">
                        <form:options items="${years}"></form:options>
                    </form:select>
                </td>
                <td>
                    <form:select path="closingDay.day" cssStyle="width: 100%">
                        <form:options items="${days}"></form:options>
                    </form:select>
                </td>
                <td>
                    <form:select path="closingDay.month" cssStyle="width: 100%">
                        <form:options items="${months}"></form:options>
                    </form:select>
                </td>
                <td>
                    <form:select path="closingDay.year" cssStyle="width: 100%">
                        <form:options items="${years}"></form:options>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="6">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?</td>
            </tr>
            <tr>
                <td colspan="6">
                    <form:textarea path="travelSchedule" cssStyle="width: 100%" rows="5"></form:textarea>
                </td>
            </tr>
        </table>
    </form:form>
    <form:form modelAttribute="contact">
        <table width="100%">
            <tr>
                <td colspan="6"><b>Địa chỉ liên lạc</b></td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:label path="city">Tỉnh/thành</form:label><br>
                    <form:select path="city" cssStyle="width: 100%">
                        <form:options items="${citys}"></form:options>
                    </form:select>
                </td>
                <td colspan="2">
                    <form:label path="district"> Quận/huyện</form:label><br>
                    <form:select path="district" cssStyle="width: 100%">
                        <form:options items="${districts}"></form:options>
                    </form:select>
                </td>
                <td>
                    <form:label path="warm">Phường/xã</form:label><br>
                    <form:select path="warm" cssStyle="width: 100%">
                        <form:options items="${warms}"></form:options>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="6">
                    <form:label path="addressOfResidence">Địa chỉ nơi ở</form:label><br>
                    <form:input path="addressOfResidence" cssStyle="width: 100%"></form:input>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <form:label path="phone">Điện thoại</form:label><br>
                    <form:input path="phone" cssStyle="width: 100%"></form:input>
                </td>
                <td colspan="3">
                    <form:label path="email">Email</form:label><br>
                    <form:input path="email" cssStyle="width: 100%"></form:input>
                </td>
            </tr>
        </table>
    </form:form>
    <form:form modelAttribute="symptom">
        <p>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không?</p>
        <table class="front" width="100%">
            <tr style="background-color: lightgray">
                <td>
                    <b>Triệu chứng</b>
                </td>
                <th>Có</th>
                <th>Không</th>
                <td>
                    <b>Triệu chứng</b>
                </td>
                <th>Có</th>
                <th>Không</th>
            </tr>
            <tr>
                <td>
                    <p>Sốt</p>
                </td>
                <th><form:radiobutton path="fever" value="yes"/></th>
                <th><form:radiobutton path="fever" value="no"/></th>
                <td>
                    <p>Nôn/buồn nôn</p>
                </td>
                <th><form:radiobutton path="vomit" value="yes"/></th>
                <th><form:radiobutton path="vomit" value="no"/></th>
            </tr>
            <tr>
                <td>
                    <p>Ho</p>
                </td>
                <th><form:radiobutton path="cough" value="yes"/></th>
                <th><form:radiobutton path="cough" value="no"/></th>
                <td>
                    <p>Tiêu chảy</p>
                </td>
                <th><form:radiobutton path="diarrhea" value="yes"/></th>
                <th><form:radiobutton path="diarrhea" value="no"/></th>
            </tr>
            <tr>
                <td>
                    <p>Khó thở</p>
                </td>
                <th><form:radiobutton path="shortnessOfBreath" value="yes"/></th>
                <th><form:radiobutton path="shortnessOfBreath" value="no"/></th>
                <td>
                    <p>Xuất huyết ngoài da</p>
                </td>
                <th><form:radiobutton path="skinHemorrhage" value="yes"/></th>
                <th><form:radiobutton path="skinHemorrhage" value="no"/></th>
            </tr>
            <tr>
                <td>
                    <p>Đau họng</p>
                </td>
                <th><form:radiobutton path="soreThroat" value="yes"/></th>
                <th><form:radiobutton path="soreThroat" value="no"/></th>
                <td>
                    <p>Nổi ban ngoài da</p>
                </td>
                <th><form:radiobutton path="skinRash" value="yes"/></th>
                <th><form:radiobutton path="skinRash" value="no"/></th>
            </tr>
        </table>
        <br>
        <b>Lịch sử phơi nhiễm: Trong vòng 14 ngày qua Anh/Chị có</b>
        <table class="fronta" width="100%">
            <tr style="background-color: lightgray">
                <td colspan="4">
                </td>
                <th>Có</th>
                <th>Không</th>
            </tr>
            <tr>
                <td colspan="4">
                    <p>Đến trang trại chăn nuôi/ chợ buôn bán động vật sống/ cơ sở giết mổ động vật/ tiếp xúc động
                        vật</p>
                </td>
                <th><form:radiobutton path="exposure1" value="yes"/></th>
                <th><form:radiobutton path="exposure1" value="no"/></th>
            </tr>
            <tr>
                <td colspan="4">
                    <p>Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV</p>
                </td>
                <th><form:radiobutton path="exposure2" value="yes"/></th>
                <th><form:radiobutton path="exposure2" value="no"/></th>
            </tr>
        </table>
    </form:form>
    <p style="color: red">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho phòng chống dịch, thuộc quản lí của
        Ban chỉ đạo quốc
        gia về Phòng chống dịch Covid-19.<br>Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý.</p>
    <center>
        <button><a href="/save">GỬI TỜ KHAI</a></button>
    </center>
</form:form>
</body>
</html>
