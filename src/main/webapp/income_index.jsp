<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>所有账单</title>
</head>
<body>
<div id="header"></div>
<div id="nav"></div>

<div class="AllIncome">
    <table>
        <thead>
        <tr>
            <th>部门名称</th>
            <th>交易日期</th>
            <th>更新时间</th>
            <th>当日收入（元）</th>
            <th>更新</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${incomeList}" var="list">
            <tr>
                <td>${list.deptName}</td>
                <td>${list.income.business_date}</td>
                <td>${list.income.lst_mod_timestemp}</td>
                <td>${list.income.daily_income}</td>
                <td>
                    <a href="goUpdateIncome?Income_id=${list.income.income_id}">更新</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <a href="goAddIncome">添加收入</a>
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
    .AllIncome {
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
