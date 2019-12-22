<%--
  Created by IntelliJ IDEA.
  User: XJ
  Date: 2019/12/20
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>钰网——改变生活</title>
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <link rel="stylesheet" href="/static/css/bootstrap-theme.css">
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/js/bootstrap.js"></script>
    <style>
        .web_bg{
            z-index:-10;
            zoom: 1;
            background-repeat: no-repeat;
            background-size: cover;
            -webkit-background-size: cover;
            -o-background-size: cover;
            background-position: center 0;
        }
        a{
            color: black;
        }
    </style>
</head>
<body>
<script type="text/javascript">
    $(function () {
        const obj = {"name":'${userId}'};
        $.getJSON("/feMain/getName",obj,function(data){
            if(data.code == "200") {
                console.log(data.msg);
                $("#img").next().text(data.data.infoName);
                $("#img").attr("src","/photo/download?filename="+data.data.infoImg)
            }else if(data.code == "500") {
                console.log(data.msg);
            }
        });
    });
</script>
<nav class="navbar navbar-default" role="navigation"
     style="height: 150px; background:url(/static/images/video.png) no-repeat center center">
    <div class="container-fluid">
        <div class="navbar-header" style="margin-top: 10px;">
            <a class="navbar-brand" style="color: black;" href="/feMain/back">钰网——视频专区</a>
        </div>
        <div class="col-lg-3" style="margin-top: 15px; margin-left: 250px;">
            <div class="input-group">
                <input type="text" class="form-control" style="height: 40px;" placeholder="灵魂歌手方盛" >
                <span class="input-group-btn">
                    <button type="button" class="btn btn-default btn-sm" style="height: 40px; width: 40px;">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </span>
            </div>
        </div>
        <div style=" margin-top: -50px;">
            <!--向左对齐-->
            <!-- <p class="navbar-text navbar-left">向左对齐-文本</p> -->
            <!--向右对齐-->
            <ul class="nav navbar-nav navbar-right" style="width: 560px;">
                <li class="dropdown"style="margin-top: -2px;">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img  id="img" src="" class="img-circle" style="width: 40px;height: 40px;">
                        <span style="color: black"></span>
                        <b class="caret"></b>
                    </a>
                </li>
                <ul class="nav nav-pills" style="float: left; margin-top: 10px;">
                    <li><a href="#">消息</a></li>
                    <li><a href="#">动态</a></li>
                    <li><a href="#">收藏</a></li>
                    <li><a href="#">历史</a></li>
                    <li><a href="#">创作中心</a></li>
                </ul>
                <button type="button" id="Contribute" class="btn btn-warning btn-lg" data="${userId}" style="margin-top: 10px;">投稿</button>
            </ul>
        </div>
    </div>
</nav>

<script src="/static/js/fe/video.js"></script>
</body>
</html>
