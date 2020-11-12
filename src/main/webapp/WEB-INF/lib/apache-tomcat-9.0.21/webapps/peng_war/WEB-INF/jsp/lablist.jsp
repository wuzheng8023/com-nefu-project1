<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style >

        *{
            margin: 0 ;
            padding: 0;
            box-sizing: border-box;
        }
        /*背景图*/

        body{
            background-image: url("/resources/bj4.jpeg");
            background-size:cover;
            background-attachment: fixed;

        }


        .card {
            margin: 20px 0px;
            padding: 5px;
            height: 250px;
            width: 100%;
            box-shadow:  0 4px 8px 0 rgba(0, 0, 0, 0.4), 0 6px 20px 0 rgba(0, 0, 0, 0.39);

        }
        .card .header {
            border-radius: 5px;
            padding: 50px 0;
            text-align: center;
            transform: translateY(55px);
            transition: transform 0.5s;
            position: relative;
            background: rgba(255, 255, 255, 1.0);
            z-index: 99;
        }
        .card .content {
            text-align: justify;
            transform: translateY(-55px);
            opacity: 0.5;
            transition: transform 0.5s, opacity 0.5s;
        }
        .card .content span {
            height: 200px;
            overflow: hidden;
        }
        .card .content a {
            display: inline-block;
            float: right;
            padding: 10px 15px;
            background-color: rgba(37,91,255,0.5);
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .card:hover .header {
            transform: translateY(0px);
        }
        .card:hover .header > img {
            opacity: 1.0;
        }
        .card:hover .content {
            transform: translateY(0px);
            opacity: 1.0;
        }
        .card .content a:hover {
            background-color: rgba(37,91,255,0.9);
        }
        #banner {
            margin: 100px 0 0px 300px;
            grid-area: banner;
            position: relative;
            width:1300px;
            height:750px ;
            border: 1px solid #666;
            overflow: hidden;
            border-radius: 40px;

        }

        #banner_list img {
            overflow: hidden;
        }

        #banner_bg {
            position: absolute;
            bottom: 0;
            background-color: #000;
            height: 30px;
            filter: Alpha(Opacity=30);
            opacity: 0.3;
            z-index: 1000;
            cursor: pointer;
            width: 478px;
        }

        #banner_info {
            position: absolute;
            bottom: 0;
            left: 5px;
            height: 22px;
            color: #fff;
            z-index: 1001;
            cursor: pointer
        }

        #banner_text {
            position: absolute;
            width: 120px;
            z-index: 1002;
            right: 3px;
            bottom: 3px;
        }

        #banner ul {
            position: absolute;
            list-style-type: none;
            filter: Alpha(Opacity=80);
            opacity: 0.8;
            z-index: 1002;
            margin: 0;
            padding: 0;
            bottom: 3px;
            right: 5px;
        }

        #banner ul li {
            padding: 0px 4px;
            float: left;
            display: block;
            color: #FFF;
            background: #6f4f67;
            cursor: pointer;
            border: 1px solid #333;
        }

        #banner ul li.on {
            background-color: #000;
        }

        #banner_list a {
            position: absolute;
        }


    </style>
</head>
<body>
<%@include file="common/header.jsp"%>
<div id="banner">
    <div id="banner_info">

    </div>
    <ul>
        <li class="on">
            1
        </li>
        <li>
            2
        </li>
        <li>
            3
        </li>
    </ul>
    <div   id="banner_list">
        <a href="#" target="_blank" style="width: 100%;display: block;">
            <img src="/resources/lab/shiyanshi1.jpg" style="display:block;width: 100%">
        </a>
        <a href="#" target="_blank" style="width: 100%;display: block;"><img src="/resources/lab/shiyanshi2.jpg" style="display: block;width: 100%"></a>
        <a href="#" target="_blank" style="width: 100%;display: block;"><img src="/resources/lab/shiyanshi3.jpg" style="display: block;width: 100%"></a>
    </div>
</div>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script type="text/javascript">
    var t = n = 0,
        count;
    $(document).ready(function() {
        // 获取图片标签长度
        count = $("#banner_list a").length;
        // 不是当前显示的图片隐藏
        $("#banner_list a:not(:first-child)").hide();
        // 点击下面的123按钮，切换图片
        $("#banner li").click(function() {
            var i = $(this).text() - 1;
            n = i;
            if (i >= count) return;
            // 淡入淡出效果
            $("#banner_list a").filter(":visible").fadeOut(500).parent().children().eq(i).fadeIn(1000);

            // 响应点击
            $(this).toggleClass("on");

            // 切换按钮的时候让上一个按钮回归原来的样式
            $(this).siblings().removeAttr("class");
        });
        t = setInterval("showAuto()", 4000);
        $("#banner").hover(function() {
                clearInterval(t)
            },
            function() {
                t = setInterval("showAuto()", 4000);
            });
    })
    // 自动轮播
    function showAuto() {
        n = n >= (count - 1) ? 0 : ++n;
        $("#banner li").eq(n).trigger('click');
    }
</script>
</body>
</html>
