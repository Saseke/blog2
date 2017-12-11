<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>CMS manage</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <script
            src="https://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous"></script>
</head>
<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"></div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-bg-blue layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="" id="userinfo">
                    <img src="/common/img/favicon.ico" class="layui-nav-img">
                    username
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="/logout">退了</a></li>
        </ul>
    </div>

    <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
        <li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">常用操作</a>
            <dl class="layui-nav-child">
                <dd><a onclick="showAtRight('/fragment/articlelist.html')">文章管理</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item">
            <a href="javascript:;">解决方案</a>
            <dl class="layui-nav-child">
                <dd><a href="">移动模块</a></dd>
                <dd><a href="">后台模版</a></dd>
                <dd><a href="">电商平台</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="">产品</a></li>
        <li class="layui-nav-item"><a href="">大数据</a></li>
    </ul>
    <div class="layui-body" id="content">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">内容主体区域</div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © Gangster-trio CMS.
    </div>
</div>
<!--<script src="/layui/"></script>-->
<script src="/layui/layui.all.js" type="text/javascript"></script>
</body>
</html>

<script type="text/javascript">


    function showAtRight(url) {
        $.ajax({
            url: url,
            type: 'GET',
            dataType: 'html',
            timeout: '5000',
            error: function () {
                alert('can\'t get data from ' + url);
            },
            success: function (data) {
//                document.getElementById("content").innerHTML = data;
                $("#content").html(data);
            }
        });
    }

</script>

