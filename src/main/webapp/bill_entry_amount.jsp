<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>账单条目录入界面2</title>
    <script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet"
          href="webjars/bootstrap/3.3.5/css/bootstrap.min.css"/>
</head>
<body>
<div id="header"></div>
<div id="nav"></div>
<div class="addBill">
<div>
    开出账单日期: ${sessionScope.table_bill.bill_date} 供应商名称: ${sessionScope.table_vendor.vendor_name}
</div>
<form action="addBill" method="post">
    <table>
        <thead>
        <tr>
            <th>部门名称</th>
            <th>金额</th>
            <th>确认</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.dept_list}" var="list">
            <tr>
                <td>${list.dept_name}</td>
                    <%--            <td><label><input type="text" name="texts" value="0"></label></td>--%>
                <td><label><input type="text" name="${list.dept_id}" value="0"></label></td>
                <td><input type="checkbox" name="checkboxs" value="${list.dept_id}"></td>
            </tr>
        </c:forEach>
        <tr>
            <td>总金额</td>
            <td><label><input type="text" name="amount"></label></td>
            <td></td>
        </tr>
        </tbody>
    </table>

    <label>
        <input type="submit" value="提交"> <input type="reset" value="重置">
    </label>
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
    .addBill{
        z-index: 20;
        position: absolute;
        margin-left: 500px;
        margin-top: 200px;
    }
</style>
</html>
