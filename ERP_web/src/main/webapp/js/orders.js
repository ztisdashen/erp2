$(function () {
    var url ="orders_findAll.action?type=1";
    if(Request['operation'] == 'doCheck'){
        url += "&state=0"
    }
    if(Request['operation'] == 'doStart'){
        url += "&state=1"
    }
    if(Request['operation'] == 'doInStore'){
        url += "&state=2"
    }
    $('#dg').datagrid({
        url: url,
        columns: [[
            {field: 'uuid', title: '编号', width: 50},
            {field: 'createtime', title: '生成日期', width: 80,formatter:formatDate},
            {field: 'checktime', title: '审核日期', width: 80,formatter:formatDate},
            {field: 'starttime', title: '确认日期', width: 80,formatter:formatDate},
            {field: 'endtime', title: '入库或出库日期', width: 80,formatter:formatDate},
            {field: 'type', title: '类型', width: 80,formatter:getType},
            {field: 'createrName', title: '下单员', width: 80},
            {field: 'checkerName', title: '审核员', width: 80},
            {field: 'starterName', title: '采购员', width: 80},
            {field: 'enderName', title: '库管员', width: 80},
            {field: 'supplierName', title: '供应商', width: 50},
            {field: 'totalmoney', title: '总价', width: 50},
            {field: 'state', title: '状态', width: 50,formatter:getState},
            {field: 'waybillsn', title: '电话', width: 50}
        ]],
        //是否条纹显示
        striped:true,
        pagePosition:'bottom',
        pageList:[3,5,10],
        //初始化页码
        pageNumber:1,
        fitColumns:true,
        //初始size
        pageSize:10,
        //显示分页工具栏
        pagination:true,
        singleSelect:true,
        onDblClickRow:function (rowIndex, rowData) {
            $("#uuid").html(rowData.uuid);
            $("#createrName").html(rowData.createrName);
            $("#createtime").html(formatDate(rowData.createtime));
            $("#checkerName").html(rowData.checkerName);
            $("#checktime").html(formatDate(rowData.checktime));
            $("#starterName").html(rowData.starterName);
            $("#starttime").html(formatDate(rowData.starttime));
            $("#enderName").html(rowData.enderName);
            $("#endtime").html(formatDate(rowData.endtime));
            $("#supplierName").html(rowData.supplierName);
            $("#state").html(getState(rowData.state));
            $("#itemDetail").datagrid("loadData",rowData.orderdetails);
            $("#ordersDlg").dialog("open")
        }
    });
    $("#itemDetail").datagrid({
        columns:[[
            {field:'uuid',title:'编号',width:100},
            {field:'goodsuuid',title:'商品编号',width:100},
            {field:'goodsname',title:'商品名称',width:100},
            {field:'price',title:'价格',width:100},
            {field:'num',title:'数量',width:100},
            {field:'money',title:'总价',width:100},
            {field:'state',title:'状态',width:100,formatter:getDetailState}
        ]],
        singleSelect:true,
        fitColumns:true

    });
    if(Request['operation'] == 'doCheck'){
        $("#itemDetail").datagrid({
            toolbar:[{
                text:'审核',
                iconCls:'icon-search',
                handler:doCheck
            }]
        })
    }
    if(Request['operation'] == 'doStart'){
        $("#itemDetail").datagrid({
            toolbar:[{
                text:'确认',
                iconCls:'icon-search',
                handler:doStart
            }]
        })
    }
    if(Request['operation'] == 'doInStore'){
        $("#itemDetail").datagrid({
            onDblClickRow:function (rowIndex,rowData) {
                $("#itemDlg").dialog('open');
                $("#orderUUID").val(rowData.uuid);
                $("#goodsname").html(rowData.goodsname);
                $("#goodsnum").html(rowData.num);
                $("#goodsuuid").html(rowData.goodsuuid)


            }
        })
    }
    $("#itemDlg").dialog({
        width:300,
        height:200,
        title:"入库",
        modal:true,
        closed:true,
        buttons:[{
            iconCls:'icon-save',
            text:'入库',
            handler:doInStore
        }]
    })
});
function doInStore() {
    var formData = $("#orderDetail").serializeJSON();
    if(formData.storeuuid == ""){
        $.messager.alert("提示","请选择仓库",'info');
        return;
    }
    $.messager.confirm('确认','确认要入库吗',function (yes) {
        if(yes){
            var url = "orderDetail_doInStore.action";
            $.post(url,formData,function (data) {
                $.messager.alert("提示",data.msg,'info',function () {
                    if(data.success){
                        $("#itemDlg").dialog("close");
                        var row = $("#itemDetail").datagrid('getSelected');
                        row.state = "1";
                        var formData2 = $("#itemDetail").datagrid("getData");
                        $("#itemDetail").datagrid("loadData",formData2);
                        var allIn = true;
                        $.each(formData2.rows,function (i,row) {
                            if(row.state * 1 == "0"){
                                allIn = false;
                                return false;
                            }
                        });
                        if(allIn){
                            $("#ordersDlg").dialog("close");
                            $("#dg").datagrid("reload")
                        }
                    }
                })
            },'json');
        }
    })
}
function doCheck() {
    $.messager.confirm('确认','确认要审核吗',function (yes) {
        if(yes){
            var url = "orders_doCheck.action?uuid="+$("#uuid").html();
            $.get(url,function (data) {
                $.messager.alert("提示",data.msg,'info',function () {
                    if(data.success){
                        $("#ordersDlg").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            },'json');
        }
    })
}
function doStart() {
    $.messager.confirm('确认','确认要确认吗',function (yes) {
        if(yes){
            var url = "orders_doStart.action?uuid="+$("#uuid").html();
            $.get(url,function (data) {
                $.messager.alert("提示",data.msg,'info',function () {
                    if(data.success){
                        $("#ordersDlg").dialog("close");
                        $("#dg").datagrid("reload");
                    }
                })
            },'json');
        }
    })
}
function getState(value) {
    switch (value * 1) {
        case 0:return "未审核";
        case 1:return "已审核";
        case 2:return "已确认";
        case 3:return "已入库";
        default:return "";
    }
}
function getDetailState(value) {
    switch (value * 1) {
        case 0:return "未入库";
        case 1:return "已入库";
        default:return "";
    }
}
function getType(value) {
    switch (value * 1) {
        case 1:return "已入库";
        case 2:return "已出库";
        default:return "";
    }
}

function formatDate(value) {
    return new Date(value).Format("yyyy-MM-dd");
}