<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>部门信息</title>
</head>
<body>
<div id="header"></div>
<div id="nav"></div>
<div class="dept_index">
    <table>
        <thead>
        <tr>
            <th>部门名称</th>
            <th>描述</th>
            <th>更新</th>
        </tr>
        </thead>
        <tbody>
<c:forEach items="${requestScope.listDept}" var="dept">
<tr>
<td>${dept.dept_name}</td>
<td>${dept.dept_description}</td>
 <td><a href="toUpdatePageDept?Dept_id=${dept.dept_id}">修改</a></td>
</tr>
</c:forEach>
        </tbody>
    </table>
    <a href="toAddPageDept">添加</a>
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
    .dept_index{
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
