<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>添加供货商</title>
</head>
<body>
<div id="header"></div>
<div id="nav"></div>
<div class="addVendor">
    <form action="addVendor" method="post">

        <p>供货商名称:</p> <input type="text" name="vendor_name">
        <p>供货商地址：</p> <input type="text" name="vendor_address">
        <p>供货商电话：</p> <input type="text" name="vendor_phone">
        <p>供货商传真：</p> <input type="text" name="vendor_fax">
        <p>供货商联系人：</p>  <input type="text" name="vendor_contact_person">
        <button type="submit">添加</button>
        <a href="getAllVendor">取消</a>
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
    .addVendor{
        z-index: 20;
        position: absolute;
        margin-left: 500px;
        margin-top: 200px;
    }
</style>
</html>
