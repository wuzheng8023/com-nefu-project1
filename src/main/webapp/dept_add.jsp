<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加页面</title>
</head>
<body>
<div id="header"></div>
<div id="nav"></div>
<div class="addDept">
<form action="addDept" method="post">
    部门名称: <input type="text" name="Dept_name"> <br><br>
    部门描述: <input type="text" name="Dept_description"><br><br>
    <input type="submit" value="添加部门">
    <input type="reset" value="重置" id="button_reset">
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
    .addDept{
        z-index: 20;
        position: absolute;
        margin-left: 500px;
        margin-top: 200px;
    }
</style>
</html>
