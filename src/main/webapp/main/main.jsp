<%@page pageEncoding="UTF-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>应学APP后台管理系统</title>
    <link rel="icon" href="${path}/bootstrap/img/arrow-up.png" type="image/x-icon">
    <link rel="stylesheet" href="${path}/bootstrap/css/bootstrap.css">

    <%--引入jqgrid中主题css--%>
    <link rel="stylesheet" href="${path}/bootstrap/jqgrid/css/css/hot-sneaks/jquery-ui-1.8.16.custom.css">
    <link rel="stylesheet" href="${path}/bootstrap/jqgrid/boot/css/trirand/ui.jqgrid-bootstrap.css">
    <%--引入js文件--%>
    <script src="${path}/bootstrap/js/jquery.min.js"></script>
    <script src="${path}/bootstrap/js/bootstrap.js"></script>
    <script src="${path}/bootstrap/jqgrid/js/i18n/grid.locale-cn.js"></script>
    <script src="${path}/bootstrap/jqgrid/boot/js/trirand/jquery.jqGrid.min.js"></script>
    <script src="${path}/bootstrap/js/ajaxfileupload.js"></script>

</head>
<body>
    <!--顶部导航-->
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/main/main.jsp">应学视频App后台管理系统 <small>**</small></a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">


                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">欢迎:<span class="text text-info">${admin.username}</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/exit">退出</a></li>
                    <li><a href="#" class="glyphicon glyphicon-log-out"></a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!--栅格系统-->
        <!--左边手风琴部分-->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">
                <!--菜单-->
                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

                    <!--面板-->
                    <div class="panel panel-danger">
                        <div class="panel-heading" role="tab" id="headingOne">
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    <span class="glyphicon glyphicon-user"></span> 用户管理
                                </a>
                            </h4>
                        </div>
                        <!--面板内容-->
                        <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                            <div class="panel-body">
                                <ul class="list-group text-center">
                                    <li class="list-group-item"><button class="btn btn-success">
                                        <a href="javascript:$('#mainId').load('${path}/user/usertable.jsp')" >用户展示</a>
                                    </button></li>
                                    <li class="list-group-item"><button class="btn btn-success">
                                        <a href="javascript:$('#mainId').load('${path}/eCharts/statistics.jsp')" >用户统计</a>
                                    </button></li>
                                    <li class="list-group-item"><button class="btn btn-success">
                                        <a href="javascript:$('#mainId').load('${path}/eCharts/distribution.jsp')" >用户分布</a>
                                    </button></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <hr>

                    <!--面板-->
                    <div class="panel panel-info">
                        <div class="panel-heading" role="tab" id="headingTwo">
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="true" aria-controls="collapseOne">
                                    <span class="glyphicon glyphicon-th-list"></span> 分类管理
                                </a>
                            </h4>
                        </div>
                        <!--面板内容-->
                        <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                            <div class="panel-body">
                                <ul class="list-group text-center">
                                    <li class="list-group-item"><button class="btn btn-warning">
                                        <a href="javascript:$('#mainId').load('${path}/category/showCategory.jsp')">分类展示</a>
                                    </button></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <!--面板-->
                    <div class="panel panel-success">
                        <div class="panel-heading" role="tab" id="headingTho">
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTho" aria-expanded="true" aria-controls="collapseOne">
                                    <span class="glyphicon glyphicon-film"></span> 视频管理
                                </a>
                            </h4>
                        </div>
                        <!--面板内容-->
                        <div id="collapseTho" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                            <div class="panel-body">
                                <ul class="list-group text-center">
                                    <li class="list-group-item"><button class="btn btn-info">
                                        <a href="javascript:$('#mainId').load('${path}/video/videotable.jsp')" >视频统计</a>
                                    </button></li>
                                    <li class="list-group-item"><button class="btn btn-info">视频展示</button></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <!--面板-->
                    <div class="panel panel-warning">
                        <div class="panel-heading" role="tab" id="headingTh1">
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTh1" aria-expanded="true" aria-controls="collapseOne">
                                    <span class="glyphicon glyphicon-list-alt"></span> 日志管理
                                </a>
                            </h4>
                        </div>
                        <!--面板内容-->
                        <div id="collapseTh1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                            <div class="panel-body">
                                <ul class="list-group text-center">
                                    <li class="list-group-item"><button class="btn btn-info">
                                        <a href="javascript:$('#mainId').load('${path}/log/log.jsp')">日志展示</a>
                                    </button></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                <div class="col-md-10" id="mainId">

                    <div class="jumbotron">
                        <h2><b>欢迎来到应学视频APP后台管理系统</b></h2>
                    </div>
                    <div id="carousel-example-generic" style="width: 1600px;" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="4"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="5"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <img src="../bootstrap/img/pic1.jpg"  style="height: 350px;width: 100%" alt="...">
                                <div class="carousel-caption">
                                    <h3>小黄人</h3>
                                </div>
                            </div>
                            <div class="item">
                                <img src="../bootstrap/img/pic2.jpg"  style="height: 350px;width: 100%" alt="...">
                                <div class="carousel-caption">
                                    <h3>小黄人</h3>
                                </div>
                            </div>
                            <div class="item">
                                <img src="../bootstrap/img/pic3.jpg"  style="height: 350px;width: 100%" alt="...">
                                <div class="carousel-caption">
                                    <h3>小黄人</h3>
                                </div>
                            </div>
                            <div class="item">
                                <img src="../bootstrap/img/pic4.jpg"  style="height: 350px;width: 100%" alt="...">
                                <div class="carousel-caption">
                                    <h3>小黄人</h3>
                                </div>
                            </div>
                            <div class="item">
                                <img src="../bootstrap/img/5.jpg"  style="height: 350px;width: 100%" alt="...">
                                <div class="carousel-caption">
                                    <h3>小黄人</h3>
                                </div>
                            </div>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        </a>

                        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        </a>



                    </div>
                </div>

        </div>
        </div>
    </div>

        <!--巨幕开始-->




        <!--右边轮播图部分-->
        <!--页脚-->
    <!--栅格系统-->

</body>
</html>
