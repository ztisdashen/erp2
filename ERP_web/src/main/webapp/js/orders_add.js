//保存当编辑的行的索引
var existEditIndex = -1;
$(function () {
    $('#grid').datagrid({
        columns: [[
            {
                field: 'goodsuuid', title: '商品编号', width: 100, editor: {
                    type: 'numberbox', options: {
                        //禁止编辑
                        disabled: true
                    }
                }
            },
            {
                field: 'goodsname', title: '商品名称', width: 100, editor: {
                    type: 'combobox', options: {
                        url: 'goods_listAll.action',
                        valueField: 'name',
                        textField: 'name',
                        onSelect: function (goods) {
                            //获取商品编辑编辑器
                            var goodsuuidEditor = getEditor('goodsuuid');
                            //target，指向真正使用element
                            $(goodsuuidEditor.target).val(goods.uuid);

                            //获取价格编辑器
                            var priceEditor = getEditor('price');
                            //设置为进货价格
                            $(priceEditor.target).val(goods.inprice);
                            cal();
                            var numEditor = getEditor('num');
                            $(numEditor.target).select();
                            bindGridEditor();
                            sum();


                        }
                    }
                }
            },
            {
                field: 'price',
                title: '价格',
                width: 100,
                editor: {type: 'numberbox', options: {precision: 2, disabled: true}}
            },
            {field: 'num', title: '数量', width: 100, editor: 'numberbox'},
            {
                field: 'money',
                title: '金额',
                width: 100,
                editor: {type: 'numberbox', options: {precision: 2, disabled: true}}
            },
            {
                field: '-', title: '操作', width: 100, formatter: function (value, row, rowIndex) {
                    if (row.num != '合计') {
                        return '<a href="javascript:void(0)" onclick="deleteRow(' + rowIndex + ')">删除</a>';
                    }
                }
            }

        ]],
        singleSelect: true,
        //显示编辑
        rownumbers: true,
        //显示过行脚
        showFooter: true,
        toolbar: [
            {
                text: '新增',
                iconCls: 'icon-add',
                handler: function () {
                    //判断是否存在编辑的行
                    if (existEditIndex > -1) {
                        //关闭编辑
                        $('#grid').datagrid('endEdit', existEditIndex);
                    }
                    //增加一行, row参数:{goodsuuid:'',goodsname:'',price:''}
                    $('#grid').datagrid('appendRow', {num: 0, money: 0});
                    //获取所的行记录，数组
                    var rows = $('#grid').datagrid('getRows');

                    //设置当前编辑行的索引
                    existEditIndex = rows.length - 1;
                    //需要先设置它的编辑器，才能开启编辑状态
                    $('#grid').datagrid('beginEdit', existEditIndex);

                }
            }, '-', {
                text: '提交',
                iconCls: 'icon-save',
                handler: function () {
                    if (existEditIndex > -1) {
                        $('#grid').datagrid('endEdit', existEditIndex);
                    }
                    var rows = $('#grid').datagrid('getRows');
                    /**
                     * rows中没有footer的内容
                     */
                    if (rows.length == 0)
                        return;
                    var formData = $("#orderForm").serializeJSON();
                    formData.json = JSON.stringify(rows);
                    $.post('orders_add.action',formData,function (data) {
                        $.messager.alert("提示",data.msg,'info',function () {
                            $("#supplier").combogrid("clear");
                            $("#grid").datagrid("loadData",{total:0,rows:[],footer:{num:'合计',money:0}})
                        })
                    },'json')

                }

            }
        ],
        onClickRow: function (rowIndex, rowData) {
            //rowIndex：点击的行的索引值，该索引值从0开始。
            //rowData：对应于点击行的记录。
            //关闭当前可以编辑的行
            $('#grid').datagrid('endEdit', existEditIndex);
            //设置当前可编辑的索引行
            existEditIndex = rowIndex;
            $('#grid').datagrid('beginEdit', existEditIndex);
            bindGridEditor()
        }
    });

    $("#grid").datagrid('reloadFooter', [{num: '合计', money: 0}]);


    $('#supplier').combogrid({
        url: 'supplier_listAll.action?type=1',
        idField: 'uuid',
        textField: 'name',
        panelWidth: 450,
        columns: [[
            {field: 'uuid', title: '编号', width: 100},
            {field: 'name', title: '用户性名', width: 100},
            {field: 'address', title: '地址', width: 150},
            {field: 'contact', title: '联系人', width: 150},
            {field: 'tele', title: '电话', width: 100},
            {field: 'email', title: '邮件', width: 200}
        ]]
    });
});

/**
 * 获取当前编辑行的指定编辑器
 * @param _field
 * @returns
 */
function getEditor(_field) {
    return $('#grid').datagrid('getEditor', {index: existEditIndex, field: _field});
}

/**
 * 计算金额
 */
function cal() {
    var numEditor = getEditor('num');
    var num = $(numEditor.target).val();
    //获取价格编辑器
    var priceEditor = getEditor('price');
    //设置为进货价格
    var price = $(priceEditor.target).val();
    //保留两位
    var total = (price * num).toFixed(2);
    //获取价格编辑器
    var moneyEditor = getEditor('money');
    //设置为进货价格
    $(moneyEditor.target).val(total);

    /**
     * 只是显示
     * 更新表格的数据
     */
    $('#grid').datagrid('getRows')[existEditIndex].money = total;
}

/**
 * 绑定键盘的编辑器
 */
function bindGridEditor() {
    var numEditor = getEditor('num');
    $(numEditor.target).bind('keyup', function () {
        cal();
        sum();
    })
}

function sum() {
    var rows = $('#grid').datagrid('getRows');
    var total = 0;
    $.each(rows, function (i, row) {
        total += parseFloat(row.money);
    });
    $("#grid").datagrid('reloadFooter', [{num: '合计', money: total}])
}

/**
 * 解决第一次删除行后rowIndex没有发生变化的问题
 * @param rowIndex
 */
function deleteRow(rowIndex) {
    /**
     * 还要关闭正在编辑的row，否则会被清除
     */
    $('#grid').datagrid('endEdit', existEditIndex);
    $("#grid").datagrid('deleteRow', rowIndex);
    var data = $("#grid").datagrid('getData');
    $("#grid").datagrid('loadData', data);
    sum();
}