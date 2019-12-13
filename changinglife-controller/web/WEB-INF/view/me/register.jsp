<%--
  Created by IntelliJ IDEA.
  User: XJ
  Date: 2019/12/3
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/style.css">
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/js/bootstrap.js"></script>
</head>
<body>

<div class="form" style="position:relative">
    <c:if test="${!empty msg}">
        <div style="height: 50px; width: 100%; background-color: red;color: white;text-align: center">
            <h3>${msg}</h3>
        </div>
    </c:if>
    <!--注册表单-->
    <div class="form_register" style="position:absolute">
        <form action="/loginInfo/inRegister">
            <h1>注册</h1>
            <div class="form_item">
                <label for="username">用户名：</label>
                <input type="text" name="loginAccoun" id="username"
                       placeholder="请输入用户名" value="${Login.loginAccoun}" required >
            </div>
            <div class="form_item">
                <label for="password">密码：</label>
                <input type="password" name="loginPassword" id="password"
                       placeholder="请输入密码名" value="${Login.loginPassword}" required>
            </div>
            <div class="form_item">
                <label for="username">用户昵称：</label>
                <input type="text" name="loginName" id="loginname"
                       placeholder="请输入用户昵称" value="${Login.loginName}" required >
            </div>
            <div class="form_item">
                <input type="submit" value="注册">
            </div>
        </form>
        <div class="info">已有账号？点击<a href="/login/login" class="switch login_Btn">登录</a></div>
    </div>
</div>

</body>
</html>
