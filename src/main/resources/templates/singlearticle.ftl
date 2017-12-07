<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Yoke博客</title>
    <meta name="HandheldFriendly" content="True"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="shortcut icon" href="http://www.ghostchina.com/favicon.ico"/>

    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="/css/monokai_sublime.min.css"/>
    <link href="/css/magnific-popup.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/screen.css"/>
    <link rel="shortcut icon" href="/img/favicon.ico"/>
    <meta name="referrer" content="origin"/>
    <script type="text/javascript" src="/js/ghost-url.min.js"></script>
    <script src="/js/share.js"></script>
    <style id="fit-vids-style">.fluid-width-video-wrapper {
        width: 100%;
        position: relative;
        padding: 0;
    }

    .fluid-width-video-wrapper iframe, .fluid-width-video-wrapper object, .fluid-width-video-wrapper embed {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
    }</style>
    <link rel="stylesheet" href="/css/share_style0_24.css"/>
    <canvas id="c_n9" width="1920" height="990"
            style="position: fixed; top: 0px; left: 0px; z-index: -1; opacity: 0.5;"></canvas>
    <script src="/js/canvas-nest.min.js"></script>

</head>
<body class="home-template">
<!-- start header -->
<header class="main-header"
        style="background-image: url(/img/backgroud.jpg)">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <img src="/img/backgroud.jpg" alt="YokeBlog" class="hide"/>
            </div>
        </div>
    </div>
</header>
<!-- end header -->

<!-- start navigation -->
<nav class="main-navigation">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <div class="navbar-header">
                        <span class="nav-toggle-button collapsed" data-toggle="collapse" data-target="#main-menu">
                        <span class="sr-only">Toggle navigation</span>
                        <i class="fa fa-bars"></i>
                        </span>
                </div>
                <div class="collapse navbar-collapse" id="main-menu">
                    <ul class="menu">
                        <li class="nav-current" role="presentation">
                            <a href="/">首页</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</nav>
<!-- end navigation -->


<!-- start site's main content area -->
<section class="content-wrap">
    <div class="container">
        <div class="row">

            <!--/*@thymesVar id="list" type=""*/-->
            <main class="col-md-8 main-content" id="content">
                <article id="" class="post tag-android tag-ke-hu-duan">
                    <!--文章开头-->
                    <div class="post-head">
                        <h1 class="post-title"><a href="/">${article.title}</a></h1>
                        <div class="post-meta">
                            <span class="author">作者：${article.authorName}</a></span> •
                            <time class="post-date">
                                ${article.shortTime}
                            </time>
                        </div>
                    </div>
                    <!--文章正文-->
                    <div class="post-content">
                        <p>${article.content}</p>
                    </div>
                    <!--文章尾端-->
                    <footer class="post-footer clearfix">
                        <div class="pull-left tag-list">
                            <i class="fa fa-folder-open-o"></i>
                        </div>
                        <div class="pull-right share">
                        </div>
                    </footer>
                </article>
            </main>

            <aside class="col-md-4 sidebar">
                <div class="widget">
                    <h4 class="title">标签云</h4>
                    <div class="content tag-cloud">
                        <a href="">SpringBoot</a>
                        <a href="">Spring</a>
                        <a href="">jQuery</a>
                        <a href="">Java基础</a>
                        <a href="">Mybatis</a>
                        <a href="">Linux</a>
                        <a href="">SpringSecurity</a>
                    </div>
                </div>
            </aside>

        </div>
    </div>
</section>
<footer class="main-footer">
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <div class="widget">
                    <h4 class="title">最新文章</h4>
                    <div class="content recent-post">
                        <div class="recent-single-post">

                        </div>
                    </div>
                </div>
            </div>
        </div>
</footer>
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.fitvids.min.js"></script>
<script src="/js/highlight.min.js"></script>
<script src="/js/jquery.magnific-popup.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/h.js" type="text/javascript"></script>
</body>
</html>