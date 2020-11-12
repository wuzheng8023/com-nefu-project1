<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/11/27
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>

<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body{
            background: url("/resources/F.jpeg");
            background-size:cover ;
        }
        .card{
            width: 400px;
            margin: 100px auto;
            display: inline-block;
            background:rgba(255,255,255,0.5);
            text-align: center;
        }
        .tu{
            position: relative;
            top: -100px;
            display: inline-block;
        }
    </style>
</head>
<body>

<button type="button" class="btn btn-primary" data-toggle="modal"  data-target="#exampleModal" style="display: none">
    Launch demo modal
</button>
<%--${logintishi}--%>
<c:if test="${registerishi!=null}">
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">提示</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                        ${registerishi}
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</c:if>
<main style="text-align: center; margin: 150px 0px 0px 0px;">
    <div class="tu"><img src="/resources/login1.png"></div>
    <div class="card" >
        <p >注册</p>
        <form action="/register" method="post" style="display: block; width: 200px; margin: 0 auto;">
            用户名 <input class="form-control form-control-sm" type="text" placeholder="10位以内数字" name="username" required>
            昵称  <input class="form-control form-control-sm" type="text" placeholder="20位以内字母数字" name="name" required>
            密码   <input type="password" class="form-control form-control-sm"   placeholder="20位以内字母数字" name="password" required>
            重复输入密码   <input type="password" class="form-control form-control-sm"   placeholder="重复输入"  name="password2" required>
            <button type="submit" class="btn btn-primary"  style="margin: 10px 5px 0 0 ">注册</button>
        </form>
    </div>
    <div class="tu"><img src="/resources/login2.png"></div>
</main>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.15.0/umd/popper.min.js" integrity="sha384-L2pyEeut/H3mtgCBaUNw7KWzp5n9+4pDQiExs933/5QfaTh8YStYFFkOzSoXjlTb" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script>
    $(function () {
            $('#exampleModal').modal('show');
        let but = $("button[type=submit]").prop("disabled",true);
        let password=false;
        let username=false;
        let name=false;
        $("input[name=password2]").change(function () {
            if($(this).val()==$("input[name=password]").val()){
                password=true;
            }
            else {
                password=false;
                alert("与密码不同")
            }

        })
        $("input[name=password]").change(function () {
            if($(this).val()==$("input[name=password2]").val()){
                password=true;
            }
            else if($(this).val()!=$("input[name=password2]").val()&&$("input[name=password2]").val().length!=0) {
                password=false;
                alert("与重复密码不同")
            }
        })
        $("input[name=username]").change(function () {
            if($(this).val().length!==0){
                username=true;
            }
            else
                username=false;
        })
        $("input[name=name]").change(function () {
            if($(this).val().length!==0){
               name=true;
            }
            else
                name=false;
        })
        $("input[name=password2],input[name=username],input[name=name]").change(()=>{
            if(username==true&&password==true){
                if(name==true)
                but.prop("disabled",false);
                else
                    but.prop("disabled",true);
            }
            else
                but.prop("disabled",true);
        })
    })
</script>
</body>
</html>
