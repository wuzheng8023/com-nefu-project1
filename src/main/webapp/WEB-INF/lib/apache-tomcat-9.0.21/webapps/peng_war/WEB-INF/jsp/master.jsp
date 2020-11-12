<%--
  Created by IntelliJ IDEA.
  User: Devil
  Date: 2019/12/13
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            padding: 0 ;
            margin: 0;

        }
        body{
            background: url("/resources/R.jpeg");
            background-attachment: fixed;
        }
        .news {
            text-align: center;
            width: 300px;
            border: 1px solid gray;
            padding: 20px 15px ;
            margin: 20px 300px;
            background: url("/resources/longin3_bg.jpeg");
        }
        .news h2{
            padding-bottom: 5px;
            color: white;
            font-weight: bold;
        }
        .news ul{
            padding:5px 10px ;
            background: white;
        }
        .news ul li{

            list-style: none;
            height: 30px;
            line-height: 30px;
            border-bottom: 1px dashed gray;
            text-indent: 15px;
            font-size: 14px;
            background:url() no-repeat center left;
            margin: 10px 50px;
        }
        .news a{
            float: right;
            text-decoration: none;
            color: #06C;
        }
        .news a:hover{
            text-decoration: underline;
            color: red;
        }
        main{
            background: rgba(255,255,255,0.7);
            /*display: inline-block;*/
            height:80%;
            border-radius: 20px;
            margin: 0 500px;
        }
        main h1{
            text-align: center;
            padding: 0px 50PX;
        }
    </style>
</head>
<body>
<%@include file="common/header.jsp"%>
<main style="border-radius: 5px">
    <div style="padding: 20px; border-bottom: solid #273bff">
        <h1 style="color: black;">研究生</h1>
    </div>
    <div style="width: 100%; padding: 3px; display: inline-block; height:80%">

        <p style="text-indent: 2em">
            1、本次会议共准备270个展位，我们将对用人单位按完整信息（单位的法人机构代码证和/或营业执照的电子版；附件3、4、5）的提交时间先后顺序及我校学生求职意愿情况进行审核和确定参会资格，额满为止。
        </p>
        <p style="text-indent: 2em">
            2、我们将对用人单位按完整信息（单位的法人机构代码证和/或营业执照的电子版；附件3、4、5）的提交时间先后顺序及我校学生求职意愿情况进行审核和确定参会资格，额满为止。
        </p>
        <p style="text-indent: 2em">
            3、单位的法人机构代码证和/或营业执照的电子版；附件3、4、5的提交时间先后顺序及我校学生求职意愿情况进行审核和确定参会资格，额满为止。
        </p>
        <p style="text-indent: 2em">
            4、提交时间先后顺序及我校学生求职意愿情况进行审核和确定参会资格，额满为止。
        </p>
    </div>
    <hr>
</main>

</body>
</html>
