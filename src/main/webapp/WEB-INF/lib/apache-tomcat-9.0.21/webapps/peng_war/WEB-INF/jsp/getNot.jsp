<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/12/2
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        p{
            text-align:left;
            text-indent:2em;
            padding-bottom:10px;
            word-break: break-all;
            word-wrap:break-word;
        }
        *{
            margin:0;
            padding: 0;
            box-sizing: border-box;
        }
        body{
            background: url("/resources/longin4_bg.jpeg");
            background-attachment: fixed;

        }
        main{
            background: rgba(255,255,255,0.7);
            height: 100%;
            margin: 0 200px;
        }
    </style>
</head>
<body>
<%@include file="common/header.jsp"%>
<main style="border-radius: 5px">
    <div style="padding: 20px">
        <h1 style="color: black"><center>${Not.name}</center></h1>
        <p style="color: #888888;float:right">作者：${Not.writer}</p>
    </div>
       <hr>
    <div style="width: 100%; padding: 40px; display: inline-block; height:80%"><p>${Not.content}</p></div>
    <hr>
    <p style="text-align: right;color: #888888">文章发布时间：${Not.inserttime}</p>
</main>
</body>
</html>
