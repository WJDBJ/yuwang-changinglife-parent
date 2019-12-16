<%--
  Created by IntelliJ IDEA.
  User: XJ
  Date: 2019/12/11
  Time: 12:10
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
    <link rel="stylesheet" href="/static/css/cropper.min.css">
    <link rel="stylesheet" href="/static/css/ImgCropping.css">
    <script src="/static/js/cropper.min.js"></script>
    <script src="/static/js/img-cropping.js"></script>
</head>
<body>
<!-- 置顶 -->
<div class="media" style="background-image: url(/static/images/index.jpg)">
    <div class="media-left media-top">
        <div style="width: 320px;height: 320px;border: solid 1px #555;padding: 5px;margin-top: 10px">
            <img id="finalImg" src="${userInfo.infoImg}" class="media-object" width="100%">
        </div>
        <h2 class="media-heading" style="margin-top: 20px; margin-left: 30px; color: white">${userInfo.infoName}【${userInfo.loginUid}】</h2>
    </div>
    <div class="media-body">
        <button id="replaceImg" class="l-btn" style="margin-top: 50px;">更换图片</button>
        <a href="/feMain/back" class="btn btn-primary" style="width: 100px;">'<<'返回主页
        </a>
    </div>
</div>
<!-- 居中对齐 -->
<div class="media">
    <div class="media-left media-middle" >
        <ul class="list-group" style="width: 300px; font-size: 30px;">
            <li class="list-group-item">性别：${userInfo.infoGender}</li>
            <li class="list-group-item">出生日期：${userInfo.infoBirthday}</li>
            <li class="list-group-item">年龄：${userInfo.infoAge}</li>
            <li class="list-group-item">地址：${userInfo.infoAddress}</li>
            <li class="list-group-item">邮箱：${userInfo.infoEmail}</li>
        </ul>
    </div>
    <div class="media-body">
        <h3>简介</h3>
        <p>${userInfo.infoDesc}</p>
    </div>
</div>
<script>
    userId = '${userInfo.loginUid}';
    picture_clipping_tool($('#finalImg'));
    $('#replaceImg').click(function(){
        $(".tailoring-container").toggle();
    });
</script>
</body>
</html>
