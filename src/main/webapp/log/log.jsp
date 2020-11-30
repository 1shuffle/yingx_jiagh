<%@page pageEncoding="UTF-8" isELIgnored="false"  %>
<script type="text/javascript">
</script>

<script>
    $(function () {
        $("#logId").jqGrid({
            styleUI: "Bootstrap",  //使用bootstrap主题
            url:"${pageContext.request.contextPath}/log/queryAllPage",//指定服务器端地址
            datatype:"json",//指定返回数据类型
            rowNum:10,
            rowList:[10,20,30],
            pager:"#userPage", //分页
            rowNum:3, //每页展示数量
            sortname:'id',
            viewrecords: true, //总记录数
            autowidth:true, //自适应父容器
            height:"auto",
            colNames:["ID","NAME","TIMES","OPTION","STATUS"], //字段名
            colModel:[
                {name:"id"},
                {name:"name",editable:true}, //editable控制单元格是否可以点击编辑
                {name:"times",editable:true,search:false},
                {name:"option",editable:true,search:false},
                {name:"status",editable:true,search:false},
            ],
        });
        $("#logId").jqGrid('navGrid','#userPage',{edit:false,add:false,del:false});
    });
</script>
<div class="panel panel-warning">
    <div class="panel panel-heading">
        <h2>日志管理</h2>
    </div>
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab">日志展示</a></li>
    </ul>
    <div>

        <div class="col-lg-6">

        </div>
    </div>
</div>
<table id="logId"/>
<div id="userPage"/>
</div>