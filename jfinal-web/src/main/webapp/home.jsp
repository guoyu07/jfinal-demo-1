<%--
  Created by IntelliJ IDEA.
  User: sd
  Date: 17/2/16
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
    <link href="/bui/assets/css/dpl-min.css" rel="stylesheet" type="text/css"/>
    <link href="/bui/assets/css/bui-min.css" rel="stylesheet" type="text/css"/>
    <link href="/bui/assets/css/main-min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="header">

    <div class="dl-title">
        <a href="http://www.baidu.com" title="后台管理系统" target="_blank">
            <span class="dl-title-text">后台管理系统</span>
        </a>
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">SeanDragon</span>
        <a href="###" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform">
            <div class="dl-inform-title">贴心小秘书<s class="dl-inform-icon dl-up"></s></div>
        </div>
        <ul id="J_Nav" class="nav-list ks-clear">
            <li class="nav-item dl-selected">
                <div class="nav-item-inner nav-home">首页</div>
            </li>
            <%--<li class="nav-item">--%>
            <%--<div class="nav-item-inner nav-order">表单页</div>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
            <%--<div class="nav-item-inner nav-inventory">搜索页</div>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
            <%--<div class="nav-item-inner nav-supplier">详情页</div>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
            <%--<div class="nav-item-inner nav-marketing">图表</div>--%>
            <%--</li>--%>
        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="/bui/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/bui/assets/js/bui-min.js"></script>
<script type="text/javascript" src="/bui/assets/js/config.js"></script>

<script>
    BUI.use('common/main', function () {
        var config = [{
            id: 'menu',
            homePage: 'code',
            menu: [{
                text: '用户',
                items: [
                    {id: 'code', text: '查看用户', href: '/admin/user/search.html', closeable: false}
                ]
            }]
        }];

        new PageUtil.MainPage({
            modulesConfig: config
        });
    });
</script>

<!--<script>
    BUI.use('common/main', function () {
        var config = [{
            id: 'menu',
            homePage: 'code',
            menu: [{
                text: '首页内容',
                items: [
                    {id: 'code', text: '首页代码', href: 'user/list.jsp', closeable: false},
                    {id: 'main-menu', text: '顶部导航', href: 'main/menu.html'},
                    {id: 'second-menu', text: '右边菜单', href: 'main/second-menu.html'},
                    {id: 'dyna-menu', text: '动态菜单', href: 'main/dyna-menu.html'}
                ]
            }, {
                text: '页面操作',
                items: [
                    {id: 'operation', text: '页面常见操作', href: 'main/operation.html'},
                    {id: 'quick', text: '页面操作快捷方式', href: 'main/quick.html'}
                ]
            }, {
                text: '文件结构',
                items: [
                    {id: 'resource', text: '资源文件结构', href: 'main/resource.html'},
                    {id: 'loader', text: '引入JS方式', href: 'main/loader.html'}
                ]
            }]
        }, {
            id: 'form',
            menu: [{
                text: '表单页面',
                items: [
                    {id: 'code', text: '表单代码', href: 'form/code.html'},
                    {id: 'example', text: '表单示例', href: 'form/example.html'},
                    {id: 'introduce', text: '表单简介', href: 'form/introduce.html'},
                    {id: 'valid', text: '表单基本验证', href: 'form/basicValid.html'},
                    {id: 'advalid', text: '表单复杂验证', href: 'form/advalid.html'},
                    {id: 'remote', text: '远程调用', href: 'form/remote.html'},
                    {id: 'group', text: '表单分组', href: 'form/group.html'},
                    {id: 'depends', text: '表单联动', href: 'form/depends.html'}
                ]
            }, {
                text: '成功失败页面',
                items: [
                    {id: 'success', text: '成功页面', href: 'form/success.html'},
                    {id: 'fail', text: '失败页面', href: 'form/fail.html'}

                ]
            }, {
                text: '可编辑表格',
                items: [
                    {id: 'grid', text: '可编辑表格', href: 'form/grid.html'},
                    {id: 'form-grid', text: '表单中的可编辑表格', href: 'form/form-grid.html'},
                    {id: 'dialog-grid', text: '使用弹出框', href: 'form/dialog-grid.html'},
                    {id: 'form-dialog-grid', text: '表单中使用弹出框', href: 'form/form-dialog-grid.html'}
                ]
            }]
        }, {
            id: 'search',
            menu: [{
                text: '搜索页面',
                items: [
                    {id: 'code', text: '搜索页面代码', href: 'search/code.html'},
                    {id: 'example', text: '搜索页面示例', href: 'search/example.html'},
                    {id: 'example-dialog', text: '搜索页面编辑示例', href: 'search/example-dialog.html'},
                    {id: 'introduce', text: '搜索页面简介', href: 'search/introduce.html'},
                    {id: 'config', text: '搜索配置', href: 'search/config.html'}
                ]
            }, {
                text: '更多示例',
                items: [
                    {id: 'tab', text: '使用tab过滤', href: 'search/tab.html'}
                ]
            }]
        }, {
            id: 'detail',
            menu: [{
                text: '详情页面',
                items: [
                    {id: 'code', text: '详情页面代码', href: 'detail/code.html'},
                    {id: 'example', text: '详情页面示例', href: 'detail/example.html'},
                    {id: 'introduce', text: '详情页面简介', href: 'detail/introduce.html'}
                ]
            }]
        }, {
            id: 'chart',
            menu: [{
                text: '图表',
                items: [
                    {id: 'code', text: '引入代码', href: 'chart/code.html'},
                    {id: 'line', text: '折线图', href: 'chart/line.html'},
                    {id: 'area', text: '区域图', href: 'chart/area.html'},
                    {id: 'column', text: '柱状图', href: 'chart/column.html'},
                    {id: 'pie', text: '饼图', href: 'chart/pie.html'},
                    {id: 'radar', text: '雷达图', href: 'chart/radar.html'}
                ]
            }]
        }];
        new PageUtil.MainPage({
            modulesConfig: config
        });
    });
</script>-->
</body>
</html>