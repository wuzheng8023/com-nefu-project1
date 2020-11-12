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
            background: url("/resources/longin4_bg.jpeg");
            background-attachment: fixed;

        }
     .news {
         text-align: center;
         width: 350px;
         border: 1px solid gray;
         padding: 20px 15px ;
         margin: 20px auto;
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
            text-align: center;
        }
        main h1{
            padding: 0px 50PX;
        }

    </style>
</head>
<body>
<%@include file="common/header.jsp"%>
<main>
    <c:if test="${value==1}">
        <h1 ><center>公告</center></h1>
    </c:if>
    <c:if test="${value==2}">
        <h1 ><center>新闻</center></h1>
    </c:if>
    <div class="news">
        <h2>详细情况/Details</h2>
        <ul>
             <c:forEach items="${news}" var="u">
            <li><span style="float: left; padding: 0px"> ${u.name}</span>
            <a href="/getNot?name=${u.name}&value=${value}" >了解详情</a>
            </li>
             </c:forEach>
        </ul>
    </div>

</main>
</body>
</html>
