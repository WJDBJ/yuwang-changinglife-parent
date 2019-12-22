<%--
  Created by IntelliJ IDEA.
  User: XJ
  Date: 2019/12/22
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户信息</title>
    <script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
    <link rel="shortcut icon" href="/static/images/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/static/css/font.css">
    <link rel="stylesheet" href="/static/css/xadmin.css">
    <script type="text/javascript" src="/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/js/xadmin.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <link rel="stylesheet" href="/static/css/bootstrapStyle/bootstrapStyle.css" type="text/css">
    <script src="/static/js/bootstrap.js"></script>
</head>
<body class="layui-anim layui-anim-up">
<div class="x-nav">
    <a class="layui-btn layui-btn-primary layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:38px">ဂ</i></a>
</div>
<div class="x-body">
    <table class="layui-table">
        <thead>
        <tr>
            <th>序号</th>
            <th>视频Id编号</th>
            <th>视频名称</th>
            <th>上传时间</th>
            <th>上传用户编号</th>
            <th>视频简介</th>
            <th>视频审核</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${info.list}" var="i" varStatus="v">
            <tr>
                <td>${v.index+1}</td>
                <td>${i.videoId}</td>
                <td>${i.videoName}</td>
                <td>${i.videoReleasetime}</td>
                <td>${i.videoRublisher}</td>
                <td>${i.videoIntroduction}</td>
                <c:if test="${i.videoAudit == 'N'}">
                    <td>未审核</td>
                </c:if>
                <td>
                    <a class="audit layui-btn layui-btn-sm layui-btn-danger"
                       href="/audit/auditList?videoId=${i.videoId}&videoAddress=${i.videoAddress}">审核</a>
                    <button class="delete layui-btn layui-btn-sm layui-btn-danger" data="${i.videoId}"
                            datas = "${i.videoAddress}">
                        退回
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="page">
        <div>
            <a class="num" href="/audit/inAudit?pageNum=1">首页</a>
            <a class="num" href="/audit/inAudit?pageNum=${info.prePage}">上一页</a>
            <c:forEach items="${info.navigatepageNums}" var="n">
                <a class="num" href="/audit/inAudit?pageNum=${n}">${n}</a>
            </c:forEach>
            <a class="num" href="/audit/inAudit?pageNum=${info.nextPage}">下一页</a>
            <a class="num" href="/audit/inAudit?pageNum=${info.pageSize}">尾页</a>
        </div>
    </div>
</div>
</body>

</html>
