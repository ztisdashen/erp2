$(function () {
    $('#dg').datagrid({
        url: "emp_findAll.action",
        columns: [[
            {field: 'uuid', title: '部门编号', width: 100},
            {field: 'username', title: '登录名', width: 100},
            {field: 'name', title: '用户性名', width: 100},
            {field: 'gender', title: '性别', width: 100,formatter:function (value, row, index) {
                    if(1 == value * 1){
                        return "男"
                    }else
                        return "女"
                }},
            {field: 'email', title: '邮箱', width: 150},
            {field: 'tele', title: '电话', width: 100},
            {field: 'address', title: '地址', width: 200},
            {field: 'birthday', title: '生日', width: 100,formatter:function (value) {
                    return new Date(value).Format("yyyy-MM-dd");
                }},
            {field: 'dep', title: '部门名称', width: 100,formatter:function (value) {
                    return value.name;
                }},
            {field:'ssss',title:'操作',formatter:function (value,row,index) {
                    var del = '<a href="javascript:void(0)" class="menuA" onclick="resetPwd('+row.uuid+')">重置密码</a>';
                    return del;
                },width:150}
        ]],
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
        singleSelect:true
    });
});

function subPWD() {
    var json = $("#formEdit").serializeJSON();
    var url = 'emp_resetPWD.action'
    $.post(url,json,function (data) {
        if(data.success){
            $.messager.alert("提示",data.msg,'info');
            $("#winEdit").window('close');
        }else
            $.messager.alert("提示",data.msg,'info');
    },'json')
}
function resetPwd(uuid) {
    $("#winEdit").window('open');
    $('#formEdit').form('clear');
    $('#formEdit').form('load',{uuid:uuid,pwd:''})
}