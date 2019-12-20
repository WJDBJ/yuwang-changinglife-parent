<%--
  Created by IntelliJ IDEA.
  User: XJ
  Date: 2019/12/9
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </style>
<%--    <script src="/static/js/user.js"></script>--%>
<%--    //+"?t="+Math.random()    "/download?filename="+--%>
</head>
<body>
<script type="text/javascript">
    $(function () {
        const obj = {"name":'${userId}'};
        $.getJSON("/feMain/getName",obj,function(data){
            if(data.code == "200") {
                console.log(data.msg);
                $("#img").next().text(data.data.infoName);
                $("#img").attr("src","/download?filename="+data.data.infoImg)
            }else if(data.code == "500") {
                console.log(data.msg);
            }
        });
    });
</script>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header" style="margin-top: 10px;">
            <a class="navbar-brand" href="#">钰网——改变生活</a>
        </div>
        <div>
            <!--向左对齐-->
            <!-- <p class="navbar-text navbar-left">向左对齐-文本</p> -->
            <!--向右对齐-->
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img  id="img" src="" class="img-circle" style="width: 30px;height: 30px;">
                        <span></span>
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/personalInformation/inInfo">个人信息</a></li>
                        <li class="divider"></li>
                        <li><a href="/login/login">退出登录</a></li>
                    </ul>
                </li>
                <ul class="nav nav-pills" style="float: left;  margin-top: 15px; padding-left: -10px;">
                    <li><a href="#">会员</a></li>
                </ul>
            </ul>
        </div>
    </div>
</nav>
<div>
    <div style="float: left">
        <form action="/video/inVideo" method="get">
            <input type="submit" style="height: 250px;width: 400px;text-align: center;font-size: 48px; margin-left: 250px;
		    margin-top: 20px; background-image: url(/static/images/9.jpg);" class="btn  btn-lg web_bg" value=" "/>
            <h3 style="margin-left: 400px;"></h3>
        </form><!-- btn-info -->
    </div>
    <div>
        <form action="#">
            <input type="submit" style="height: 250px;width: 400px; text-align: center; font-size: 48px;margin-left: 100px;
		    margin-top: 20px;" class="btn  btn-lg web_bg" value=""/>
            <h3 style="margin-left: 900px;"></h3>
        </form>
    </div>
    <div style="float: left">
        <form action="#">
            <input type="submit" style="height: 250px;width: 400px;text-align: center;font-size: 48px;margin-left:250px;
		    margin-top: 20px; float: left;" class="btn  btn-lg web_bg" value=""/>
        </form>
    </div>
    <div>
        <form action="#">
            <input type="submit" style="height: 250px;width: 400px;text-align: center;font-size: 48px;margin-left: 100px;
		    margin-top: 20px;" class="btn btn-lg web_bg" value=""/>
        </form>
    </div>
</div>
</body>
