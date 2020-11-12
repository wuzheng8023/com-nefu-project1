<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<style>
    /* ------------上导航---------- */
    body{
        background-size:cover;
    }
    myyheader {
        margin: 0 0 10px 0;
        z-index: 100;
    }
    myyheader nav ul {
        display: flex;
        list-style-type: none;
        background-color: white;
    }
    myyheader nav li{
        position: relative;
    }
    myyheader nav li h3{
        display: block;
        color: black;
        padding: 14px 50px;
        text-decoration: none;
        margin:0px;
    }
    myyheader nav li h3:hover {

        background-color:rgba(5,255,255,0.5);
    }
    myyheader nav li>a{
        display: block;
        color: black;
        padding: 14px 20px;
        text-decoration: none;
        margin:0px;
    }
    myyheader nav li>a:hover {
        background-color:rgba(255,255,100,0.5);
    }
    myyheader nav .right {
        color: black;
    }
    myyheader nav .second{
        position: absolute;
        z-index: 100;
        display: none;
    }
    myyheader .second li a{
        display: block;
        color: black;
        padding: 14px 30px;
        text-decoration: none;
    }
    myyheader .second li a:hover{
        border-radius:10px;
        background-color:rgba(255,255,255,0.5);
    }
    myyheader .second{
        background-color:rgba(255,255,255,0.3);
        border-bottom-left-radius: 5px;
        border-bottom-right-radius: 5px;
    }
</style>
<myyheader style="width: 100%;">

    <nav>   <img src="/resources/header3.jpg" alt="" style="height: 65px; width: 200px; position: absolute">
        <ul style="width: 100%;height: 65px">
            <li class="second_li" style="margin-left: auto">
                <a href="/index" style="padding: 0;margin: 0;"><h3 class="second_head">首页</h3></a>
                <ul class="second">
                    <li><a href="/newslist?value=1">公告</a></li>
                    <li><a href="/newslist?value=2">新闻</a></li>
                </ul>
            </li>
            <li class="second_li">
                <h3 class="second_head">专业介绍</h3>
                <ul class="second">
                    <li><a href="/major">专业简介</a></li>
                    <li><a href="/direction">方向简介</a></li>
                </ul>
            </li>
            <li class="second_li">
                <a href="/lablist" style="padding: 0;margin: 0;"> <h3 class="second_head">实验室</h3></a>
                <ul class="second">
                    <li><a href="/getlab?id=1">923创新实验室</a></li>
                    <li><a href="/getlab?id=2">925移动开发实验室</a></li>
                    <li><a href="/getlab?id=3">923实验室</a></li>
                </ul>
            </li>
            <li class="second_li">
                <h3 class="second_head">教师队伍</h3>
                <ul class="second">
                    <li><a href="/professor">教授</a></li>
                    <li><a href="/ASSprofessor">副教授</a></li>
                    <li><a href="/teacher">讲师</a></li>
                </ul>
            </li>
            <li class="second_li">
                <h3 class="second_head">就业指南</h3>
                <ul class="second">
                    <li><a href="/Emguidance">就业信息</a></li>
                    <li><a href="/master">研究生</a></li>
                </ul>
            </li>
            <c:if test="${user==null}">
                  <li class="right">
                          <a href="/login" style="display: inline-block ">Login</a>|<a href="/register"style="display: inline-block">register</a>
                  </li>
              </c:if>
              <c:if test="${user!=null}">
                  <li class="second_li right">
                  <h3 class="second_head">${user.name}</h3>
                  <ul class="second">
                     <c:if test="${user.root==true}">
                        <li><a href="/administer">管理网页</a></li>
                     </c:if>
                        <li><a href="/logout">logout</a></li>
                  </ul>
                  </li>
              </c:if>



        </ul>
    </nav>
</myyheader>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script>
    $(function(){
        $(".second_li").hover(function () {
            let ul=$(this).children("ul");
            ul.fadeIn();
        },function () {
            let ul=$(this).children("ul");
            ul.fadeOut();
        })
    })

</script>
