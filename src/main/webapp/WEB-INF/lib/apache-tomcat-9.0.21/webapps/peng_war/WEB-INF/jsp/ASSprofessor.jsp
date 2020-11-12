
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        img {border: 0;}
        *{
            margin: 0 ;
            padding: 0;
            box-sizing: border-box;
        }
        .clearfix:after { content:"."; display:block; height:200px;	clear:both;	visibility:hidden;}
        a { color:white; text-decoration:none;}
        a:hover { color:#0aa6d6; text-decoration:underline;}

        #detail2-box { width:100%; background:url("/resources/bg.jpg") top left repeat-x; margin:0 auto 15px auto; border:1px solid #ccc; border-radius:5px;}
        #detail2-box .tit-80 { height:77px; line-height:60px; color:#fff; font-size:24px; padding:0 20px 20px 75px; }
        #detail2-box .tabula-box { width:240px; background:url("/resources/bg.jpg")right 50px no-repeat; padding:10px; float:left;}
        #detail2-box .tabula-box .max-tit { width:220px; height:40px; line-height:40px; text-align:center; color:#0aa6d6; font-size:18px; border-bottom:1px dotted #0aa6d6; margin-left:10px;}
        #detail2-box .tabula-box ul { padding:10px; min-height:380px;}
        #detail2-box .tabula-box ul li{ height:35px; padding-left:30px; line-height:35px; font-size:16px; border-bottom:1px dotted #ccc; background:url(../images/li2.png) left center no-repeat;}

        #detail2-box .content-box { width:695px; padding:0 100px; float: left}
        #detail2-box .content-box .content { padding:0 0 20px 0; min-height:600px;}
        #detail2-box .content-box .content img,table,td { max-width:100%;}
        #detail2-box .content-box h1{ height:50px; line-height:50px; border-bottom:1px dotted #0aa6d6; font-size:16px; text-align:center; margin-bottom:30px;}
        #detail2-box .content-box .n-p-box{border-top:1px dotted #0aa6d6; font-size:14px;}
        #detail2-box .content-box .n-p-box .prv { width:47%; height:50px; line-height:50px; float:left; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;}
        #detail2-box .content-box .n-p-box .next { width:47%; height:50px; line-height:50px; float:right; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;}

        #detail2-box .content-box li.text{ height:40px; padding-left:15px; background:url("/resources/bg.jpg") left center no-repeat; line-height:40px; text-align:left; font-size:14px; border-bottom:1px dotted #ccc; position:relative;}
        #detail2-box .content-box li.text a { width:560px; height:40px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap; display:inline-block;}
        #detail2-box .content-box li.text span { position:absolute; top:0; right:0; color: #0aa6d6; font-size:12px;}
        #detail2-box .content-box h3 { line-height:50px; text-align:center;}
        #detail2-box .content-box li.pic{ width:225px; margin-left:10px; margin-bottom:20px; float:left;}
        #detail2-box .content-box li.pic .img-box{ width:203px; height:140px; margin-right:10px; padding:10px; border:1px solid #ccc; }
        #detail2-box .content-box li.pic .img-box img { width:203px; height:140px;}
        z

    </style>
</head>
<body>
<%@include file="common/header.jsp"%>
<div id="detail2-box" class="clearfix">
    <div class="tit-80">副教授信息</div>
    <div class="tabula-box">
        <div class="max-tit">副教授简介</div>
        <ul>
            <li><a href="/introduction">副教授甲</a></li>

            <li><a href="/introduction">副教授乙</a></li>

            <li><a href="/introduction">副教授丙</a></li>

            <li><a href="/introduction">副教授丁</a></li>

        </ul>
    </div>

    <div class="content-box">
        <h1 style="color: #0aa6d6">副教授照片</h1>
        <ul class="clearfix" style=" width:705px; margin-left:-10px;">
            <li class="pic">
                <div class="img-box">
                    <a href="/introduction">
                        <img src="/resources/a.png">
                    </a>
                </div>
                <h3><a href="/introduction">副教授甲</a></h3>
            </li>
            <li class="pic">
                <div class="img-box">
                    <a href="/introduction" >
                        <img src="/resources/b.png">
                    </a>
                </div>
                <h3><a href="/introduction">副教授乙</a></h3>
            </li>
            <li class="pic">
                <div class="img-box">
                    <a href="/introduction">
                        <img src="/resources/c.png">
                    </a>
                </div>
                <h3><a href="/introduction">副教授丙</a></h3>
            </li>
            <li class="pic">
                <div class="img-box">
                    <a href="/introduction">
                        <img src="/resources/d.png">
                    </a>
                </div>
                <h3><a href="/introduction">副教授丁</a></h3>
            </li>

        </ul>
    </div>
</div>


</body>
</html>
