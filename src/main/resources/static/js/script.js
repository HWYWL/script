layui.use(['table','form'], function() {
    $ = layui.jquery;
    table = layui.table;
    tableIns = initTable();
});

function initTable() {

    layui.use('table', function(){
        var table = layui.table
            ,form = layui.form;

        table.render({
            elem: '#scriptTable'
            ,url:'/fidnAllScript'
            ,cellMinWidth: 20 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'command', title: '脚本路径'}
                ,{field:'path', title: '命令'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field:'remark', title: '备注'}
                ,{field:'type', title: '脚本类型', templet: '#titleTpl', unresize: true}
                ,{field:'enable'+' checked', title: '是否有效', templet: '#switchTpl', unresize: true}
                ,{field:'host', title: '远程脚本IP'} //单元格内容水平居中
                ,{field:'userName', title: '服务器账号'} //单元格内容水平居中
                ,{field:'passWord', title: '服务器密码'} //单元格内容水平居中
                ,{field:'crttime', title: '创建时间'}
                ,{field:'', title: '查看/执行/删除', templet: '#buttonl', unresize: true}
            ]]
            ,done: function (res, curr, count) {
                //分类显示中文名称
                $("[data-field='type']").children().each(function(){
                    if($(this).text()=='0'){
                        $(this).text("linux命令")
                    }else if($(this).text()=='1'){
                        $(this).text("linux shll脚本")
                    }else if($(this).text()=='2'){
                        $(this).text("windows命令")
                    }else if($(this).text()=='3'){
                        $(this).text("windows bat脚本")
                    }
                });
            }
        });

        //工具栏操作
        table.on('tool(useruv)', function(obj){
            var data = obj.data;
            var scriptInfo = '{"id":"'+data.id+'",';
            scriptInfo += '"path":"'+data.path+'",';
            scriptInfo += '"command":"'+data.command+'",';
            scriptInfo += '"type":"'+data.type+'",';
            scriptInfo += '"remark":"'+data.remark+'",';
            scriptInfo += '"enable":"'+data.enable+'",';
            scriptInfo += '"host":"'+data.host+'",';
            scriptInfo += '"userName":"'+data.userName+'",';
            scriptInfo += '"passWord":"'+data.passWord+'",';
            scriptInfo += '"del":"'+data.del+'",';
            scriptInfo += '"crttime":"'+data.crttime+'"}';

            if(obj.event === 'detail'){
                layer.open({
                    type: 2,
                    title: 'ID：'+ data.id + ' 的查看操作',
                    shadeClose: true,
                    shade: 0.8,
                    area: ['70%', '90%'],
                    about:true,

                    content: '/detail?id=' + data.id
                });
            } else if(obj.event === 'del'){
                layer.confirm('确定删除?', {icon: 3, title:'删除'}, function(index){
                    $.ajax({
                        url: "/delID",
                        type: "POST",
                        data : scriptInfo,
                        async : false,
                        dataType : "json",
                        contentType: "application/json",
                        success: function(data){
                            if(data.code == 0){
                                obj.del();
                                layer.close(index);
                                layer.msg("删除成功", {icon: 6});
                            }else{
                                layer.msg("删除失败", {icon: 5});
                            }
                        }

                    });
                });
            } else if(obj.event === 'exe'){
                layer.confirm('确定执行?', {icon: 3, title:'执行'}, function(index){
                    layer.open({
                        type: 2,
                        title: 'ID：'+ data.id + ' 执行脚本',
                        shadeClose: true,
                        shade: 0.8,
                        area: ['70%', '90%'],
                        about:true,

                        content: '/execute?id=' + data.id
                    });
                    layer.close(index);
                });
            }
        });

        //监听是否有效按钮
        form.on('switch(switchEnable)', function(obj){
            layer.load(0,{time: 2*1000});
            setTimeout(function(){
                layer.msg('修改成功!',{icon:1});
            },2000);
        });
    });
}

