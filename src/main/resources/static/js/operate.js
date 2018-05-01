layui.config({
    base : "js/"
}).use(['form','layer','jquery','laypage'],function() {

    layui.use('code', function(){ //加载code模块
        layui.code(); //引用code方法
    });

});
