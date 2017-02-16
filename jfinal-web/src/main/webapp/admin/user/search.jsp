<%--
  Created by IntelliJ IDEA.
  User: sd
  Date: 17/2/16
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title> 搜索表单</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/bui/assets/css/dpl-min.css" rel="stylesheet" type="text/css"/>
    <link href="/bui/assets/css/bui-min.css" rel="stylesheet" type="text/css"/>
    <link href="/bui/assets/css/page-min.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div class="container">

    <form id="searchForm" class="form-horizontal">
        <div class="row">
            <div class="control-group span8">
                <label class="control-label">用户编号：</label>
                <div class="controls">
                    <input type="text" class="control-text" name="user.id">
                </div>
            </div>
            <div class="control-group span8">
                <label class="control-label">用户名：</label>
                <div class="controls">
                    <input type="text" class="control-text" name="user.userName">
                </div>
            </div>
            <div class="control-group span8">
                <label class="control-label">用户密码：</label>
                <div class="controls">
                    <input type="text" class="control-text" name="user.userName">
                </div>
            </div>
            <div class="control-group span8">
                <label class="control-label">性别：</label>
                <div class="controls">
                    <select name="user.sex" id="" onselect="${user.sex}">
                        <option value="1">男</option>
                        <option value="0">女</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="control-group span9">
                <label class="control-label">出生日期：</label>
                <div class="controls">
                    <input name="user.birthDate" type="text" class="calendar" value="${user.birthDate}">
                </div>
            </div>
            <div class="span3 offset2">
                <button type="button" id="btnSearch" class="button button-primary">搜索</button>
            </div>
        </div>
    </form>

    <div class="search-grid-container">
        <div id="grid"></div>
    </div>
</div>
<script type="text/javascript" src="/bui/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/bui/assets/js/bui-min.js"></script>
<script type="text/javascript" src="/bui/assets/js/config-min.js"></script>
<script type="text/javascript">
    BUI.use(['common/search', 'common/page'], function (Search) {

        var enumObj = {true: "男", false: "女"},
            columns = [
//                {
//                    title: '学生编号', dataIndex: 'id', width: 80,
//                    renderer: function (v) {
//                        return Search.createLink({
//                            id: 'detail' + v,
//                            title: '学生信息',
//                            text: v,
//                            href: 'detail/example.html'
//                        });
//                    }
//                },
                {title: '用户编号', dataIndex: 'id', width: '20%'},
                {title: '用户名', dataIndex: 'userName', width: '20%'},
                {title: '用户密码', dataIndex: 'pwd', width: '20%'},
                {title: '用户性别', dataIndex: 'sex', width: '20%', renderer: BUI.Grid.Format.enumRenderer(enumObj)},
                {title: '出生日期', dataIndex: 'birthDate', width: '20%', renderer: BUI.Grid.Format.dateRenderer},
                {
                    title: '操作', dataIndex: '', width: '20%', renderer: function (value, obj) {
                    var editStr = Search.createLink({ //链接使用 此方式
                            id: 'edit' + obj.id,
                            title: '编辑学生信息',
                            text: '编辑',
                            href: 'search/edit.html'
                        }),
                        delStr = '<span class="grid-command btn-del" title="删除学生信息">删除</span>';//页面操作不需要使用Search.createLink
                    return editStr + delStr;
                }
                }
            ],
            store = Search.createStore('/admin/user/search'),
            gridCfg = Search.createGridCfg(columns, {
                tbar: {
                    items: [
                        {
                            text: '<i class="icon-plus"></i>新建', btnCls: 'button button-small',
                            handler: function () {
                                alert('新建');
                            }
                        },
                        {
                            text: '<i class="icon-edit"></i>编辑', btnCls: 'button button-small',
                            handler: function () {
                                alert('编辑');
                            }
                        },
                        {
                            text: '<i class="icon-remove"></i>删除', btnCls: 'button button-small',
                            handler: delFunction
                        }
                    ]
                },
                plugins: [BUI.Grid.Plugins.CheckSelection] // 插件形式引入多选表格
            });

        var search = new Search({
                store: store,
                gridCfg: gridCfg
            }),
            grid = search.get('grid');
        //删除操作
        function delFunction() {
            var selections = grid.getSelection();
            delItems(selections);
        }

        function delItems(items) {
            var ids = [];
            BUI.each(items, function (item) {
                ids.push(item.id);
            });

            if (ids.length) {
                BUI.Message.Confirm('确认要删除选中的记录么？', function () {
                    $.ajax({
                        url: '../data/del.php',
                        dataType: 'json',
                        data: {ids: ids},
                        success: function (data) {
                            if (data.success) { //删除成功
                                search.load();
                            } else { //删除失败
                                BUI.Message.Alert('删除失败！');
                            }
                        }
                    });
                }, 'question');
            }
        }

        //监听事件，删除一条记录
        grid.on('cellclick', function (ev) {
            var sender = $(ev.domTarget); //点击的Dom
            if (sender.hasClass('btn-del')) {
                var record = ev.record;
                delItems([record]);
            }
        });
    });
</script>
</body>
</html>