<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/12/1
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }
        /* 左侧边栏容器宽度 */
        aside {

            width: 200px;
            background: #f1f1f1;
        }
        /* 导航标题 */
        .sidebar a {
            padding: 15px 20px;
            background: rgba(0,0,0,0.3);
            color: white;
            display: block;
            text-decoration: none;
            padding: 10px 20px;
        }
        /* 二级菜单悬浮样式 */
        aside a:hover {
            font-weight: bold;
            background-color: rgba(0,0,0,0.5);
            color: white;
        }
    </style>
</head>
<body>
<aside>
    <div class="sidebar">
        <a href="#">添加公告</a>
    </div>
    <div class="sidebar">
        <a href="#"> 添加新闻</a>
    </div>
</aside>

</body>
</html>
