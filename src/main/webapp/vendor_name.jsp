<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>检索供货商</title>
</head>
<body>
<div id="header"></div>
<div id="nav"></div>
<div class="vendorName">

    <form action="goVendorPay" method="post">
    <label>  <p>供货商姓名:</p> <input type="text" name="vendorname"></label>

        <button type="submit">查询</button>
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
    .vendorName {
        z-index: 20;
        position: absolute;
        margin-left: 500px;
        margin-top: 200px;
    }
</style>
</html>
