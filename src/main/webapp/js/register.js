function register() {

    var username = document.getElementById("username");
    var pass = document.getElementById("password");
    var second = document.getElementById("second");

    if (username.value == "") {

        alert("请输入用户名");

    } else if (pass.value  == "") {

        alert("请输入密码");

    } else if (second.value  == "") {

        alert("请再次输入密码");

    } else if (second.value  != pass.value) {

        alert("请输入相同密码");

    } else if (username.value.length > 16) {

        alert("用户名不能大于16位");

    } else if (pass.value.length > 16) {

        alert("密码不能大于16位");

    } else if (pass.value.length < 8) {

        alert("密码不能小于8位");

    } else {
        alert("注册成功");
        window.location.href="login.html";
    }
}