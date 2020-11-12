<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>添加账单</title>
</head>
<body>
<div id="header"></div>
<div id="nav"></div>
<div  class="addIncome">
<form action="addIncome" method="post">
    <label> 请选择部门
        <select id="" name="dept_id">
            <c:forEach items="${listDept}" var="list">
                <option value="${list.dept_id}" > ${list.dept_name}</option>
            </c:forEach>
        </select>
    </label>
    <br>
    <label>本日收入： <input type="text" name="daily_income"></label>
    <br>
    <button type="submit" >添加</button>
    <button type="reset">重置</button>
</form>
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
    .addIncome {
        z-index: 20;
        position: absolute;
        margin-left: 500px;
        margin-top: 200px;
    }
</style>
</html>
