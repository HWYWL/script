layui.config({
    base : "js/"
}).use(['form','layer','jquery','laypage'],function() {

    layui.use('code', function(){ //加载code模块
        layui.code(); //引用code方法
    });

    //提交新增脚本数据
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,$ = layui.jquery;

        //监听提交
        form.on('submit(submitScript)', function(data){
            if (data.field.enable == "on"){
                data.field.enable = 0;
            }else {
                data.field.enable = -1;
            }

            var index = parent.layer.getFrameIndex(window.name);

            var scriptInfo = JSON.stringify(data.field);
            layer.confirm('确定提交?', {icon: 3, title:'提交'}, function(index){
                $.ajax({
                    type:"post",
                    url:"/save",
                    data:scriptInfo,
                    async : false,
                    dataType : "json",
                    contentType: "application/json",
                    success:function(result){
                        if(result.code == 0){
                            layer.load(1,{time: 1000});
                            setTimeout(function(){
                                layer.msg(result.msg,{icon:1});
                            },1000);

                            setTimeout(function(){
                                parent.layer.close(index);
                                window.parent.location.reload();
                            },3000);
                        }else {
                            layer.load(1,{time: 1000});
                            setTimeout(function(){
                                layer.msg(result.msg,{icon:5});
                            },1000);
                        }
                    }
                });
            });

            return false;
        });


    });
});
