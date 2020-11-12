<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>支付账单</title>
</head>
<body>
<div id="header"></div>
<div id="nav"></div>
<div class="vendorpay">
    <table>
        <thead>
        <tr>
            <th>供货商名称</th>
            <th>下单日期</th>
            <th>支付日期</th>
            <th>标记支付</th>
            <th>更新</th>
        </tr>
        </thead>
        <c:forEach items="${billlist}" var="list">

            <tr>
                <td>${vname}</td>
                <td>${list.bill_date}</td>
                <td>${list.bill_due_Date}</td>
                <td>
                    <input type="checkbox">
                </td>

                <td>
                    <a href="updateBill?bill_id=${list.bill_id}&vname=${vname}">更新</a>
                </td>
            </tr>
        </c:forEach>
        <tbody>

        </tbody>
    </table>

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
    .vendorpay {
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
