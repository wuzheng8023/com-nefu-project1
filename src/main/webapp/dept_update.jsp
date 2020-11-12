<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
<div id="header"></div>
<div id="nav"></div>
<div class="updateDept">
<form action="updateDept" method="post">
<label>
    部门名称:  <input type="text" name="Dept_name" value="${requestScope.dept.dept_name}"> <br><br>
    部门描述:  <input type="text" name="Dept_description" value="${requestScope.dept.dept_description}"> <br><br>
<input type="hidden" name="Dept_id" value="${requestScope.dept.dept_id}"><br><br>
<input type="hidden" name="Dept_flag" value="${requestScope.dept.flag}"> <br><br>
</label>
<input type="submit" value="修改部门">
<input type="reset" value="重置">
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
    .updateDept{
        z-index: 20;
        position: absolute;
        margin-left: 500px;
        margin-top: 200px;
    }
</style>
</html>
