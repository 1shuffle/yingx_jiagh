<%@page pageEncoding="UTF-8" isELIgnored="false"  %>
<script type="text/javascript">
</script>

<script>
    $(function () {
        $("#videoId").jqGrid({
            styleUI: "Bootstrap",  //使用bootstrap主题
            url:"${pageContext.request.contextPath}/video/queryAllPage",//指定服务器端地址
            editurl:"${pageContext.request.contextPath}/video/edit",
            datatype:"json",//指定返回数据类型
            rowNum:3,
            rowList: [3, 5, 10, 20, 30],
            pager:"#userPage", //分页
             //每页展示数量
            sortname:'id',
            viewrecords: true, //总记录数
            autowidth:true, //自适应父容器
            height:"auto",
            colNames:["编号","标题","简介","视频","上传时间","点赞数","播放量"], //字段名
            colModel:[
                {name:"id"},
                {name:"title",editable:true}, //editable控制单元格是否可以点击编辑
                {name:"biref",editable:true,search:false},
                {name:"videoPath",editable:true,search:false,edittype:"file",
                formatter:function(cellvalue,options,rowObject){
                    return "<video id='media' src='"+cellvalue+"' style='height: 180px;width: 150px' controls='controls'>";
                }
                },
                {name:"uploadTime"},
                {name:"likeCount",editable:true,search:false},
                {name:"playCount",editable:true,search:false,},
            ],
        });
        $("#videoId").jqGrid('navGrid','#userPage',{edit:true,add:true,del:true,edittext: "修改", addtext: "添加", deltext: "删除"},
            {},  //修改
            {
                closeAfterAdd: true,
                afterSubmit: function (data) {
                    $.ajaxFileUpload({
                        url:"${pageContext.request.contextPath}/video/uploadVdieo",
                        type:"post",
                        data:{"id":data.responseText},
                        fileElementId:"videoPath",
                        success:function () {
                            $("#videoId").trigger("reloadGrid");
                        }
                    });
                    return "hello";
                }
            }, //添加
            {}//删除
    );
    });
</script>
<div class="panel panel-success">
    <div class="panel panel-heading">
        <h2>视频管理</h2>
    </div>
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab">视频信息</a></li>
    </ul>
    <div>
        <div class="col-lg-6">

            <div class="input-group">

      </span>

            </div><!-- /input-group -->
        </div>
    </div>
</div>
<table id="videoId"/>
<div id="userPage"/>
</div>