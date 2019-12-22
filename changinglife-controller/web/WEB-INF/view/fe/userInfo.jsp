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
    <script src="https://cdn.bootcss.com/distpicker/2.0.5/distpicker.js"></script>
    <script src="/static/js/fe/userInfo.js"></script>
</head>
<body>
<!-- 置顶 -->
<div class="media" style="background-image: url(/static/images/index.jpg)">
    <div class="media-left media-top">
        <div style="width: 320px;height: 320px;border: solid 1px #555;padding: 5px;margin-top: 10px">
            <img id="finalImg" src="/photo/download?filename=${userInfo.infoImg}" class="media-object" width="100%">
        </div>
        <h2 class="media-heading" style="margin-top: 20px; margin-left: 30px; color: white">${userInfo.infoName}【${userInfo.loginUid}】</h2>
    </div>
    <div class="media-body">
        <button id="replaceImg" class="l-btn" style="margin-top: 50px;">更换图片</button>
        <a href="/feMain/back" class="btn btn-primary" style="width: 100px;">返回主页
        </a>
        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
            修改个人信息
        </button>
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
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    修改用户信息
                </h4>
            </div>
            <div class="modal-body">
                用户名称：<input type="text" id="user_name" class="form-control"/><br/>
                用户性别：<input type="radio" name="user_sex" value="男"/>男
                <input type="radio" name="user_sex" value="女"/>女<br/>
                用户出生日期：<input type="date" id="user_date" /><br/>
                用户地址：
                <div data-toggle="distpicker">
                    <select id="province" data-province="---- 选择省 ----"></select>
                    <select id="city" data-city="---- 选择市 ----"></select>
                    <select id="district" data-district="---- 选择区 ----"></select>
                </div><br/>
                用户简介：<input type="text" id="user_desc" style="height: 200px;"/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" id="updateInfo" class="btn btn-primary">
                    修改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
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
