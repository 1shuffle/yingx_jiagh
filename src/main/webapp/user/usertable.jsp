<%@page pageEncoding="UTF-8" isELIgnored="false"  %>
<script type="text/javascript">
    function but(){
        $.ajax({
            type: "POST",
            dataType: "json",//返回的数据类型
            url: "${pageContext.request.contextPath}/user/phone" ,
            data: $('#ph').serialize(),//from表单 的id="login"
            error:function() {
                alert("发送成功");
                //location.reload();//刷新页面
            }
        });
    }
</script>
<script type="text/javascript">
    function poi(){
        $.ajax({
            type: "GET",
            dataType: "json",//返回的数据类型
            url: "${pageContext.request.contextPath}/user/poi" ,
            success:function() {
                alert("导出成功");
                //location.reload();//刷新页面
            }
        });
    }
</script>

<script>
    $(function () {
        $("#userId").jqGrid({
            styleUI: "Bootstrap",  //使用bootstrap主题
            url:"${pageContext.request.contextPath}/user/findAll",//指定服务器端地址
            datatype:"json",//指定返回数据类型
            rowNum:10,
            rowList:[10,20,30],
            pager:"#userPage", //分页
            rowNum:3, //每页展示数量
            sortname:'id',
            viewrecords: true, //总记录数
            autowidth:true, //自适应父容器
            height:"auto",
            colNames:["编号","姓名","电话","图片","简介","学分","时间","状态"], //字段名
            colModel:[
                {name:"id"},
                {name:"nick_name",editable:true}, //editable控制单元格是否可以点击编辑
                {name:"phone",editable:true,search:false},
                {name:"pic_img",editable:true,search:false ,formatter:function(value,options,row){
                    return '<img style="height:50px;" src="${pageContext.request.contextPath}/bootstrap/img/'+row.pic_img+'"/>';
                    }},
                {name:"brief",editable:true,search:false},
                {name:"score",editable:true,search:false},
                {name:"create_date",editable:true,search:false},
                {name:"status",editable:true,search:false,formatter:function(value,options,row){
                    if(value==1){
                        return "<button class='btn btn-success'>正常</button>";
                    }else{
                        return "<button class='btn btn-danger'>冻结</button>";
                    }
                    }},
            ],
        });
        $("#userId").jqGrid('navGrid','#userPage',{edit:false,add:false,del:false});
    });
</script>
<div class="panel panel-danger">
      <div class="panel panel-heading">
    <h2>用户管理</h2>
     </div>
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab">用户信息</a></li>
    </ul>
    <div>
        <button class="btn btn-success" type="submit" onclick="poi()">导出用户信息</button>
        <div class="col-lg-6">

        <div class="input-group">
            <input type="text" class="form-control" id="ph" name="phonenumbers" placeholder="Search for...">
            <span class="input-group-btn">
        <button class="btn btn-info" type="submit" onclick="but()">发送验证码</button>
      </span>

        </div><!-- /input-group -->
        </div>
    </div>
    </div>
    <table id="userId"/>
    <div id="userPage"/>
</div>