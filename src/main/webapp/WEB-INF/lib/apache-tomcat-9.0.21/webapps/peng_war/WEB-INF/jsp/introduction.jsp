<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教师简介</title>
    <link rel="stylesheet" type="text/css"/>
    <style>
        *{
            margin: 0 ;
            padding: 0;
            box-sizing: border-box;
        }
        body{
            background-image: url("/resources/longin2_bg.jpeg");
        }
        .i_content{
            width: 100%;


        }
        .c_area{
            width: 1100px; margin: 20px auto;
        }
        .content{
            float: left; width: 858px; min-height: 600px;  border: 1px solid #0aa6d6; box-shadow: 1px 1px 1px #ebebeb;
        }
        .con_title{
            height: 50px; line-height: 50px; padding-left: 25px; font-size: 25px; border-bottom: solid 1px #ebebeb;color: white;
        }
        .con_box{
            padding: 25px;font-size: 20px;color: white;
        }
        .clear{
            clear: both;
        }
    </style>
</head>
<body>
<%@include file="common/header.jsp"%>
<div class="i_content">
    <div class="c_area">
        <div class="content">
            <div class="con_title">教师简介</div>
            <div class="con_box">
               <pre>
  随着高等教育的快速发展，学校积极把握机遇，开拓创新，
规范师资队伍建设和管理工作，加大师资队伍建设和人才培养力度，
依托教育部各个层次人才计划，实施“名师英才工程”人才培养计划，
大力支持教师培训、进修、国内外访学，大力引进国内外优秀人才，
强化教师队伍服务和管理工作，建立健全教师考核机制，加强学术梯队建设，
优化教师队伍职称、学历、学缘、年龄结构，提高教师队伍整体水平，师资队伍发展良好态势。 
学校目前专任教师1328人，其中教授280人，副教授550人，教授、副教授所占比例达62.5%；
具有博士学位的教师724人，占教师总数的54.52%；具有硕士学位的教师512人，占教师38.55%；
合计硕士学位以上人员占93.07%；教师中外校毕业生比例占教师总数的70.12%。     
               </pre>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
</body>
</html>
