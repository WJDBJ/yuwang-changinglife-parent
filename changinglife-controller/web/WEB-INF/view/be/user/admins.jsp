<%--
  Created by IntelliJ IDEA.
  User: XJ
  Date: 2019/12/19
  Time: 9:32
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
<br/>
<div class="layui-row">
    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal_insert">
        添加新的管理者
    </button>
</div>
<br/>
<xblock class="alert alert-danger"></xblock>
<div class="x-body">
    <table class="layui-table">
        <thead>
        <tr>
            <th>序号</th>
            <th>用户Id编号</th>
            <th>用户账号</th>
            <th>用户密码</th>
            <th>用户身份</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${info.list}" var="i" varStatus="v">
            <tr>
                <td>${v.index+1}</td>
                <td>${i.loginId}</td>
                <td>${i.loginAccoun}</td>
                <td>${i.loginPassword}</td>
                <td>${i.statusName}</td>
                <td>
                    <c:if test="${i.statusName != '管理员'}">
                        <button class="pr layui-btn layui-btn-sm layui-btn-danger" data-toggle="modal"
                                data-target="#myModal_privilege" data="${i.loginId}">升级权限</button>
                    </c:if>
                    <button class="delete layui-btn layui-btn-sm layui-btn-danger" data="${i.loginId}">删除</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="page">
        <div>
            <a class="num" href="/admin/inAdmin?pageNum=1">首页</a>
            <a class="num" href="/admin/inAdmin?pageNum=${info.prePage}">上一页</a>
            <c:forEach items="${info.navigatepageNums}" var="n">
                <a class="num" href="/admin/inAdmin?pageNum=${n}">${n}</a>
            </c:forEach>
            <a class="num" href="/admin/inAdmin?pageNum=${info.nextPage}">下一页</a>
            <a class="num" href="/admin/inAdmin?pageNum=${info.pageSize}">尾页</a>
        </div>
    </div>

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
                    添加管理者
                </h4>
            </div>
            <div class="modal-body">
                用户账号：<input type="text" id="login_name" class="form-control"/><br/>
                用户密码：<input type="text" id="login_pwd" class="form-control"/><br/>
                用户身份：<select class="status_name">
                <option aria-checked="true">请选择</option>
            </select>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" id="add" class="btn btn-primary" data-dismiss="modal">
                    确认添加
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- 授权的模态框（Modal） -->
<div class="modal fade" id="myModal_privilege" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel_privilege">
                    升级权限
                </h4>
            </div>
            <div class="modal-body">
                身份：<select class="status_name">
                <option aria-checked="true">请选择</option>
            </select>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" id="privilege" class="btn btn-primary" data-dismiss="modal">
                    确认授权
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script src="/static/js/be/admins.js"></script>
</body>
</html>

