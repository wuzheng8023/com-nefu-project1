<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>所有供货商</title>
</head>
<body>
<div id="header"></div>
<div id="nav"></div>
<div class="AllVendor">

    <table>
        <thead>
        <tr>
            <th>名称</th>
            <th>地址</th>
            <th>电话</th>
            <th>传真</th>
            <th>联系人</th>
            <th>更新</th>
        </tr>
        </thead>

        <tbody>

<c:forEach items="${vendorList}" var="list">
    <tr>
        <td>${list.vendor_name}</td>
        <td>${list.vendor_address}</td>
        <td>${list.vendor_phone}</td>
        <td>${list.vendor_fax}</td>
        <td>${list.vendor_contact_person}</td>
        <td>
            <a href="goUpdateVendor?vendor_id=${list.vendor_id}">更新</a>
        </td>
    </tr>
</c:forEach>

        </tbody>
    </table>
   <a href="goAddVendor">添加供货商</a>


</div>
<div id="footer"></div>
</body>
<script src="js/jquery-1.11.0.min.js"></script>
<script>
    $(function () {
        $("#header").load("header.html");
        $("#nav").load("nav.html");
        $("#footer").load("footer.html");
    })
</script>

<style>
    .AllVendor{
        z-index: 20;
        position: absolute;
        margin-left: 500px;
        margin-top: 200px;
    }
    table{
        border: 1px solid black;
        text-align: center;
    }
    td {
        border: 1px solid black;
    }

</style>
</html>
