<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<div id="header"></div>
<div id="nav"></div>
<div class="index">
    <h1>
        欢迎回来，${sessionScope.user.userName}....
    </h1>
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
    .index{
        z-index: 20;
        position: absolute;
        margin-left: 500px;
        margin-top: 200px;
    }
</style>
</html>