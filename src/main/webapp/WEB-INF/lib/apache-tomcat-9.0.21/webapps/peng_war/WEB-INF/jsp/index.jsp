
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>东北林业大学 软件工程 2019年</title>
    <%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
    <style>
        myyheader{
            position: absolute;
            z-index: 1005;
            grid-area: header;
        }
        *{
            margin: 0 ;
            padding: 0;
            box-sizing: border-box;
        }
        /*背景图*/

        body{
            background-image: url("/resources/bj3.jpeg");
            background-size:cover;
            background-attachment: fixed;

        }


        /*not*/
        .not{
            grid-area: not;
            margin: 0 100px ;
            border-radius: 10px;

        }
        /*new*/
        .new{
            grid-area: new;
            margin: 0 100px ;
            border-radius: 10px;
        }
        /*暂时*/


        /*布局*/
        main{
            display: grid;
            grid-template-columns: 1fr 1.2fr;
            grid-template-areas: "header header" "banner banner" "not new"  ;
            margin: 0px 0px 0 0px;
        }

        #banner {
            margin: 100px 0 0px 190px;
            grid-area: banner;
            position: relative;
            width:1500px;
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
            right: 7px;
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
        .not ul li{
            margin: 0 100px;
            display:flex ;
            text-align: center;
            list-style-type: none;
        }
        .new ul li{
            margin: 0 100px;
            display:flex ;
            text-align: center;
            list-style-type: none;
        }
        .clearfix li{
            width: 200px;
        }
        .clearfix a{
            text-align: center;
            width: 100%;
            text-decoration: none;
            color: #CCCCCC;
        }
        .clearfix{
            display: table;
            zoom: 1;
        }
        .clearfix h3{
            color: #CCCCCC;
        }
        .clearfix span{
            color: #0066CC;

        }

        h1{
            color: #0066CC;
            text-align: center;

        }

    </style>
</head>
<body>
<%@include file="common/header.jsp"%>
<main>
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
            <li>
                4
            </li>
        </ul>
        <div   id="banner_list">
            <a href="#" target="_blank" style="width: 100%;display: block;"><img src="/resources/longin4_bg.jpeg" style="display:block;width: 100%"></a>
            <a href="#" target="_blank" style="width: 100%;display: block;"><img src="/resources/bj1.jpeg" style="display: block;width: 100%"></a>
            <a href="#" target="_blank" style="width: 100%;display: block;"><img src="/resources/longin4_bg.jpeg" style="display: block;width: 100%"></a>
            <a href="#" target="_blank" style="width: 100%;display: block;"><img src="/resources/bj1.jpeg" style="display: block;width: 100%"></a>
        </div>
    </div>



    <div class="not">
        <h1 style="text-align: center">公告</h1>
        <ul  class="clearfix">
            <c:forEach items="${nots}" var="u" varStatus="s">
                <c:if test="${s.count<=5}">
                    <li>
                        <a href="/getNot?name=${u.name}&value=1" target="_blank">
                            <div class="time" style="float: left;width: 50px">
                               <span > ${u.inserttime}
                               </span>
                            </div>
                            <div class="txtwrapper" style="margin: 0 0 0 50px;">
                                <h3>Title:${u.name}</h3>
                                <p>
                                    Content:${u.brief}
                                </p>
                            </div>
                        </a>
                    </li>
                </c:if>
            </c:forEach>

        </ul>
    </div>
    <div class="new">

        <h1 style="text-align: center">新闻</h1>
        <ul class="clearfix" >
            <c:forEach items="${newses}" var="u" varStatus="s">
                <c:if test="${s.count<=5}">
                    <li>
                        <a href="/getNot?name=${u.name}&value=2">
                            <div class="time" style="float: left;width: 50px">
                               <span > ${u.inserttime}
                               </span>
                            </div>
                            <div class="txtwrapper" style="margin: 0 0 0 50px;">
                                <h3>Title:${u.name}</h3>
                                <p>
                                    Content:${u.brief}
                                </p>
                            </div>
                        </a>
                    </li>
                </c:if>
            </c:forEach>

        </ul>
    </div>

</main>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script type="text/javascript">
    var t = n = 0,
        count;
    $(document).ready(function() {
        // 获取图片标签长度
        count = $("#banner_list a").length;
        // 不是当前显示的图片隐藏
        $("#banner_list a:not(:first-child)").hide();
        // 点击下面的1234按钮，切换图片
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
