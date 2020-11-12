<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head >
    <title>账单录入</title>
    <link rel="stylesheet" type="text/css" href="css/buttom.css">
</head>
<body>
<div id="header"></div>
<div id="nav"></div>
<div class="bill">
<form action="toAddPageDeptItem" method="post">
    <label>
       出账日期: <input type="text" name="Bill_date"> <br>
       到账日期: <input type="text" name="Bill_due_Date"><br>
    </label>
    <div>
        <label> 请选择供应商
            <select id="" name="select_Vendor">
                <c:forEach items="${requestScope.list_Vendor}" var="list">
                <option value="${list.vendor_id}"> ${list.vendor_name}</option>
                </c:forEach>
            </select>
        </label>
      <a href="goAddVendor">选择新的供应商</a> <br>
        <input type="submit" value="添加部门账单项">
        <input type="reset" value="重置">
    </div>
</form>
</div>
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
    .bill{
        z-index: 20;
        position: absolute;
        margin-left: 500px;
        margin-top: 200px;
    }
</style>
</html>
