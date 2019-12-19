<%--
  Created by IntelliJ IDEA.
  User: XJ
  Date: 2019/12/19
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户信息</title>
    <link rel="shortcut icon" href="/static/images/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/static/css/font.css">
    <link rel="stylesheet" href="/static/css/xadmin.css">
    <script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/static/js/ztree/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="/static/js/ztree/jquery.ztree.excheck.js"></script>
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
            <th>用户Id编号</th>
            <th>用户名</th>
            <th>头像</th>
            <th>性别</th>
            <th>出生日期</th>
            <th>邮箱</th>
            <th>家庭地址</th>
            <th>年龄</th>
            <th>备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${info.list}" var="i" varStatus="v">
            <tr>
                <td>${v.index+1}</td>
                <td>${i.loginUid}</td>
                <td>${i.infoName}</td>
                <td><img src="${i.infoImg}"/></td>
                <td>${i.infoGender}</td>
                <td>${i.infoBirthday}</td>
                <td>${i.infoEmail}</td>
                <td>${i.infoAddress}</td>
                <td>${l.infoAge}</td>
                <td>${l.infoDesc}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="page">
        <div>
            <a class="num" href="/user/inUser?pageNum=1">首页</a>
            <a class="num" href="/user/inUser?pageNum=${info.prePage}">上一页</a>
            <c:forEach items="${info.navigatepageNums}" var="n">
                <a class="num" href="/user/inUser?pageNum=${n}">${n}</a>
            </c:forEach>
            <a class="num" href="/user/inUser?pageNum=${info.nextPage}">下一页</a>
            <a class="num" href="/user/inUser?pageNum=${info.pageSize}">尾页</a>
        </div>
    </div>

</div>
</body>
</html>
