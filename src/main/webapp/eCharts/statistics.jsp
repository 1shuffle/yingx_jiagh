<%@page pageEncoding="UTF-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="${pageContext.request.contextPath}/bootstrap/js/echarts.js"></script>
    <title>用户统计</title>
</head>
<body>
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '用户统计',
            subtext:"******",//子标题
            link:"${path}/main/main.jsp",
        },
        tooltip: {},
        legend: {
            data:['男孩','女孩']
        },
        xAxis: {
            data: ["一月","四月","六月","八月","十月","十二月"]
        },
        yAxis: {},
        series: [{
            name: '男孩',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
        },{
            name: '女孩',
            type: 'line',
            data: [5, 10, 20, 30, 10, 15]
        }]

    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>