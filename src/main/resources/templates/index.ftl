<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>脚本管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/script.css">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <img src="/image/logo.gif" class="img-responsive center-block" alt="Cinque Terre">
            <h3 class="text-center">
                脚本管理
            </h3>
        </div>
    </div>
</div>

<div class="leftright">
    <script type="text/html" id="titleTpl"></script>

<#--表单-->
    <table class="layui-hide" id="scriptTable" lay-filter="useruv"></table>
    <script type="text/html" id="switchTpl">
        <input type="checkbox" checked name="enable" lay-skin="switch" lay-text="生效|失效" lay-filter="switchEnable">
    </script>

<#--按键-->
    <script type="text/html" id="buttonl">
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">
            <i class="layui-icon">&#xe60a;</i>查看</a>
        <a class="layui-btn layui-btn-xs" lay-event="exe">
            <i class="layui-icon">&#xe623;</i>执行</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">
            <i class="layui-icon">&#xe640;</i>删除</a>
    </script>
</div>


<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/js/script.js"></script>
</body>
</html>