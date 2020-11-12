<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>更新供货商</title>
</head>
<body>
<div id="header"></div>
<div id="nav"></div>
<div class="updateVendor">
    <form action="updateVendor" method="post">
        <input type="text" name="vendor_id" value="${vendor.vendor_id}" hidden>
        <p>供货商名称:</p> <input type="text" value="${vendor.vendor_name}" name="vendor_name">
        <p>供货商地址：</p> <input type="text" value="${vendor.vendor_address}" name="vendor_address">
        <p>供货商电话：</p> <input type="text" value="${vendor.vendor_phone}" name="vendor_phone">
        <p>供货商传真：</p> <input type="text" value="${vendor.vendor_fax}" name="vendor_fax">
        <p>供货商联系人：</p>  <input type="text" value="${vendor.vendor_contact_person}" name="vendor_contact_person">
        <button type="submit">更新</button>
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
    .updateVendor{
        z-index: 20;
        position: absolute;
        margin-left: 500px;
        margin-top: 200px;
    }
</style>
</html>
