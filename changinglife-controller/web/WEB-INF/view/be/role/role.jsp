<%--
  Created by IntelliJ IDEA.
  User: XJ
  Date: 2019/12/17
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>角色管理页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<%--    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />--%>
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
    <div class="layui-row">
        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal_insert">
            添加新的身份
        </button>
    </div>
    <xblock class="alert alert-danger"></xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>角色名</th>
            <th>角色备注</th>
            <th>操作</th></tr>
        </thead>
        <tbody>
        <c:forEach items="${status.list}" var="l" varStatus="v">
            <tr>
                <td>${v.index+1}</td>
                <td>${l.statusName}</td>
                <td>${l.statusDescription}</td>
                <td class="td-manage">
                    <button class="privilegeA layui-btn layui-btn-sm layui-btn-danger" data-toggle="modal"
                            data-target="#myModal_privilege" data="${l.statusId}">授权</button>
                    <button id="deleteA" class="layui-btn layui-btn-sm layui-btn-danger" data="${l.statusId}"> 删除</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="page">
        <div>
            <a class="num" href="/role/inRole?pageNum=1">首页</a>
            <a class="num" href="/role/inRole?pageNum=${status.prePage}">上一页</a>
            <c:forEach items="${status.navigatepageNums}" var="n">
                <a class="num" href="/role/inRole?pageNum=${n}">${n}</a>
            </c:forEach>
            <a class="num" href="/role/inRole?pageNum=${status.nextPage}">下一页</a>
            <a class="num" href="/role/inRole?pageNum=${status.pageSize}">尾页</a>
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
                    添加身份信息
                </h4>
            </div>
            <div class="modal-body">
                身份名称：<input type="text" id="status_name" class="form-control"/><br/>
                身份备注：<input type="text" id="status_desc" class="form-control"/>
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
                    添加权限
                </h4>
            </div>
            <div class="modal-body">
                <ul id="tree" class="ztree"></ul>
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

<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });
</script>
<script src="/static/js/be/role.js"></script>
</body>

</html>
