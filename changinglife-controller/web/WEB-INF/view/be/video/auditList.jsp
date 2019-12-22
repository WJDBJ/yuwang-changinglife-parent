<%--
  Created by IntelliJ IDEA.
  User: XJ
  Date: 2019/12/22
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
    <!--封装好的视频布局样式-->
    <link rel="stylesheet" href="/static/css/jsmodern.min.css">
    <!--mp4视频插件-->
    <script src="/static/js/jsmodern.min.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <script src="/static/js/bootstrap.js"></script>

    <style>
        #video {
            width: 970px;
            height: 594px;
            margin: 0 auto;
            position: relative;
        }

        #video video {
            width: 100%;
            height: 100%;
            object-fit: fill;
        }

        .VideoBtn {
            position: absolute;
            left: 50%;
            top: 50%;
            display: block;
            width: 70px;
            height: 70px;
            margin-left: -35px;
            margin-top: -35px;
            cursor: pointer;
            z-index: 10;
        }
    </style>
</head>
<body>
<button class="btns btn btn-primary btn-lg" data="${videoId}" data-toggle="modal" data-target="#myModal_insert"
        style="margin-top: 10px; margin-left: 10px;">
    开始审核
</button>
<div id="video">
    <video src="/film/download?filename=${videoAddress}" id="videoShow"></video>
    <span class="VideoBtn"><img src="/static/images/bo1.png"></span>
</div>
<!-- 添加的模态框（Modal） -->
<div class="modal fade" id="myModal_insert" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    审核
                </h4>
            </div>
            <div class="modal-body">
                视频类型<select id="typePid"></select><br/>
                <button type="button" class="btnx btn btn-primary">添加该类型</button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" id="add" class="btn btn-primary" data-dismiss="modal">
                    审核通过
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script src="/static/js/be/auditList.js"></script>
</body>
</html>
<%--https://blz-videos.nosdn.127.net/1/OverWatch/AnimatedShots/Overwatch_AnimatedShot_Soldier76_Hero.mp4--%>