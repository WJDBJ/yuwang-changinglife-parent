<%--
  Created by IntelliJ IDEA.
  User: XJ
  Date: 2019/12/3
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登陆</title>
    <link rel="stylesheet" href="/static/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/static/css/login.css" media="all"/>
    <style>
        /* 覆盖原框架样式 */
        .layui-elem-quote{background-color: inherit!important;}
        .layui-input, .layui-select, .layui-textarea{background-color: inherit; padding-left: 30px;}
    </style>
</head>
<body>
<!-- Head -->
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-sm12 layui-col-md12 zyl_mar_01">
            <blockquote class="layui-elem-quote">钰网登录</blockquote>
        </div>
    </div>
</div>
<!-- Head End -->

<!-- Carousel -->
<div class="layui-row">
    <div class="layui-col-sm12 layui-col-md12">
        <div class="layui-carousel zyl_login_height" id="zyllogin" lay-filter="zyllogin">
            <div carousel-item="">
                <div>
                    <div class="zyl_login_cont"></div>
                </div>
                <div>
                    <img src="/static/img/carousel/01.jpg" />
                </div>
                <div>
                    <div class="background">
                        <span></span><span></span><span></span>
                        <span></span><span></span><span></span>
                        <span></span><span></span><span></span>
                        <span></span><span></span><span></span>
                    </div>
                </div>
                <div>
                    <img src="/static/img/carousel/03.jpg" />
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Carousel End -->

<!-- Footer -->
<div class="layui-row">
    <div class="layui-col-sm12 layui-col-md12 zyl_center zyl_mar_01">
        © 2019 - 钰网后台登陆界面 || 钰网——改变生活
    </div>
</div>
<!-- Footer End -->



<!-- LoginForm -->
<div class="zyl_lofo_main">
    <fieldset class="layui-elem-field layui-field-title zyl_mar_02">
        <legend>欢迎登陆</legend>
    </fieldset>
    <div class="layui-row layui-col-space15">
        <form class="layui-form zyl_pad_01"  action="/login/inLogin">
            <div class="layui-col-sm12 layui-col-md12">
                <div class="layui-form-item">
                    <input type="text" name="loginAccoun" lay-verify="required|userName" autocomplete="off"
                           placeholder="用户名" class="layui-input" value="${Login.loginAccoun}">
                    <i class="layui-icon layui-icon-username zyl_lofo_icon"></i>
                </div>
            </div>
            <div class="layui-col-sm12 layui-col-md12">
                <div class="layui-form-item">
                    <input type="password" name="loginPassword" lay-verify="required|pass" autocomplete="off"
                           placeholder="密码" class="layui-input" value="${Login.loginPassword}">
                    <i class="layui-icon layui-icon-password zyl_lofo_icon"></i>
                </div>
            </div>
            <div class="layui-col-sm12 layui-col-md12">
                <div class="layui-row">
                    <div class="layui-col-xs4 layui-col-sm4 layui-col-md4">
                        <div class="layui-form-item">
                            <input type="text" name="vercode" id="vercode" lay-verify="required|vercodes"
                                   autocomplete="off" placeholder="验证码" class="layui-input" maxlength="4">
                            <i class="layui-icon layui-icon-vercode zyl_lofo_icon"></i>
                        </div>
                    </div>
                    <div class="layui-col-xs4 layui-col-sm4 layui-col-md4">
                        <div class="zyl_lofo_vercode zylVerCode" onclick="zylVerCode()"></div>
                    </div>
                </div>
            </div>
            <div class="layui-col-sm12 layui-col-md12">
                <button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="demo1">立即登录</button>
            </div>
        </form>
        <div class="layui-col-sm12 layui-col-md12" style="text-align:center;font-size: 14px;margin-bottom: 20px;">
            没有账号？立刻<a href="/register/register" style="color: crimson;margin-left: 3px;">注册</a></div>
    </div>
</div>
<!-- LoginForm End -->


<!-- Jquery Js -->
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<!-- Layui Js -->
<script type="text/javascript" src="/static/layui/layui.js"></script>
<!-- Jqarticle Js -->
<script type="text/javascript" src="/static/assembly/jqarticle/jparticle.min.js"></script>
<!-- ZylVerificationCode Js-->
<script type="text/javascript" src="/static/assembly/zylVerificationCode/zylVerificationCode.js"></script>
<script>
    layui.use(['carousel', 'form'], function(){
        var carousel = layui.carousel
            ,form = layui.form;

        //自定义验证规则
        form.verify({
            userName: function(value){
                if(value == ""){
                    return '用户名不能为空';
                }
            }
            ,pass: [/^[\S]{6,20}$/,'密码必须6到20位，且不能出现空格']
            ,vercodes: function(value){
                //获取验证码
                var zylVerCode = $(".zylVerCode").html();
                if(value!=zylVerCode){
                    return '验证码错误（区分大小写）';
                }
            }
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field),{
                title: '最终的提交信息'
            });
            //return false;
        });


        //设置轮播主体高度
        var zyl_login_height = $(window).height()/1.3;
        var zyl_car_height = $(".zyl_login_height").css("cssText","height:" + zyl_login_height + "px!important");


        //Login轮播主体
        carousel.render({
            elem: '#zyllogin'//指向容器选择器
            ,width: '100%' //设置容器宽度
            ,height:'zyl_car_height'
            ,arrow: 'always' //始终显示箭头
            ,anim: 'fade' //切换动画方式
            ,autoplay: true //是否自动切换false true
            ,arrow: 'hover' //切换箭头默认显示状态||不显示：none||悬停显示：hover||始终显示：always
            ,indicator: 'none' //指示器位置||外部：outside||内部：inside||不显示：none
            ,interval: '5000' //自动切换时间:单位：ms（毫秒）
        });

        //监听轮播--案例暂未使用
        carousel.on('change(zyllogin)', function(obj){
            var loginCarousel = obj.index;
        });

        //粒子线条
        $(".zyl_login_cont").jParticle({
            background: "rgba(0,0,0,0)",//背景颜色
            color: "#fff",//粒子和连线的颜色
            particlesNumber:100,//粒子数量
            //disableLinks:true,//禁止粒子间连线
            //disableMouse:true,//禁止粒子间连线(鼠标)
            particle: {
                minSize: 1,//最小粒子
                maxSize: 3,//最大粒子
                speed: 30,//粒子的动画速度
            }
        });

    });
</script>
</body>
</html>