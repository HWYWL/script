<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>添加脚本</legend>
</fieldset>

<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">脚本路径</label>
        <div class="layui-input-block">
            <input type="text" name="path" autocomplete="off" placeholder="请输入脚本路径,如果是命令此处可为空!" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">命令</label>
        <div class="layui-input-block">
            <input type="text" name="command" lay-verify="required" autocomplete="off" placeholder="请输入命令或启动脚本的完整文件路径" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <input type="text" name="remark" autocomplete="off" placeholder="请输入备注!" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">脚本类型</label>
        <div class="layui-input-block">
            <select name="type" lay-filter="aihao">
                <option value=""></option>
                <option value="0" selected="">linux命令</option>
                <option value="1">linux shll脚本</option>
                <option value="2">windows命令</option>
                <option value="3">windows bat脚本</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">是否有效</label>
        <div class="layui-input-block">
            <input type="checkbox" checked="" name="enable" lay-skin="switch" lay-filter="switchEnable" lay-text="有效|失效">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">IP地址</label>
        <div class="layui-input-block">
            <input type="text" name="host" autocomplete="off" placeholder="请输入远程服务器IP地址,如果是本地脚本或命令此处可为空!" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="userName" autocomplete="off" placeholder="请输入登录服务器账号,如果是本地脚本或命令此处可为空!" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="text" name="passWord" autocomplete="off" placeholder="请输入登录服务器密码,如果是本地脚本或命令此处可为空!!" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="submitScript">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/js/operate.js"></script>

</body>
</html>