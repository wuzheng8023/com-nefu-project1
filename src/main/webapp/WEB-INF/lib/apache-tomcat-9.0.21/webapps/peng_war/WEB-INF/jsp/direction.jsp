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
        *{
            padding: 0 ;
            margin: 0;
        }
        body{
            background: url("/resources/bj1.jpeg");
            background-attachment: fixed;
        }
        .news {
            text-align: center;
            width: 300px;
            border: 1px solid gray;
            padding: 20px 15px ;
            margin: 20px 300px;
            background: url("/resources/bj1.jpeg");
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
            height:60%;
            border-radius: 20px;
            margin: 0 500px;
        }
        main h1{
            text-align: center;
            padding: 0px 50PX;
        }
        p{
            text-align:left;
            text-indent:2em;
            padding-bottom:10px;
            word-break: break-all;
            word-wrap:break-word;
        }
    </style>
</head>
<body>
<%@include file="common/header.jsp"%>
<main style="border-radius: 5px">
    <div style="padding: 20px; border-bottom: solid #273bff">
        <h1 style="color: black;">方向简介</h1>
    </div>
    <div style="width: 100%; padding: 3px; display: inline-block; height:80%">
        <p >
            软件工程现在是最火爆的专业之一，因此，学的人很多。
        </p>
        <p >
            软件工程是个很大的筐，任何跟软件相关的东西都可以放入。从软件的形成来说，有需求分析、设计和开发、测试和销售、运营和维护。从软件的处理的对象来说，有移动端、主机端、嵌入式端。还可以按照软件功能来分，比如游戏软件、媒体软件、企业ERP软件或者信息管理系统等。这些都是软件工程毕业生的就业方向。
        </p>
        <p>
            具体就业方向有:
        </p>
             <p>
            1. 游戏软件人才

            我有个师弟是游戏软件大拿，偶尔我会听他说一些关于游戏方面的事情。他说，计算机的发展70%跟游戏相关，游戏不是精神鸦片，人类总是需要游戏来放松和想象的；游戏人才非常缺乏；我国的游戏水平还很差。

            游戏软件人才，包括游戏软件策划、美术设计，最后是程序设计。游戏软件策划也许不需要软件工程知识。著名的多益网络老板徐波，成名就是网易的《梦幻西游》的游戏策划，他只是一个中学毕业生，但是个精通游戏的玩家。对于美术设计，需要一些计算机知识，但不是很多。因此，软件工程专业的主要是程序设计。

            游戏分3种，一种是计算机端，一种是移动端，还有一种专用游戏设备。计算机端还分单机版和联网版。移动端还分IOS系统和安卓系统。

            游戏的话，腾讯、网易、搜狐等各大互联网公司都有。
             </p>
        <p>
            2.虚拟现实

            虚拟现实就是模拟真实场景，让人有种身临其境的感觉。游戏是一种应用，还有展览、训练、设计等，比如制作数字博物馆等。
        </p>
        <p>
            3.人工智能方向

            主要是图形图像处理、语音处理、神经网络等。一般BAT等大公司都需要，华为也刚招聘了一批顶尖博士。
        </p>
        <p>
            4. 大数据

            主要是对数据的管理和挖掘，可以在互联网公司、中移动等网络运营商、保险、银行等金融部门、国家有关部门、一些巨型企业等。
        </p> <p>
            5. 嵌入式软件开发

            万物互联，智能家居都需要嵌入式的软硬件开发，可以在华为、中兴、美的等等IT相关企业、家电企业就职
            <br>
        </p>
    </div>
    <hr>
    <p style="text-align: right;color: #561234">文章发布时间：2019年12月3日</p>
</main>
</body>
</html>
