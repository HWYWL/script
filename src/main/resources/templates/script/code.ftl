<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>代码显示</title>
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
            <img src="/image/2.gif" class="img-responsive center-block" alt="Cinque Terre">
            <h3 class="text-center">代码查看</h3>
<pre class="layui-code">
//返回结果
code:${message.code}    ---     msg:${message.msg}
</pre>
<h3 class="text-center">====================================================================</h3>
<pre class="layui-code">
//代码区域
${message.data}
</pre>
        </div>
    </div>
</div>

<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/js/operate.js"></script>
</body>
</html>