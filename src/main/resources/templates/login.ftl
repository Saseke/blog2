<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/common/img/favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/common/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="/login/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/login/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="/login/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/login/js/ie-emulation-modes-warning.js"></script>

    <script src="/js/jquery.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <canvas id="c_n9" width="1920" height="990"
            style="position: fixed; top: 0px; left: 0px; z-index: -1; opacity: 0.5;"></canvas>
    <script src="/js/canvas-nest.min.js"></script>
</head>

<body>

<div class="container">

    <form id="login" class="form-signin" method="post" action="/author/form">
        <h2 class="form-signin-heading">Yoke博客登录</h2>
        <label for="inputEmail" class="sr-only">Username</label>
        <input type="text" id="inputEmail" name="username" class="form-control" placeholder="Email address" required
               autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
    <#--   <div class="checkbox">
     &lt;#&ndash;      <label>
               <input type="checkbox" value="remember-me"> Remember me
           </label>&ndash;&gt;
       </div>-->
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/login/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>