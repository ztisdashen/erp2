var listParam ="";

$(function () {
    $('#dg').datagrid({
        url: actionName+"_findAll.action"+listParam,
        columns: columns,
        //是否条纹显示
        striped:true,
        pagePosition:'bottom',
        pageList:[3,5,10],
        //初始化页码
        pageNumber:1,
        //初始size
        pageSize:10,
        //显示分页工具栏
        pagination:true,
        singleSelect:true,
        toolbar:[
            {
                text:'新增',
                iconCls: 'icon-add',
                handler:function () {
                    var b = $("#winSave").closed;
                    if(!b){
                        $("#winSave").window("open")
                    }
                }
            }
        ]
    });
    $("#btn").bind('click',function () {
        // 引入上面的serializejson.js，解析form数据
        var json = $("#searchForm").serializeJSON();
        //load 通过json发起请求，根据返回的数据重新加载
        $('#dg').datagrid("load",json);

        $("#searchForm").form("clear");

    });
});

function del(uuid) {
    $.messager.confirm(
        "确认",
        "确定要删除吗",function (msg) {
            if(msg){
                var url= actionName+"_delete.action";
                $.post(url,{uuid:uuid},function (data) {
                    $.messager.alert("提示",data.msg,"info",function () {
                        $("#dg").datagrid("reload");
                    })
                },"json")
            }
        })
}
//将查的数据显示在表格上
function edit(uuid) {
    $("#winEdit").window("open");
    $('#formEdit').form('load',actionName+'_edit.action?uuid='+uuid);
}


function edit2(s1,s2) {
    var b = $("#form"+s1).form("validate");
    if(!b)
        return;
    else {
        $("#form"+s1).form("submit",{
            url:actionName+'_'+s2+".action"+listParam,
            success:function (data) {
                var data2 = eval('(' + data + ')'); // change the JSON string to javascript object
                $.messager.show({
                    title:'提示',
                    msg:data2.msg,
                    timeout:2000,
                    showType:'slide'
                });
                $("#win"+s1).window('close');
                $("#dg").datagrid('reload');
                //清楚form中的数据
                $("#form"+s1).form("clear");
            }
        })
    }

}