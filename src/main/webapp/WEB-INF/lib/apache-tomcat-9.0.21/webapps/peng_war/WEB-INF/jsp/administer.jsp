<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/12/1
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{

            background: url("/resources/bg.jpg");
            background-size:cover;
        }
        context{
            grid-area: context;
        }
        main{

            grid-template-columns:  4fr;
            grid-template-areas: "context";
        }
        .bootstrap-frm {
            margin-left:auto;
            margin-right:auto;
            max-width: 500px;
            background: #FFF;
            padding: 20px 30px 20px 30px;
            font: 12px "Helvetica Neue", Helvetica, Arial, sans-serif;
            color: #888;
            text-shadow: 1px 1px 1px #FFF;
            border:1px solid #DDD;
            border-radius: 5px;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
        }
        .bootstrap-frm h1 {
            font: 25px "Helvetica Neue", Helvetica, Arial, sans-serif;
            padding: 0px 0px 10px 40px;
            display: block;
            border-bottom: 1px solid #DADADA;
            margin: -10px -30px 30px -30px;
            color: #888;
        }
        .bootstrap-frm h1>span {
            display: block;
            font-size: 11px;
        }
        .bootstrap-frm label {
            display: block;
            margin: 0px 0px 5px;
        }
        .bootstrap-frm label>span {
            float: left;
            width: 20%;
            text-align: right;
            padding-right: 10px;
            margin-top: 10px;
            color: #333;
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            font-weight: bold;
        }
        .bootstrap-frm input[type="text"], .bootstrap-frm input[type="email"], .bootstrap-frm textarea, .bootstrap-frm select{
            border: 1px solid #CCC;
            color: #888;
            height: 20px;
            line-height:15px;
            margin-bottom: 16px;
            margin-right: 6px;
            margin-top: 2px;
            outline: 0 none;
            padding: 5px 0px 5px 5px;
            width: 80%;
            border-radius: 4px;
            -webkit-border-radius: 4px;
            -moz-border-radius: 4px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
            -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        }
        .bootstrap-frm select {
            background: #FFF no-repeat right;
            background: #FFF no-repeat right;
            appearance:none;
            -webkit-appearance:none;
            -moz-appearance: none;
            text-indent: 0.01px;
            text-overflow: '';
            width: 80%;
            height: 35px;
            line-height:15px;
        }
        .bootstrap-frm textarea{
            height:100px;
            padding: 5px 0px 0px 5px;
            width: 80%;
        }
        .bootstrap-frm .button {
            background: #FFF;
            border: 1px solid #CCC;
            padding: 10px 25px 10px 25px;
            color: #333;
            border-radius: 4px;
        }
        .bootstrap-frm .button:hover {
            color: #333;
            background-color: #EBEBEB;
            border-color: #ADADAD;
        }
    </style>
</head>
<body>
<%@include file="common/header.jsp"%>
<main>
    <context>
        <form action="/administer" class="bootstrap-frm" method="post">
            <p> 请选择您要添加的内容</p>

            <select name="kind">
                <option value="1">新闻</option>
                <option value="2">公告</option>
            </select>
            <br>
            <p>标题</p>
            <input type="text" name="name" style="display:inline-block; height: 30px">
            <br>
            <p>发布者</p>
            <input type="text" name="writer" style="display:inline-block; height: 30px">
            <br>
            <p>内容</p>
            <textarea name="context" ></textarea>
            <br>
            <button class="button" type="submit">提交</button>
        </form>
    </context>
</main>
</body>
</html>
