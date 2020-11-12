<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/jquery-1.11.0.min.js"></script>
    <!--    <script type="text/javascript" src="js/login.js"></script>-->
    <!--    // 登录的单击事件
        <script>
            $(function () {
                $("#btn_sub").click(function () {
                    //发送ajax请求
                    $.post("login", $("#loginForm").serialize(), function (data) {
                        //data : {flag:..,errorMsg:..}
                        if (data.flag) {
                            //登录成功
                            location.href = "index.html";
                        } else {
                            //登录失败，给出提示信息
                            $("#errorMsg").html(data.errorMsg);
                        }
                    })
                })
            })
        </script>-->
</head>
<body>
<div id="login_frame">
    <p id="image_logo"><img src="image/fly.png"></p>
    <!--登录错误提示消息-->
    <div id="errorMsg" class="alert alert-danger" ></div>
    <form method="post" action="login" id="loginForm">
        <input type="hidden" name="action" value="login">
        <p><label class="label_input">用户名</label><input type="text" id="username" class="text_field" name="userName" /></p>
        <p><label class="label_input">密码</label><input type="password" id="password" class="text_field" name="pwd" /></p>
        <input type="submit" value="登录" name="btn_login" id="btn_sub">
    </form>

</div>

</body>
</html>